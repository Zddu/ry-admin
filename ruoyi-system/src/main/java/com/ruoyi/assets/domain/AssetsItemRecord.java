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

    /** 接收方id(学校id) */
    @Excel(name = "接收方id(学校id)")
    private Long receiverId;

    /** 0-已出库 1-已确收 */
    @Excel(name = "0-已出库 1-已确收")
    private Long state;

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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemNum", getItemNum())
            .append("senderId", getSenderId())
            .append("receiverId", getReceiverId())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .toString();
    }
}
