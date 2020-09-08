package com.ruoyi.survey.util;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.survey.domain.vo.QfKeyIndexAnswer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
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
    private static String getAbsoluteFile(String filename) {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

    /**
     * 导出excel
     *
     * @return
     */
    public static ResponseEntity<byte[]> emloyeeExcel(List<String> titles, List<QfKeyIndexAnswer> values) {
        //1,创建一个excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2,创建文档摘要
        workbook.createInformationProperties();
        //5,创建样式
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        int columnNum = titles.size();
        //设置表头背景颜色
        hssfCellStyle.setFillForegroundColor(IndexedColors.WHITE.index);
        hssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = workbook.createSheet("员工信息表");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell=null;
        for (int i=0;i<columnNum;i++){
            sheet.setColumnWidth(i,10*256);
            cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(hssfCellStyle);
        }


        for (int i = 0;i<values.size();i++){
            QfKeyIndexAnswer answer = values.get(i);
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(answer.getKeyIndex()).setCellValue(answer.getValue());
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            //避免中文乱码设置字符编码格式
            headers.setContentDispositionFormData("attachment",new String("员工信息表.xls".getBytes("UTF-8"),"ISO-8859-1"));
            //设置成下载文件
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //将文件写入到输出流，通过输出流转换成byte数组
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

}
