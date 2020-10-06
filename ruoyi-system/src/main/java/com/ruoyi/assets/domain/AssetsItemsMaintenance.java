package com.ruoyi.assets.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * 【请填写功能名称】对象 assets_items_maintenance
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
public class AssetsItemsMaintenance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 所属物品id */
    @Excel(name = "所属物品id")
    @NotNull
    private Long itemId;

    /** 维修内容 */
    @Excel(name = "维修内容")
    @NotNull
    private String content;

    /** 维修时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "维修时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date maintenanceTime;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date submitTime;

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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setMaintenanceTime(Date maintenanceTime) 
    {
        this.maintenanceTime = maintenanceTime;
    }

    public Date getMaintenanceTime() 
    {
        return maintenanceTime;
    }
    public void setSubmitTime(Date submitTime) 
    {
        this.submitTime = submitTime;
    }

    public Date getSubmitTime() 
    {
        return submitTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("content", getContent())
            .append("maintenanceTime", getMaintenanceTime())
            .append("submitTime", getSubmitTime())
            .toString();
    }
}
