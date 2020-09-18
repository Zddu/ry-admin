package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 合同对象 assets_contract
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public class AssetsContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同id */
    private Long id;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String name;

    /** 合同本地存放地址 */
    @Excel(name = "合同本地存放地址")
    private String path;

    private Long[] itemsId;

    private Long supplierId;




    public Long[] getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long[] itemsId) {
        this.itemsId = itemsId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("path", getPath())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
