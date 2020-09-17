package com.ruoyi.assets.service;
import com.ruoyi.assets.domain.AssetsSupplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-16
 */
public interface IAssetsSupplierService {
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public AssetsSupplier selectAssetsSupplierById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetsSupplier> selectAssetsSupplierList(AssetsSupplier assetsSupplier);
/**
 * 通过合同查询相应供应商
 */

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetsSupplier(AssetsSupplier assetsSupplier);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsSupplier(AssetsSupplier assetsSupplier);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsSupplierByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsSupplierById(Long id);


    List<AssetsSupplier> selectAssetsSupplierAndContractList(AssetsSupplier assetsSupplier);
}
