import com.shufensoft.crm.common.utils.BeanCopierUtils;
import org.junit.Test;

import java.util.Date;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/7/19  
 */

public class TestBeanUtils {

    @Test
    public void foo(){
        Bean1 one = new Bean1();
        one.setBirthday(new Date());
        one.setId(1L);
        one.setName("liulin");
        Bean2 two = new Bean2();

        BeanCopierUtils.beanCopyByApacheBeanUtils(two,one);
//        System.out.println(two);

        String ss = "2:4:尺码:S;3:7:颜色:红色;";
        String[] arr = ss.split(";");
        System.out.println("length:" + arr.length);
        for(String s : arr){
            System.out.println(s);
        }
    }
}
