package com.ruoyi.survey.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 qf_user_form
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public class QfUserForm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 表单id */
    @Excel(name = "表单id")
    private Long createId;

    /** 提交用户 */
    @Excel(name = "提交用户")
    private String commitUser;

    /** 题目对应的key */
    @Excel(name = "题目对应的key")
    private String key;

    /** 用户提交答案 */
    @Excel(name = "用户提交答案")
    private String value;

    private Integer deptId;

    private Integer state;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setCommitUser(String commitUser)
    {
        this.commitUser = commitUser;
    }

    public String getCommitUser() 
    {
        return commitUser;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createId", getCreateId())
            .append("commitUser", getCommitUser())
            .append("key", getKey())
            .append("value", getValue())
            .append("createTime", getCreateTime())
            .toString();
    }
}
