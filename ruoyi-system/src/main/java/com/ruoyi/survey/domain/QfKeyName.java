package com.ruoyi.survey.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 qf_key_name
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public class QfKeyName extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long createId;

    /** 表单元素key值 */
    @Excel(name = "表单元素key值")
    private String key;

    /** 表单元素题目 */
    @Excel(name = "表单元素题目")
    private String name;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public QfKeyName setCreateId(Long createId)
    {
        this.createId = createId;
        return this;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createId", getCreateId())
            .append("key", getKey())
            .append("name", getName())
            .toString();
    }
}
