package com.shufensoft.crm.common.utils;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *   
 *  @ProjectName: sf-parent  
 *  @Description: 
 *  @author chenqiang  chenqiang@shufensoft.com
 *  @date 2015-05-26 16:33  
 */
public class DateUtil {

    private static Logger log = Logger.getLogger(DateUtil.class);
    /**
     * yyyy-MM-dd HH:mm:ss 格式
     */
    public static final String DEFAULT_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm 格式
     */
    public static final String DEFAULT_DATE_TIME_HHmm_FORMAT_PATTERN = "yyyy-MM-dd HH:mm";
    /**
     * yyyy-MM-dd HH 格式
     */
    public static final String DEFAULT_DATE_TIME_HH_FORMAT_PATTERN = "yyyy-MM-dd HH";
    /**
     * yyyy-MM-dd 格式
     */
    public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    /**
     * HH:mm:ss 格式
     */
    public static final String DEFAULT_TIME_FORMAT_PATTERN = "HH:mm:ss";
    /**
     * HH:mm 格式
     */
    public static final String DEFAULT_TIME_HHmm_FORMAT_PATTERN = "HH:mm";
    /**
     * yyyy/MM/dd HH:mm 格式
     */
    public static final String DEFAULT_DATE_TIME_HHmm_FORMAT_PATTERN_1 = "yyyy/MM/dd HH:mm";

    /**
     * 年
     * <p>可以通过DateTime.now().get(DateTime.YEAR_FIELD)来获取当前时间的年</p>
     */
    public static final int YEAR_FIELD = java.util.Calendar.YEAR;
    /**
     * 月
     * <p>可以通过DateTime.now().get(DateTime.MONTH_FIELD)来获取当前时间的月</p>
     */
    public static final int MONTH_FIELD = java.util.Calendar.MONTH;
    /**
     * 日
     * <p>可以通过DateTime.now().get(DateTime.DAY_FIELD)来获取当前时间的日</p>
     */
    public static final int DAY_FIELD = java.util.Calendar.DATE;
    /**
     * 小时 <p>可以通过DateTime.now().get(DateTime.HOUR_FIELD)来获取当前时间的小时</p>
     */
    public static final int HOUR_FIELD = java.util.Calendar.HOUR_OF_DAY;
    /**
     * 分钟 <p>可以通过DateTime.now().get(DateTime.MINUTE_FIELD)来获取当前时间的分钟</p>
     */
    public static final int MINUTE_FIELD = java.util.Calendar.MINUTE;
    /**
     * 秒
     * <p>可以通过DateTime.now().get(DateTime.SECOND_FIELD)来获取当前时间的秒</p>
     */
    public static final int SECOND_FIELD = java.util.Calendar.SECOND;
    /**
     * 毫秒 <p>可以通过DateTime.now().get(DateTime.MILLISECOND_FIELD)来获取当前时间的毫秒</p>
     */
    public static final int MILLISECOND_FIELD = java.util.Calendar.MILLISECOND;
    private java.util.Calendar c;   //日历类
    /**
     * yyyy-MM-dd  格式
     */
    private static final SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * MM-dd 格式
     */
    private static final DateFormat mdSdf = new SimpleDateFormat("MM-dd");

    /**
     * CST 格式
     */
    private static final SimpleDateFormat cstFormater = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
    /**
     * yyyy-MM-dd HH 格式
     */
    private static final SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
    /**
     * yyyy-MM-dd HH:mm:ss 格式
     */
    private static final SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * yyyy/MM/dd HH:mm:ss 格式
     */
    private static final SimpleDateFormat longOtherSdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    /**
     * @param date 日期
     * @return String:yyyy-MM-dd
     */
    public static String dateToShortStr(Date date) {

        return shortSdf.format(date);

    }

