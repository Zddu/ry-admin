package com.ruoyi.assets.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @date 2020/9/17 -- 13:10
 **/
@Data
public class ItemsSupplierContractVo extends BaseEntity {
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
    private String itemTotal;

    @Excel(name = "购买时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "合同名称")
    private String contractName;
    @Excel(name = "供应商名称")
    private String supplierName;
}
