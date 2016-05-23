package com.shufensoft.crm.common.utils;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/27  
 */
public class HTMLParseUtil {

    /**
     *  读取文件内容
     * */
    public static String getFileContent(String filePath) {
        try {
            File file = new File(filePath);
            boolean flag = file.exists();
            if(!flag){                   //不存在
                return "";
            }
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String szContent="";
            String szTemp;
            while ( (szTemp = bis.readLine()) != null) {
                szContent+=szTemp+"\n";
            }
            bis.close();
            return szContent;
        }
        catch( Exception e ) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 这里获取商品详情页的内容
     * */
    public static String getNodeContent(String content, final String keyword){
        Parser parser = null;
        try {
            parser = new Parser(content);
//            org.htmlparser.util.NodeIterator ite =  parser.elements();
            NodeList nls = parser.parse(new NodeFilter() {
                @Override
                public boolean accept(Node node) {
                    String text = node.getText();
                    if(text.indexOf(keyword) >= 0){
                        return true;
                    }
                    return false;
                }
            });
            String messge = "";
            if(nls != null && nls.elementAt(0) != null){
                messge = nls.elementAt(0).toHtml();
            }
            return messge;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(parser!=null){
                parser.reset();
            }
        }
        return null;
    }

    public static String detailContext(String filePath){
        String content = getFileContent(filePath);
        String result = getNodeContent(content,"div class=\"row\"");
        result = result.replace("\n","");
        String resultAdapter = "";
        if(org.apache.commons.lang.StringUtils.isNotBlank(result)){
            String s1 = result.substring(20);
            resultAdapter = s1.substring(0,s1.length()-6);
        }
        return resultAdapter;
    }



    public static void main(String[] args){
//        String filePath = "c:\\2.html";
        String filePath = "C:\\work\\sf_crm\\sf-web\\src\\main\\webapp\\static\\201507\\ea62f63d-fa5f-40f2-abbb-16d8997c5227.html";

        File file = new File(filePath);
        boolean flag = file.exists();
        System.out.println("flag====" + flag);

//        String content = getFileContent(filePath);
////        System.out.println(content);
//        String result = detailContext(filePath);
//        System.out.println(result);
    }

}
