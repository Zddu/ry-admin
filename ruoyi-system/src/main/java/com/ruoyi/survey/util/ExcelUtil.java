package com.ruoyi.survey.util;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.survey.domain.vo.QfKeyIndexAnswer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
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
//    public static void  test(List<String> titles,String fileName) throws IOException {
//
//        ByteArrayOutputStream bos=new ByteArrayOutputStream();
//        workbook.write(bos);
//        workbook.close();
//        File file = new File("C:\\Users\\Administrator\\Desktop\\excelTemplate\\"+fileName);
//        byte[] bytes = bos.toByteArray();
//        BufferedOutputStream bufferos =new BufferedOutputStream(new FileOutputStream(file));
//        bufferos.write(bytes);
//        bufferos.flush();
//        bufferos.close();
//
//
//    }
    public static AjaxResult emloyeeExcel(List<String> titles,String fileName){
        return emloyeeExcel(titles,new ArrayList<>(),fileName);
    }
    public static AjaxResult emloyeeExcel(List<String> titles, List<List<QfKeyIndexAnswer>> values,String fileName) {

        //1,创建一个excel文档
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2,创建文档摘要
//        workbook.createInformationProperties();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        //5,创建样式
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        //设置表头背景颜色
        cellStyle.setFont(font);
//        hssfCellStyle.setFillForegroundColor(IndexedColors.WHITE.index);
////        hssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
////        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
////        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        XSSFSheet sheet = workbook.createSheet("问卷表");

        XSSFRow row = sheet.createRow(0);
        XSSFCell cell;
        if (!ObjectUtils.isEmpty(titles)){
            for (int i=0;i<titles.size();i++){
                sheet.setColumnWidth(i,10*256);
                cell = row.createCell(i);
                cell.setCellValue(titles.get(i));
                cell.setCellStyle(cellStyle);

            }
        }


        if (!ObjectUtils.isEmpty(values)){
            for (int i = 0;i<values.size();i++){
                List<QfKeyIndexAnswer> answers = values.get(i);
                XSSFRow row1 = sheet.createRow(i + 1);
                for (QfKeyIndexAnswer answer:answers){
                    row1.createCell(answer.getKeyIndex()).setCellValue(answer.getValue());
                }
            }
        }
        try {
            workbook.write(new FileOutputStream(getAbsoluteFile(fileName)));
            workbook.close();
        } catch (Exception ex) {
            return AjaxResult.error("文件创建失败");
        }
        return AjaxResult.success(fileName);
    }

}
