package com.shufensoft.crm.common.api.express;

/**
 *   
 *  @ProjectName: sf-crm 
 *  @Description: <p>
 * </p>
 *  @author: lisen  lisen@suniusoft.com
 *  @date: 2015/7/7  
 */
public class Demo {
    public static void main(String adfas[]) throws  Exception{
        String res=new ShowApiRequest("http://route.showapi.com/64-19","1910","37f9b079f78b40a986cf97a00525c4c1")
                .addTextPara("nu", "390025054606")
                .addTextPara("com", "quanfeng")
                .post();
        System.out.println(res);

    }
}
