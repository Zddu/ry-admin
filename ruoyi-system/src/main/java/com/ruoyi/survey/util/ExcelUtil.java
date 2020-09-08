package com.ruoyi.survey.util;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @date 2020/9/7 -- 20:54
 **/
public class ExcelUtil {
    private static Configuration configuration =null;
    private static Map<String, Template> allTemplates =null;

    public static AjaxResult exportExcel(Map<?, ?> dataMap,String templateName,String fileName) {
        byte[] excelByte = getExcelByte(dataMap, templateName);
        try {
            new FileOutputStream(getAbsoluteFile(fileName)).write(excelByte);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error("文件创建失败");
        }
        return AjaxResult.success(fileName);
    }
    private static byte[] getExcelByte(Map<?, ?> dataMap,String templateName){
        Template template =null;
        try {
            configuration = new Configuration(Configuration.VERSION_2_3_0);
            configuration.setDefaultEncoding("UTF-8");
            String url = ResourceUtils.getURL("classpath:").getPath()+ "template";
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
    private static String getAbsoluteFile(String filename)
    {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

}