    /**
     * 将字符串日期转换为日期类型，yyyy/MM/dd HH:mm:ss
     *
     * @param dateStr 字符串日期
     * @return Date:yyyy/MM/dd HH:mm:ss
     */
    public static Date strToLongOtherDate(String dateStr) {
        Date date = null;
        try {
            date = longOtherSdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串日期转换为日期类型，yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr 字符串日期
     * @return Date:yyyy-MM-dd HH:mm:ss
     */
    public static Date strToDate(String dateStr) {
        Date date = null;
        try {
            date = longSdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串日期转换日期类型，yyyymmddhhmmss
     *
     * @param dateStr
     * @return
     */
    public static Date strDateToDate(String dateStr) {

        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(4, 6);
        String day = dateStr.substring(6, 8);
        String h = dateStr.substring(8, 10);
        String m = dateStr.substring(10, 12);
        String s = dateStr.substring(12, 14);

        String strDate = year + "-" + month + "-" + day + " " + h + ":" + m + ":" + s;

        return strToDate(strDate);
    }

    /**
     * 取指定天数后的日期，时分秒置为0,一般用来计算若干天后的过期日期
     *
     * @param days
     * @return
     */
    public static final Date getExpiredDay(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.DATE, days);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 取指定分钟过期时间
     *
     * @param days
     * @return
     */
    public static final Date getExpiredMinute(int days) {

        Calendar cal = Calendar.getInstance();
        //cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.MINUTE, days);

        return cal.getTime();
    }

    /**
     * 指定日期与当前日期相差的天数
     *
     * @param date
     * @return
     */
    public static final int getBetweenDays(Date date) {
        long milliSeconds = System.currentTimeMillis() - date.getTime();

        return (int) (milliSeconds / 1000 / 24 / 3600);
    }

    /**
     * 获得本月的开始时间，如2015-06-01 00:00:00
     *
     * @return
     */
    public static final Date getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }


    public static int compare_date(String DATE1, String DATE2) {


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


//    public static boolean compare_date(Date DATE1, Date DATE2) {
//
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//        try {
//            Date dt1 = DATE1;
//            Date dt2 =DATE2;
//            if (dt1.getTime() > dt2.getTime()) {
//                System.out.println("dt1 在dt2前");
//                return ture;
//            } else if (dt1.getTime() < dt2.getTime()) {
//                System.out.println("dt1在dt2后");
//                return false;
//            } else{
//                //
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return 0;
//    }


    /**
     * 获取昨天结束时间
     *
     * @return
     */
    public static final Date getYearterDayEndTime() {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            //c.set(Calendar.DATE,1);
            c.add(Calendar.DATE, -1);
            date = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取N天前的结束时间 23:59:59
     *
     * @param n
     * @return
     */
    public static final Date getNDayEndTime(Integer n) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            c.add(Calendar.DATE, -n);
            date = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取N天前的开始时间 00：00：00
     *
     * @param n
     * @return
     */
    public static final Date getNDayStartTime(Integer n) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            c.add(Calendar.DATE, -n);
            date = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 当前月的结束时间，如2015-06-31 23:59:59
     *
     * @return
     */
    public static final Date getCurrentMonthEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * data 转换成 字符串
     * 格式为： yyyy-MM-dd HH:mm:ss
     */
    public static String getDateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_PATTERN);
        return format.format(date);
    }

    /**
     * 格式为yyyy-MM-dd HH:mm:ss字符串转换成date
     */
    public static Date getDateFromString(String datesStr) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_PATTERN);
        try {
            if (StringUtils.isBlank(datesStr)) {
                throw new IllegalArgumentException("datesStr is null");
            }
            return format.parse(datesStr);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * yyyy/MM/dd HH:mm格式的字符串转换成yyyy-MM-dd HH:mm格式的date
     */
    public static Date getDateFromStr(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_HHmm_FORMAT_PATTERN_1);
        try {
            Date d = format.parse(str);
            String ss = getDateToString(d);
            return getDateFromString(ss);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 操作一个给定的时间，可以在此基础上进行年，月，日，时，分，秒的任意相加减，
     */
    public static Date operateDate(Date date, int yearOffset, int monthOffset, int dayOffset, int hourOffset,
                                   int minuteOffset, int secondOffset) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        int dayOfWeekInMonth = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        int hour = cal.get(Calendar.HOUR);
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int millisecond = cal.get(Calendar.MILLISECOND);
        cal.set(year + yearOffset, month + monthOffset, dayOfMonth + dayOffset, hourOfDay + hourOffset,
                minute + minuteOffset, second + secondOffset);
        Date d = cal.getTime();
        return getYMDHMSDate(d);
    }

    /**
     * @param date
     * @return Date  yyyy-MM-dd HH:mm:ss
     */
    public static Date getYMDHMSDate(Date date) {
        return getDateFromString(getDateToString(date));
    }

    /**
     *
     * */
    public static String getCurrentDateToStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_PATTERN);
        return simpleDateFormat.format(new Date());
    }

    /**
     * @param date yyyy-MM-dd HH:mm:ss
     * @return Date yyyy-MM-dd
     */
    public static Date getDateToDate(Date date) {
        String dateStr = dateToShortStr(date);

        try {
            return shortSdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param date yyyy-MM-dd HH:mm:ss
     * @return Date MM-dd
     */
    public static Date getDateToMdDate(Date date) {
        //String dateStr = dateToShortStr(date);
        String dateStr = mdSdf.format(date);
        try {
            return mdSdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param cstTime Jul 17 12:54:52 CST 2015
     * @return String 2015-07-17 12:54:52
     */
    public static String parseCSTTime(String cstTime) {

        try {
            Date gpsUTCDate = cstFormater.parse(cstTime);
            return longSdf.format(gpsUTCDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 获取当天的开始时间和结束时间
     *
     * @param beginOrEndTime 00:00:00表示开始时间, 23:59:59 表示结束时间
     */
    public static Date getCurrentBeginDateTime(String beginOrEndTime) {
        String shortDate = shortSdf.format(new Date());
        String dateTime = shortDate + " " + beginOrEndTime;
        try {
            Date returnDate = longSdf.parse(dateTime);
            return returnDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param date yyyy-MM-dd hh:mm:ss
     * @return yyyy-MM-dd
     */
    public static Date convertNormalDateToShort(Date date) {
        if (date == null) {
            return null;
        }

        String shortDateStr = shortSdf.format(date);
        try {

            Date shortDate = shortSdf.parse(shortDateStr);
            return shortDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] agrs) {

        System.out.println(getExpiredMinute(-30));

        Date d = strDateToDate("20150910145818");
        System.out.println(longSdf.format(d));


    }


}
