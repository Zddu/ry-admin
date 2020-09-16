package com.ruoyi.survey.domain;

import com.ruoyi.common.exception.CustomException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Objects;

/**
 * 【请填写功能名称】对象 qf_school_answer
 * 
 * @author Zddeä¸¶
 * @date 2020-09-08
 */
public class QfSchoolAnswer extends BaseEntity {

    private static HashSet<String> requiredTitles;
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

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public QfSchoolAnswer(Long qfSchoolId, String key, String value,String type) {
        this.qfSchoolId = qfSchoolId;
        this.key = key;
        if (ObjectUtils.isEmpty(value)){
            if (requiredTitles==null){
                throw new RuntimeException("请先校验表单有哪些必填项");
            }
            if (requiredTitles.contains(key)){
                throw new CustomException("有必填非空");
            }
        }
        this.type=type;
        this.value = value;
    }

    public static void setRequiredTitles(HashSet<String> requiredTitles) {
        QfSchoolAnswer.requiredTitles = requiredTitles;
    }

    public QfSchoolAnswer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QfSchoolAnswer that = (QfSchoolAnswer) o;
        return Objects.equals(qfSchoolId, that.qfSchoolId) &&
                Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qfSchoolId, key);
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
