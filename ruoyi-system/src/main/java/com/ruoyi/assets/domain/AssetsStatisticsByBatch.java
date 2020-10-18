package com.ruoyi.assets.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/18 -- 11:05
 **/
public class AssetsStatisticsByBatch extends BaseEntity {
    @Excel(name = "设备批次号")
    private Long batchNum;
    @Excel(name = "设备总数")
    private Integer equipmentTotal;
    @Excel(name = "设备核销数")
    private Integer equipmentWriteOffNum;
    private List<AssetsItems> assetsItemsList =new ArrayList<>();

    public Long getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Long batchNum) {
        this.batchNum = batchNum;
    }

    public Integer getEquipmentTotal() {
        return equipmentTotal;
    }

    public void setEquipmentTotal(Integer equipmentTotal) {
        this.equipmentTotal = equipmentTotal;
    }

    public Integer getEquipmentWriteOffNum() {
        return equipmentWriteOffNum;
    }

    public void setEquipmentWriteOffNum(Integer equipmentWriteOffNum) {
        this.equipmentWriteOffNum = equipmentWriteOffNum;
    }

    public List<AssetsItems> getAssetsItemsList() {
        return assetsItemsList;
    }

    public void setAssetsItemsList(List<AssetsItems> assetsItemsList) {
        this.assetsItemsList = assetsItemsList;
    }

    @Override
    public String toString() {
        return "AssetsStatisticsByBatch{" +
                "batchNum=" + batchNum +
                ", equipmentTotal=" + equipmentTotal +
                ", equipmentWriteOffNum=" + equipmentWriteOffNum +
                ", assetsItemsList=" + assetsItemsList +
                '}';
    }
}
