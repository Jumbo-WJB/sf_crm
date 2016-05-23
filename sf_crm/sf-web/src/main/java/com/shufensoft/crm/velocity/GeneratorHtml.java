package com.shufensoft.crm.velocity;


import com.shufensoft.crm.common.utils.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 *   
 *  @ProjectName: sf_crm 
 *  @Description: <p>
 * </p>
 *  @author: lin
 *  @date: 2015/6/23  
 */
public class GeneratorHtml {


    private static final Properties pro = new Properties();

    public static String createProductDetail(String content, ServletContext context, String rootPath, Long sellerId) throws Exception{
        String templatePath = context.getRealPath("WEB-INF/template/mobile/mall");
        pro.put(Velocity.FILE_RESOURCE_LOADER_PATH, templatePath);
        pro.load(GeneratorHtml.class.getClassLoader().getResourceAsStream("velocity.properties"));
        pro.put(Velocity.INPUT_ENCODING, "utf-8");
        pro.put(Velocity.OUTPUT_ENCODING, "utf-8");
        Velocity.init(pro);
        String realPath = context.getRealPath("upload/static") + File.separator;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        String savePath = realPath + File.separator + sellerId + File.separator + ymd + File.separator;
        String fileName = StringUtils.getUUID() + ".html";
        File parentFile = new File(savePath);
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        File file = new File(savePath, fileName);
        Template temp = Velocity.getTemplate("detail.vm","UTF-8");
        VelocityContext vc = new VelocityContext();
        vc.put("rootPath", rootPath);
        vc.put("content", content);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter ow = new OutputStreamWriter(fos,"UTF-8");
        temp.merge(vc, ow);
        ow.flush();
        fos.close();
        ow.close();
        return "upload/static" + File.separator + sellerId + File.separator + ymd + File.separator + fileName;
    }



    public static void main(String[] args){
        Map<String,String> map = System.getenv();

        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " == " + entry.getValue());
        }
    }

}
