package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 assets_property
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
public class AssetsProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long itemId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String propertyValue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String propertyName;

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
    public void setPropertyValue(String propertyValue) 
    {
        this.propertyValue = propertyValue;
    }

    public String getPropertyValue() 
    {
        return propertyValue;
    }
    public void setPropertyName(String propertyName) 
    {
        this.propertyName = propertyName;
    }

    public String getPropertyName() 
    {
        return propertyName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("propertyValue", getPropertyValue())
            .append("propertyName", getPropertyName())
            .toString();
    }
}
