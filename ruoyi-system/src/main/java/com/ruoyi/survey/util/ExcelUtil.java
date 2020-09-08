package com.ruoyi.survey.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2020/9/7 -- 20:54
 **/
public class ExcelUtil {
    private static Configuration configuration =null;
    private static Map<String, Template> allTemplates =null;

    public static void exportExcel(Map<?, ?> dataMap,String templateName,HttpServletResponse response,String fileName){
        byte[] excelByte = getExcelByte(dataMap, templateName);
        response.setContentType("application/octet-stream");
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            response.setHeader("Content-Disposition", "attachment; filename="  + URLEncoder.encode(fileName, "UTF-8"));
            outputStream.write(excelByte);
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static byte[] getExcelByte(Map<?, ?> dataMap,String templateName){
        Template template =null;
        try {
            configuration = new Configuration(Configuration.VERSION_2_3_0);
            configuration.setDefaultEncoding("UTF-8");
            String url = ResourceUtils.getURL("classpath:").getPath()+"template";
            configuration.setDirectoryForTemplateLoading(new File(url.substring(1)));
            template =configuration.getTemplate(templateName);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }


        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            Writer w = new OutputStreamWriter(bos, "utf-8");
            template.process(dataMap, w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bos.toByteArray();
    }

}
