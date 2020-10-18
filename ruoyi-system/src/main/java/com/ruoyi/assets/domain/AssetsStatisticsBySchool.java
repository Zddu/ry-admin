package com.ruoyi.assets.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.rmi.CORBA.Tie;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/18 -- 9:23
 **/
public class AssetsStatisticsBySchool extends BaseEntity {
    @Excel(name = "单位名称")
    private String deptName;
    @Excel(name = "设备总数")
    private Integer equipmentTotal;
    @Excel(name = "设备核销数")
    private Integer equipmentWriteOffNum;
    private List<AssetsItems> assetsItemsList =new ArrayList<>();




    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public void add(AssetsItems assetsItems){
        assetsItemsList.add(assetsItems);
    }

    @Override
    public String toString() {
        return "AssetsStatisticsBySchool{" +
                "deptName='" + deptName + '\'' +
                ", equipmentTotal=" + equipmentTotal +
                ", equipmentWriteOffNum=" + equipmentWriteOffNum +
                ", assetsItemsList=" + assetsItemsList +
                '}';
    }
}
