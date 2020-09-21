package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 记录表对象 assets_item_record
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public class AssetsItemRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    private String recordId;
    /** 商品id */
    @Excel(name = "商品id")
    private Long itemId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String itemName;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long itemNum;

    /** 发送方id */
    @Excel(name = "发送方id")
    private Long senderId ;

    private String senderName;

    /** 接收方id(学校id) */
    @Excel(name = "接收方id(学校id)")
    private Long receiverId;

    private String receiverName;
    /** 0-已出库 1-已确收 */
    @Excel(name = "0-已出库 1-已确收")
    private Long state;

    private Long operatorId;

    private Integer adminDelete;

    private Integer schoolDelete;


    public Integer getAdminDelete() {
        return adminDelete;
    }

    public void setAdminDelete(Integer adminDelete) {
        this.adminDelete = adminDelete;
    }

    public Integer getSchoolDelete() {
        return schoolDelete;
    }

    public void setSchoolDelete(Integer schoolDelete) {
        this.schoolDelete = schoolDelete;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setItemNum(Long itemNum) 
    {
        this.itemNum = itemNum;
    }

    public Long getItemNum() 
    {
        return itemNum;
    }
    public void setSenderId(Long senderId) 
    {
        this.senderId = senderId;
    }

    public Long getSenderId() 
    {
        return senderId;
    }
    public void setReceiverId(Long receiverId) 
    {
        this.receiverId = receiverId;
    }

    public Long getReceiverId() 
    {
        return receiverId;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return "AssetsItemRecord{" +
                "id=" + id +
                ", recordId='" + recordId + '\'' +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemNum=" + itemNum +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", receiverId=" + receiverId +
                ", receiverName='" + receiverName + '\'' +
                ", state=" + state +
                ", operatorId=" + operatorId +
                '}';
    }
}
