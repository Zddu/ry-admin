package com.ruoyi.assets.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * 资产管理对象 assets_items_school
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
public class AssetsItems extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;
    @Excel(name = "商品所属单位")
    private String itemBelongerName;
    /** 设备名称 */
    @Excel(name = "设备名称")
    @NotNull
    private String itemName;

    /** 设备类型0:多媒体设备、1:计算机设备（教师）、2:计算机设备（学生）、3:录播教室设备、4:网络设备 */
    @Excel(name = "设备类型", readConverterExp = "0=多媒体设备,1=计算机设备（教师）,2=计算机设备（学生）,3=录播教室设备,4=网络设备")
    private String itemType;

    /** 设备规格 */
    @Excel(name = "设备规格")
    private String itemFormat;

    /** 批次号 */
    @Excel(name = "批次号")
    @NotNull
    private Long batchNum;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 售后电话 */
    @Excel(name = "售后电话")
    private String postSalePhone;

    /** 安装时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date installedTime;

    /** 保修期(年) */
    @Excel(name = "保修期(年)")
    private Long warrantyTime;

    /** 设备位置 */
    @Excel(name = "设备位置")
    private String itemLocation;

    /** 设备ip */
    @Excel(name = "设备ip")
    private String itemIp;

    /** 设备管理员 */
    @Excel(name = "设备管理员")
    private String itemAdmin;

    /** 维修记录 */
    private List<AssetsItemsMaintenance> maintenanceRecords;

    /** 商品状态 0:正常、1:正常（效果不好）、2:无法使用、3:已报废 */
    @Excel(name = "商品状态",readConverterExp="0=正常,1=正常（效果不好）,2=无法使用,3=已报废")
    private Long itemState;

    @Excel(name = "核销",readConverterExp = "0=未核销,1=已核销")
    private Integer isWriteOff;
    /**是否可以修改全部字段**/
    private Integer isModify;
    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 商品所属单位id */

    private Long itemBelonger;

   

    private Long distributeId;


    public Long getDistributeId() {
        return distributeId;
    }

    public void setDistributeId(Long distributeId) {
        this.distributeId = distributeId;
    }

    public Integer getIsModify() {
        return isModify;
    }

    public void setIsModify(Integer isModify) {
        this.isModify = isModify;
    }

    public Integer getIsWriteOff() {
        return isWriteOff;
    }

    public void setIsWriteOff(Integer isWriteOff) {
        this.isWriteOff = isWriteOff;
    }

    public String getItemBelongerName() {
        return itemBelongerName;
    }

    public void setItemBelongerName(String itemBelongerName) {
        this.itemBelongerName = itemBelongerName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }
    public void setItemFormat(String itemFormat) 
    {
        this.itemFormat = itemFormat;
    }

    public String getItemFormat() 
    {
        return itemFormat;
    }
    public void setBatchNum(Long batchNum) 
    {
        this.batchNum = batchNum;
    }

    public Long getBatchNum() 
    {
        return batchNum;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setPostSalePhone(String postSalePhone) 
    {
        this.postSalePhone = postSalePhone;
    }

    public String getPostSalePhone() 
    {
        return postSalePhone;
    }
    public void setInstalledTime(Date installedTime) 
    {
        this.installedTime = installedTime;
    }

    public Date getInstalledTime() 
    {
        return installedTime;
    }
    public void setWarrantyTime(Long warrantyTime) 
    {
        this.warrantyTime = warrantyTime;
    }

    public Long getWarrantyTime() 
    {
        return warrantyTime;
    }
    public void setItemLocation(String itemLocation) 
    {
        this.itemLocation = itemLocation;
    }

    public String getItemLocation() 
    {
        return itemLocation;
    }
    public void setItemIp(String itemIp) 
    {
        this.itemIp = itemIp;
    }

    public String getItemIp() 
    {
        return itemIp;
    }
    public void setItemAdmin(String itemAdmin) 
    {
        this.itemAdmin = itemAdmin;
    }

    public String getItemAdmin() 
    {
        return itemAdmin;
    }

    public List<AssetsItemsMaintenance> getMaintenanceRecords() {
        return maintenanceRecords;
    }

    public void setMaintenanceRecords(List<AssetsItemsMaintenance> maintenanceRecords) {
        this.maintenanceRecords = maintenanceRecords;
    }

    public void setItemState(Long itemState)
    {
        this.itemState = itemState;
    }

    public Long getItemState() 
    {
        return itemState;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setItemBelonger(Long itemBelonger) 
    {
        this.itemBelonger = itemBelonger;
    }

    public Long getItemBelonger() 
    {
        return itemBelonger;
    }


    public AssetsItems(@NotNull Long batchNum) {
        this.batchNum = batchNum;
    }

    public AssetsItems() {
    }


    @Override
    public String toString() {
        return "AssetsItems{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemFormat='" + itemFormat + '\'' +
                ", batchNum=" + batchNum +
                ", supplierName='" + supplierName + '\'' +
                ", postSalePhone='" + postSalePhone + '\'' +
                ", installedTime=" + installedTime +
                ", warrantyTime=" + warrantyTime +
                ", itemLocation='" + itemLocation + '\'' +
                ", itemIp='" + itemIp + '\'' +
                ", itemAdmin='" + itemAdmin + '\'' +
                ", maintenanceRecords=" + maintenanceRecords +
                ", itemState=" + itemState +
                ", isWriteOff=" + isWriteOff +
                ", isModify=" + isModify +
                ", remarks='" + remarks + '\'' +
                ", itemBelonger=" + itemBelonger +
                ", itemBelongerName='" + itemBelongerName + '\'' +
                ", distributeId=" + distributeId +
                '}';
    }

    public boolean fuzzyMatching(String name) {
        if (this.getItemBelongerName().contains(name)){
            return true;
        }
        return false;
    }
}
