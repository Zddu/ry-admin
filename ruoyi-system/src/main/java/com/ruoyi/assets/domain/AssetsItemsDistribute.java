package com.ruoyi.assets.domain;

import com.sun.corba.se.impl.orbutil.ObjectUtility;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 资产分发对象 assets_items_distribute
 * 
 * @author Zddeä¸¶
 * @date 2020-10-16
 */
public class AssetsItemsDistribute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String itemName;

    /** 设备类型0:多媒体设备、1:计算机设备（教师）、2:计算机设备（学生）、3:录播教室设备、4:网络设备 */
    @Excel(name = "设备类型", readConverterExp = "0=多媒体设备,1=计算机设备（教师）,2=计算机设备（学生）,3=录播教室设备,4=网络设备")
    private String itemType;

    /** 设备规格 */
    @Excel(name = "设备规格")
    private String itemFormat;

    /** 分发的设备数 */
    @Excel(name = "分发的设备数")
    private Long itemNum;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchNum;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 售后电话 */
    @Excel(name = "售后电话")
    private String postSalePhone;

    /** 保修期(年) */
    @Excel(name = "保修期(年)")
    private String warrantyTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 商品所属单位id */
    private Long itemBelonger;

    /**商品所属单位名称*/
    private String itemBelongerName;

    private Long[] schools;

    public Long[] getSchools() {
        return schools;
    }

    public void setSchools(Long[] schools) {
        this.schools = schools;
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
    public void setItemNum(Long itemNum) 
    {
        this.itemNum = itemNum;
    }

    public Long getItemNum() 
    {
        return itemNum;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
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

    public String getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(String warrantyTime) {
        this.warrantyTime = warrantyTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemName", getItemName())
            .append("itemType", getItemType())
            .append("itemFormat", getItemFormat())
            .append("itemNum", getItemNum())
            .append("batchNum", getBatchNum())
            .append("supplierName", getSupplierName())
            .append("postSalePhone", getPostSalePhone())
            .append("warrantyTime", getWarrantyTime())
            .append("remarks", getRemarks())
            .append("itemBelonger", getItemBelonger())
            .append("createTime", getCreateTime())
            .toString();
    }

    public boolean fuzzyMatching(String name) {
        return this.getItemBelongerName().contains(name);
    }
}
