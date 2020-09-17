package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 管理员仓库对象 assets_admin_warehouse
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public class AssetsAdminWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id  */
    private Long id;

    /** 物品id */
    @Excel(name = "物品id")
    private Long itemId;

    /** 物品状态 */
    @Excel(name = "物品状态")
    private String itemName;

    /** 物品数量 */
    @Excel(name = "物品数量")
    private Long itemNum;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemNum", getItemNum())
            .toString();
    }
}
