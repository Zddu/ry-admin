package com.ruoyi.basemsg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * 学校基本信息对象 base_school_msg
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
public class BaseSchoolMsg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 教师数 */
    @Excel(name = "教师数")
    @NotNull
    private Long teacherNum;

    /** 学生数 */
    @Excel(name = "学生数")
    @NotNull
    private Long studentNum;

    /** 班级数 */
    @Excel(name = "班级数")
    @NotNull
    private Long classNum;

    /** 学校id */
    @Excel(name = "学校id")
    private Long schoolId;

    private String schoolName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeacherNum(Long teacherNum) 
    {
        this.teacherNum = teacherNum;
    }

    public Long getTeacherNum() 
    {
        return teacherNum;
    }
    public void setStudentNum(Long studentNum) 
    {
        this.studentNum = studentNum;
    }

    public Long getStudentNum() 
    {
        return studentNum;
    }
    public void setClassNum(Long classNum) 
    {
        this.classNum = classNum;
    }

    public Long getClassNum() 
    {
        return classNum;
    }
    public void setSchoolId(Long schoolId) 
    {
        this.schoolId = schoolId;
    }

    public Long getSchoolId() 
    {
        return schoolId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherNum", getTeacherNum())
            .append("studentNum", getStudentNum())
            .append("classNum", getClassNum())
            .append("schoolId", getSchoolId())
            .toString();
    }
}
