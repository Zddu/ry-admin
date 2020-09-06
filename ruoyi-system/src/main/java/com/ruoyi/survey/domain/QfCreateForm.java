package com.ruoyi.survey.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 qf_create_form
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public class QfCreateForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 问卷json数据 */
    @Excel(name = "问卷json数据")
    private String jsonData;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creator;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建者", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public QfCreateForm(String jsonData, String creator, Date endTime) {
        this.jsonData = jsonData;
        this.creator = creator;
        this.endTime = endTime;
    }

    public QfCreateForm() {
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setJsonData(String jsonData) 
    {
        this.jsonData = jsonData;
    }

    public String getJsonData() 
    {
        return jsonData;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jsonData", getJsonData())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("endTime", getEndTime())
            .toString();
    }
}
