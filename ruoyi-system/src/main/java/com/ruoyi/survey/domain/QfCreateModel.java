package com.ruoyi.survey.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发布问卷的模板对象 qf_create_model
 * 
 * @author Zddeä¸¶
 * @date 2020-10-11
 */
public class QfCreateModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 问卷标题 */
    @Excel(name = "问卷标题")
    private String title;

    /** 问卷json数据 */
    @Excel(name = "问卷json数据")
    private String strData;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creator;



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getStrData() {
        return strData;
    }

    public void setStrData(String strData) {
        this.strData = strData;
    }

    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("jsonData", getStrData())
            .append("createTime", getCreateTime())
            .append("creator", getCreator())
            .append("endTime", getEndTime())
            .toString();
    }
}
