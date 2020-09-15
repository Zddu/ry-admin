package com.ruoyi.survey.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @date 2020/9/9 -- 18:45
 **/
public class ImportData2ExcelUtils {
    private int rsize;
    private int csize;
    private int valueRow;//数据填写行的下标
    private HSSFWorkbook workbook;
    private HSSFSheet sheetAt;

    public ImportData2ExcelUtils(InputStream bis) {
        this.workbook = initializeHSSFWorkbook(bis);
        this.sheetAt = getSheet();
        this.rsize =getRowsize();
        this.csize =getColumnsize();
        this.valueRow=getValueRow();
    }

    public ImportData2ExcelUtils(InputStream bis, int sheetIndex) {
        this.workbook = initializeHSSFWorkbook(bis);
        this.sheetAt = getSheet(sheetIndex);
        this.rsize =getRowsize();
        this.csize =getColumnsize();
        this.valueRow=getValueRow();
    }


    public  void fillData2OriginExcel(FileOutputStream fos, List<List<String>> datas) throws IOException {
        System.out.println("rsize : "+rsize+"csize : "+csize+" valueRow :"+valueRow);
        List<CellRangeAddress> cellRangeAddresses=getOriginFirstValueRowMergedRegions();
        removeStyleBehindValueRow();
        List<HSSFCellStyle> list=getOriginHSSFCellStyles();

        removeMsgBehindValueRow();
        addData2OriginExcel(datas,list,cellRangeAddresses);
        workbook.write(fos);
        fos.close();
    }

    /**
     * 获取第一个数据行的合并单元格信息（仅限列合并），因此获取要在移除合并单元格样式操作之前执行
     * @return
     */
    private List<CellRangeAddress> getOriginFirstValueRowMergedRegions() {
        int sheetmergeCount = sheetAt.getNumMergedRegions();
        List<CellRangeAddress> result = new ArrayList<>();
        for(int i=0;i<sheetmergeCount;i++){
            CellRangeAddress mergedRegion = sheetAt.getMergedRegion(i);
            if (mergedRegion.getFirstRow()==valueRow&&mergedRegion.getLastRow()==valueRow){
               result.add(mergedRegion);
            }
        }
        return result;
    }


    /**
     * 获取数据填写行的下标
     * @return
     */
    private int getValueRow() {
        int result = -1;
        if (csize==-1){
            return -1;
        }
        label:for (int i = 1; i < rsize; i++) {
            HSSFRow row = sheetAt.getRow(i);
            csize = row.getLastCellNum() - row.getFirstCellNum();
            for (int j = 0; j < csize; j++) {
                if (!row.getCell(j).getStringCellValue().isEmpty()) {
                    continue label;
                }
            }
            result = i;
            break;
        }
        return result;
    }

    /**
     * 获取该sheet中最大列数
     * @return
     */
    private int getColumnsize() {
        int result=-1;
        if (rsize!=-1){
            for (int i=0;i<rsize;i++){
                HSSFRow row = sheetAt.getRow(i);
                if (result<(row.getLastCellNum()-row.getFirstCellNum())){
                    result=row.getLastCellNum()-row.getFirstCellNum();
                }
            }
        }
        return result;
    }

    /**
     * 获取原文件的第一个sheet
     * @return
     */
    private HSSFSheet getSheet() {

        return getSheet(0);
    }
    private HSSFSheet getSheet(int index) {
        if (workbook!=null){
            return workbook.getSheetAt(index);
        }
        return null;
    }

    /**
     * 获取该sheet中最大行数
     * @return
     */
    private int getRowsize() {
        if (workbook !=null){
            return sheetAt.getLastRowNum() - sheetAt.getFirstRowNum();
        }
        return -1;
    }

    /**
     * 初始化excel对象
     * @param bis 源excel的输入流
     * @return
     */
    private static HSSFWorkbook initializeHSSFWorkbook(InputStream bis) {
        try {
            return new HSSFWorkbook(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * //添加数据以及对应样式
     * @param datas 数据
     * @param list 数据行样式集合
     * @param cellRangeAddresses
     */
    private void addData2OriginExcel(List<List<String>> datas, List<HSSFCellStyle> list, List<CellRangeAddress> cellRangeAddresses) {
        for (int i =valueRow;i<datas.size();i++){
            HSSFRow r = sheetAt.createRow(i);
            List<String> strings = datas.get(i);
            //将数据行的合并单元信息复制
            for (CellRangeAddress cellRangeAddress : cellRangeAddresses) {
                sheetAt.addMergedRegion(new CellRangeAddress(i,i,cellRangeAddress.getFirstColumn(),cellRangeAddress.getLastColumn()));
            }
            for (int j=0;j<csize;j++){
                HSSFCell cell = r.createCell(j);
                cell.setCellValue(strings.get(j));
                cell.setCellStyle(list.get(j));
            }
        }
    }


    /**
     * 删除原本的excel信息（不包括表头部分）
     */
    private void removeMsgBehindValueRow() {
        for (int i=valueRow;i<=rsize;i++ ){
            sheetAt.removeRow(sheetAt.getRow(i));
        }
    }

    /**
     * 去除数据填写行后面的合并样式
     */
    private void removeStyleBehindValueRow() {
        int sheetmergeCount = sheetAt.getNumMergedRegions();
        List<Integer> integerList=new ArrayList<>();
        for (int i = 0; i < sheetmergeCount; i++) {
            CellRangeAddress range = sheetAt.getMergedRegion(i);
            if (range.getLastRow()>=valueRow){
                integerList.add(i);
            }
        }
        Collections.reverse(integerList);
        for (Integer integer : integerList) {
            sheetAt.removeMergedRegion(integer);
        }
    }

    /**
     * 获取原excel数据填写行的样式(要在删除原excel信息之前提取样式)
   **/
    private  List<HSSFCellStyle> getOriginHSSFCellStyles() {
        List<HSSFCellStyle> list = new ArrayList<>();
        HSSFRow row = sheetAt.getRow(valueRow);
        for (int i=0;i<csize;i++){
            list.add(row.getCell(i).getCellStyle());
        }
        return list;
    }
}
