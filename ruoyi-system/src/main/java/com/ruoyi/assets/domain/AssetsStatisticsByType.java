package com.ruoyi.assets.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/18 -- 10:25
 **/
public class AssetsStatisticsByType extends BaseEntity {
    @Excel(name = "设备类型", readConverterExp = "0=多媒体设备,1=计算机设备（教师）,2=计算机设备（学生）,3=录播教室设备,4=网络设备")
    private Integer itemType;
    @Excel(name = "设备总数")
    private Integer equipmentTotal;
    @Excel(name = "设备核销数")
    private Integer equipmentWriteOffNum;
    private List<AssetsItems> assetsItemsList;

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
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
        return "AssetsStatisticsByType{" +
                "itemType=" + itemType +
                ", equipmentTotal=" + equipmentTotal +
                ", equipmentWriteOffNum=" + equipmentWriteOffNum +
                ", assetsItemsList=" + assetsItemsList +
                '}';
    }
}
