package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学校仓库对象 assets_school_warehouse
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public class AssetsSchoolWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学校仓库id */
    private Long id;

    /** 货物id */
    @Excel(name = "货物id")
    private Long itemId;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String itemName;

    /** 货物数量 */
    @Excel(name = "货物数量")
    private Long itemNum;

    private Long schoolId;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setItemNum(Long itemNum) 
    {
        this.itemNum = itemNum;
    }

    public Long getItemNum() 
    {
        return itemNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemNum", getItemNum())
            .toString();
    }
}
