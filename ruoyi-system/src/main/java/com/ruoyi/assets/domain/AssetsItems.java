package com.ruoyi.assets.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 【请填写功能名称】对象 assets_items
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
@Data
public class AssetsItems extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /**
     * 物品名称
     */
    @Excel(name = "物品名称")
    private String itemName;
    @Excel(name = "物品规格")
    private String itemFormat;
    @Excel(name = "保修期")
    private String warrantyTime;
    @Excel(name = "使用时长")
    private String usedTime;
    @Excel(name = "商品总数")
    private Long itemTotal;

    @Excel(name = "购买时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Long contractId;
    @Excel(name = "供应商名称")
    private String contractName;



}
