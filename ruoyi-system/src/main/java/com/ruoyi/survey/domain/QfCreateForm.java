package com.ruoyi.survey.domain;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;


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
    @Excel(name ="创建时间", dateFormat = "yyyy-MM-dd HH:mm:ss",sort =3)
    private Date createTime;
    /** $column.columnComment */
    private Long id;

    /** 问卷json数据 */
    private String strData;

    /** 创建者 */
    private String creator;
    @Excel(name ="状态",readConverterExp = "0=未发布,1=已发布",sort = 4)
    private Integer state;
    @Excel(name ="标题",sort = 1)
    private String title;
    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name ="截止时间", dateFormat = "yyyy-MM-dd HH:mm:ss",sort = 2)
    private Date endTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hoTime;


    public Date getHoTime() {
        return hoTime;
    }

    public void setHoTime(Date hoTime) {
        this.hoTime = hoTime;
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
