package com.ruoyi.repair.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.Objects;

/**
 * 保修记录对象 repair_record
 * 
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
public class RepairRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号",width = 24)
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
    private String contactNumber;

    /** 故障描述 */
    @Excel(name = "故障描述",width = 100)
    private String describe;
    /** 故障类型 */
    @Excel(name = "故障描述")
    private String type;
    @Excel(name = "维修联系人")
    private String maintenanceContact;
    /** 是否满意(0-不满意 1-满意) */

    private Long isSatisfied;
    @Excel(name = "维修状态",readConverterExp="0=未维修,1=已派人,2=已维修")
    private Integer state;

    /** 微信号 */

    private String weixinNum;

    @Excel(name = "报修解决方法")
    private String solution;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "时间",dateFormat = "yyyy-MM-dd HH:mm:ss",width = 24)
    private Date createTime;



    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMaintenanceContact() {
        return maintenanceContact;
    }

    public void setMaintenanceContact(String maintenanceContact) {
        this.maintenanceContact = maintenanceContact;
    }

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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDescribe(String describe)
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
    }
    public void setIsSatisfied(Long isSatisfied) 
    {
        this.isSatisfied = isSatisfied;
    }

    public Long getIsSatisfied() 
    {
        return isSatisfied;
    }
    public void setWeixinNum(String weixinNum) 
    {
        this.weixinNum = weixinNum;
    }

    public String getWeixinNum() 
    {
        return weixinNum;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepairRecord that = (RepairRecord) o;
        return  Objects.equals(orderNum, that.orderNum) &&
                Objects.equals(department, that.department) &&
                Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash( orderNum, department, room);
    }

    @Override
    public String toString() {
        return "RepairRecord{" +
                "orderNum='" + orderNum + '\'' +
                ", department='" + department + '\'' +
                ", room='" + room + '\'' +
                ", contacts='" + contacts + '\'' +
                ", contactNumber=" + contactNumber +
                ", describe='" + describe + '\'' +
                ", type='" + type + '\'' +
                ", isSatisfied=" + isSatisfied +
                ", weixinNum='" + weixinNum + '\'' +
                '}';
    }
}
