package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 assets_orders
 * 
 * @author Zddeä¸¶
 * @date 2020-09-18
 */
public class AssetsOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
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
    private Long senderId;
    private String senderName;

    /** 接收方id */
    @Excel(name = "接收方id")
    private Long receiverId;

    /** 接收方名称 */
    @Excel(name = "接收方名称")
    private String receiverName;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRecordId(String recordId) 
    {
        this.recordId = recordId;
    }

    public String getRecordId() 
    {
        return recordId;
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
    public void setReceiverName(String receiverName) 
    {
        this.receiverName = receiverName;
    }

    public String getReceiverName() 
    {
        return receiverName;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordId", getRecordId())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemNum", getItemNum())
            .append("senderId", getSenderId())
            .append("receiverId", getReceiverId())
            .append("receiverName", getReceiverName())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .toString();
    }
}
