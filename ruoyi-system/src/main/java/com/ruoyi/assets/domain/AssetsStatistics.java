package com.ruoyi.assets.domain;

import com.ruoyi.common.annotation.Excel;

import javax.validation.constraints.NotNull;

/**
 * @date 2020/10/21 -- 16:46
 **/
public class AssetsStatistics {
    @Excel(name = "商品所属单位")
    private String itemBelongerName;
    @Excel(name = "设备类型", readConverterExp = "0=多媒体设备,1=计算机设备（教师）,2=计算机设备（学生）,3=录播教室设备,4=网络设备")
    private String itemType;
    @Excel(name = "批次号")
    private String batchNum;
    @Excel(name = "设备总数",isStatistics=true)
    private Integer itemNum;
    @Excel(name = "核销数",isStatistics=true)
    private Integer writerOffNum;
    @Excel(name = "剩余数",isStatistics=true)
    private Integer residueNum;

    public String getItemBelongerName() {
        return itemBelongerName;
    }

    public void setItemBelongerName(String itemBelongerName) {
        this.itemBelongerName = itemBelongerName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Integer getWriterOffNum() {
        return writerOffNum;
    }

    public void setWriterOffNum(Integer writerOffNum) {
        this.writerOffNum = writerOffNum;
    }

    public Integer getResidueNum() {
        return residueNum;
    }

    public void setResidueNum(Integer residueNum) {
        this.residueNum = residueNum;
    }
}
