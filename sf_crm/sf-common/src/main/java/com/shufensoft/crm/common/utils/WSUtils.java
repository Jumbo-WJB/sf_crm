package com.shufensoft.crm.common.utils;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by apple on 15/6/15.
 */
public class WSUtils {






    /**
     * 取得webservice操作 *
     * @param message * :传值数组 *
     * @param method    * ：webservice 方法名 *
     * @param url       * ：wsdl路径 *
     * @param nameSpace * ：webservice命名空间 *
     * @param parameter * ：webservice参数数组 *
     * @return
     */
    public static Object getWebService(Object[] message, String method, String url, String nameSpace, String[] parameter) {
        Service service = new Service();
        Object obj = null;
        Call call;
        try {
            // 创建连接
            call = (Call) service.createCall();
            // 设置webservice地址
            call.setTargetEndpointAddress(new java.net.URL(url));
            // 设置调用的方法名（包含方法所在的命名空间）
            call.setOperationName(new QName(nameSpace, method));
            // 设置调用时需要传入的参数（包含参数所属方法所对应的命名空间）
            for(String key :parameter){
                call.addParameter(new QName(nameSpace, key), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            }
            call.setUseSOAPAction(true);
            // 设置返回参数类型
            call.setReturnType(org.apache.axis.Constants.XSD_STRING);
            // 设置操作方法完整路径（包含命名空间与方法名）
            call.setSOAPActionURI(nameSpace + method);
//            String messageString = "";
////            for (String value:message){
////                messageString = messageString +value + ",";
////            }
//            String m = messageString.substring(0,messageString.length()-1);
            // 执行调用过程并传入调用时所需参数
            obj = call.invoke(message);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;
    }
}


