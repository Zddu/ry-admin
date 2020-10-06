package com.ruoyi.assets.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同管理对象 assets_contract
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
public class AssetsContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同id */
    private Long id;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String name;
    /**文件原名称**/
    @Excel(name = "文件原名称")
    private String originalName;
    /** 合同本地存放地址 */
    @Excel(name = "合同本地存放地址")
    private String path;

    private String mappingName;

    /** 批次号 */
    @Excel(name = "批次号")
    private Long batchNum;


    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
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
    public void setBatchNum(Long batchNum) 
    {
        this.batchNum = batchNum;
    }

    public Long getBatchNum() 
    {
        return batchNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("path", getPath())
            .append("batchNum", getBatchNum())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
