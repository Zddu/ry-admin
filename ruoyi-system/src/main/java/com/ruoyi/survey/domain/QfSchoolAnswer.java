package com.ruoyi.survey.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Objects;

/**
 * 【请填写功能名称】对象 qf_school_answer
 * 
 * @author Zddeä¸¶
 * @date 2020-09-08
 */
public class QfSchoolAnswer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学校提交问卷表id */
    @Excel(name = "学校提交问卷表id")
    private Long qfSchoolId;

    /** 题目 */
    @Excel(name = "题目")
    private String key;

    /** 答案 */
    @Excel(name = "答案")
    private String value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQfSchoolId(Long qfSchoolId) 
    {
        this.qfSchoolId = qfSchoolId;
    }

    public Long getQfSchoolId() 
    {
        return qfSchoolId;
    }
    public void setKey(String key) 
    {
        this.key = key;
    }

    public String getKey() 
    {
        return key;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    public QfSchoolAnswer(Long qfSchoolId, String key, String value) {
        this.qfSchoolId = qfSchoolId;
        this.key = key;
        this.value = value;
    }

    public QfSchoolAnswer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QfSchoolAnswer that = (QfSchoolAnswer) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("qfSchoolId", getQfSchoolId())
            .append("key", getKey())
            .append("value", getValue())
            .toString();
    }
}
