package com.ruoyi.repair.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修记录对象 repair_maintenance
 * 
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
public class RepairMaintenance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNum;

    /** 科室 */
    @Excel(name = "科室")
    private String department;

    /** 房间 */
    @Excel(name = "房间")
    private String room;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private Long contactNumber;

    /** 故障描述 */
    @Excel(name = "故障描述")
    private String describe;

    /** 微信号 */
    @Excel(name = "微信号")
    private String weixinNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setRoom(String room) 
    {
        this.room = room;
    }

    public String getRoom() 
    {
        return room;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setContactNumber(Long contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public Long getContactNumber() 
    {
        return contactNumber;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
    }
    public void setWeixinNum(String weixinNum) 
    {
        this.weixinNum = weixinNum;
    }

    public String getWeixinNum() 
    {
        return weixinNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNum", getOrderNum())
            .append("department", getDepartment())
            .append("room", getRoom())
            .append("contacts", getContacts())
            .append("contactNumber", getContactNumber())
            .append("describe", getDescribe())
            .append("weixinNum", getWeixinNum())
            .append("createTime", getCreateTime())
            .toString();
    }
}
