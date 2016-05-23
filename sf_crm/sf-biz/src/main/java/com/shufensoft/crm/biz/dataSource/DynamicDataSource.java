package com.shufensoft.crm.biz.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.shufensoft.crm.biz.domain.generation.system.DataSourceConfig;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *   
 *  @ProjectName: sf-crm  
 *  @Description: 实现动态数据源切换逻辑
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/16  
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    private static final Logger logger = Logger.getLogger(DynamicDataSource.class);

    private Map<Object, Object> _targetDataSources;

    /**
     * <p>
     * 数据源为空时，自动切换至默认数据源，
     * 即在配置文件中定义的dataSource数据源
     * </p>
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {

        String dataSourceName = DBContextHolder.getDataSourceKey();

        String nextDataSourceName = null;
        if (StringUtils.isNotBlank(dataSourceName) && dataSourceName.indexOf(",") != -1) {
            String[] dataSourceIds = dataSourceName.split(",");
            dataSourceName = dataSourceIds[0];
            nextDataSourceName = dataSourceIds[1];
        }

        if (StringUtils.isBlank(dataSourceName) || "0".equals(dataSourceName)) {
            dataSourceName = "baseDataSource";
        } else {
            this.selectDataSource(dataSourceName);
        }

        logger.debug("use datasource datasource_id=" + dataSourceName);

        if (StringUtils.isNotBlank(nextDataSourceName)) {
            DBContextHolder.setDataSourceKey(nextDataSourceName);
        }

        return dataSourceName;

    }

    public void setTargetDataSources(Map<Object, Object> targetDataSources) {

        _targetDataSources = targetDataSources;
        super.setTargetDataSources(_targetDataSources);
        afterPropertiesSet();

    }

    public void addTargetDataSource(String key, DataSource dataSource) {

        _targetDataSources.put(key, dataSource);
        this.setTargetDataSources(_targetDataSources);

    }


    /**
     * 创建数据源
     *
     * @param dataSourceConfig
     * @return
     */
    public DataSource createDataSource(DataSourceConfig dataSourceConfig) {

        return createDruidDataSource(dataSourceConfig);
    }

    /**
     * 创建Druid数据源
     *
     * @param dataSourceConfig
     * @return
     */
    public DruidDataSource createDruidDataSource(DataSourceConfig dataSourceConfig) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceConfig.getDriverClassName());

        dataSource.setUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUserName());
        dataSource.setPassword(dataSourceConfig.getPasswd());

        /**
         * 初始化连接数量
         */
        dataSource.setInitialSize(dataSourceConfig.getInitialPoolSize());
        /**
         * 最大并发连接数
         */
        dataSource.setMaxActive(dataSourceConfig.getMaxActive());

        /**
         * 最小空闲连接数
         */
        dataSource.setMinIdle(dataSourceConfig.getMinIdle());

        /**
         * 配置获取连接等待超时的时间
         */
        dataSource.setMaxWait(6000);

        /**
         *  配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
         */
        dataSource.setTimeBetweenEvictionRunsMillis(6000);

        dataSource.setMinEvictableIdleTimeMillis(300000);

        /**
         *  用来检测连接是否有效的sql，要求是一个查询语句
         */
        dataSource.setValidationQuery("SELECT 1 FROM DUAL");

        /**
         *   申请连接的时候检测
         */
        dataSource.setTestWhileIdle(true);

        /**
         * 申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能
         */
        dataSource.setTestOnBorrow(false);

        /**
         * 归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能
         */
        dataSource.setTestOnReturn(false);

        /**
         *  打开PSCache，并且指定每个连接上PSCache的大小
         */
        dataSource.setPoolPreparedStatements(true);


        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

        /**
         * 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：
         * 监控统计用的filter:stat
         * 日志用的filter:log4j
         * 防御SQL注入的filter:wal
         */
        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            logger.error(e);
        }


        return dataSource;
    }


    /**
     * 创建C3P0连接池，改方法已经过时，改用druid连接池
     *
     * @param dataSourceConfig
     * @return
     */
    @Deprecated
    public ComboPooledDataSource createComboPooledDataSource(DataSourceConfig dataSourceConfig) {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(dataSourceConfig.getDriverClassName());
        } catch (PropertyVetoException e) {
            logger.error(e.getMessage(), e);
        }

        dataSource.setJdbcUrl(dataSourceConfig.getUrl());
        dataSource.setUser(dataSourceConfig.getUserName());
        dataSource.setPassword(dataSourceConfig.getPasswd());
        dataSource.setAcquireIncrement(10);
        /**
         *  定义在从数据库获取新连接失败后重复尝试获取的次数，默认为30
         */
        dataSource.setAcquireRetryAttempts(40);
        /**
         *  两次连接中间隔时间，单位毫秒，默认为1000
         */
        dataSource.setAcquireRetryDelay(2000);

        /**
         *   连接关闭时默认将所有未提交的操作回滚。默认为false
         */
        dataSource.setAutoCommitOnClose(false);
        /**
         * 获取连接失败将会引起所有等待获取连接的线程抛出异常。但是数据源仍有效保留，并在下次调
         * 用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试获取连接失败后该数
         * 据源将申明已断开并永久关闭。默认为 false；
         **/
        dataSource.setBreakAfterAcquireFailure(false);

        /**
         * 当连接池用完时客户端调用getConnection()后等待获取新连接的时间，
         * 超时后将抛出SQLException，如设为0则无限期等待。单位毫秒，默认为0；
         */
        dataSource.setCheckoutTimeout(3000);

        /**
         *  始化时创建的连接数，应在minPoolSize与maxPoolSize之间取值。默认为3
         */
        dataSource.setInitialPoolSize(20);
        /**
         * 每60秒检查所有连接池中的空闲连接
         */
        dataSource.setIdleConnectionTestPeriod(60);

        /**
         * 接池中保留的最小连接数
         */
        dataSource.setMinPoolSize(20);

        /**
         * 接池中保留的最大连接数,默认为15
         */
        dataSource.setMaxPoolSize(50);

        /**
         *  最大空闲时间，超过空闲时间的连接将被丢弃。为0或负数则永不丢弃。默认为0
         */
        dataSource.setMaxIdleTime(60);

        dataSource.setMaxIdleTime(60);
        dataSource.setUnreturnedConnectionTimeout(25);
        dataSource.setMaxIdleTimeExcessConnections(20);
        dataSource.setMaxConnectionAge(20);
        /**
         * JDBC的标准参数，用以控制数据源内加载的PreparedStatement数量。但由于预缓存的Statement属
         * 于单个Connection而不是整个连接池。所以设置这个参数需要考虑到多方面的因素，如果maxStatements与
         *  maxStatementsPerConnection均为0，则缓存被关闭。默认为0；
         */
        dataSource.setMaxStatements(0);

        /**
         * 连接池内单个连接所拥有的最大缓存Statement数。默认为0
         */
        dataSource.setMaxStatementsPerConnection(0);

        /**
         *   C3P0是异步操作的，缓慢的JDBC操作通过帮助进程完成。扩展这些操作可以有效的提升性能，
         *   通过多线程实现多个操作同时被执行。默认为3；
         */
        dataSource.setNumHelperThreads(3);

        /**
         *  用户修改系统配置参数执行前最多等待的秒数。默认为300
         */
        dataSource.setPropertyCycle(600);

        return dataSource;
    }


    /**
     * 数据源存在时不做处理，不存在时创建
     * 新的数据源链接，并将新数据链接添加至缓存
     *
     * @param datasourceId
     */
    public void selectDataSource(String datasourceId) {

        Object sid = DBContextHolder.getDataSourceKey();
        if ("0".equals(datasourceId)) {
            DBContextHolder.setDataSourceKey("0");
            return;
        }

        Object obj = _targetDataSources.get(datasourceId);

        if (null != obj && sid.equals(datasourceId)) {
            return;
        }

        DataSource dataSource = this.getDataSource(datasourceId);
        if (null != dataSource) {
            this.setDataSource(datasourceId, dataSource);
        }

    }

    /**
     * 查询serverId对应的数据源记录
     *
     * @param datasourceId
     * @return
     */
    public DataSource getDataSource(String datasourceId) {

        this.selectDataSource("0");
        this.determineCurrentLookupKey();
        Connection conn = null;
        HashMap<String, Object> map = null;

        try {

            conn = this.getConnection();
            PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM datasource_config WHERE id = ?");
            ps.setLong(1, Long.valueOf(datasourceId));
            ResultSet rs = ps.executeQuery();
            map = new HashMap<String, Object>();

            if (rs.next()) {
                map.put("driver_class_name", rs.getString("driver_class_name"));
                map.put("url", rs.getString("url"));
                map.put("user_name", rs.getString("user_name"));
                map.put("passwd", rs.getString("passwd"));
                map.put("initial_pool_size", rs.getInt("initial_pool_size"));
                map.put("max_active", rs.getInt("max_active"));
                map.put("min_idle", rs.getInt("min_idle"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {

            logger.error(e);

        } finally {

            try {
                conn.close();
            } catch (SQLException e) {
                logger.error(e);
            }

        }

        if (!CollectionUtils.isEmpty(map)) {

            String driverClassName = map.get("driver_class_name").toString();
            String url = map.get("url").toString();
            String userName = map.get("user_name").toString();
            String password = map.get("passwd").toString();
            Integer initialPoolSiz = (Integer) map.get("initial_pool_size");
            Integer maxActive = (Integer) map.get("max_active");
            Integer minIdle = (Integer) map.get("min_idle");

            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setDriverClassName(driverClassName);
            dataSourceConfig.setUrl(url);
            dataSourceConfig.setUserName(userName);
            dataSourceConfig.setPasswd(password);
            dataSourceConfig.setInitialPoolSize(initialPoolSiz);
            dataSourceConfig.setMaxActive(maxActive);
            dataSourceConfig.setMinIdle(minIdle);

            DataSource dataSource = this.createDataSource(dataSourceConfig);

            return dataSource;

        }

        return null;
    }


    /**
     * @param datasourceId   卖家id
     * @param dataSource
     */
    public void setDataSource(String datasourceId, DataSource dataSource) {

        this.addTargetDataSource(datasourceId, dataSource);

        DBContextHolder.setDataSourceKey(String.valueOf(datasourceId));

    }
}
