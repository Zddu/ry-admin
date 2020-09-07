package com.ruoyi.survey.domain;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 【请填写功能名称】对象 qf_create_form
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public class QfCreateForm implements Serializable
{
    private static final long serialVersionUID = 1L;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /** $column.columnComment */
    private Long id;

    /** 问卷json数据 */
    private String strData;

    /** 创建者 */
    private String creator;
    private Integer state;
    private String title;
    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hoTime;

    public Date getHoTime() {
        return hoTime;
    }

    public void setHoTime(Date hoTime) {
        hoTime = hoTime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId()
    {
        return id;
    }
    public void setStrData(String strData)
    {
        this.strData = strData;
    }

    public String getStrData()
    {
        return strData;
    }

    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public QfCreateForm() {
    }

    public QfCreateForm(Date hoTime,Long id,Integer state) {
        this.id = id;
        this.state = state;
        this.hoTime = hoTime;
    }
}
