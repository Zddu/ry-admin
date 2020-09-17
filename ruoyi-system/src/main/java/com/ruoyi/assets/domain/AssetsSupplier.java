package com.ruoyi.assets.domain;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 assets_supplier
 * 
 * @author Zddeä¸¶
 * @date 2020-09-16
 */
@Data
public class AssetsSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    private Long contractId;

    private String contractName;
}
