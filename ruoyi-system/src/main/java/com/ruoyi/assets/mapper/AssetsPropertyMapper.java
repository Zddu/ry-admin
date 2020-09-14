package com.ruoyi.assets.mapper;


import com.ruoyi.assets.domain.AssetsProperty;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
public interface AssetsPropertyMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public AssetsProperty selectAssetsPropertyById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsProperty 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetsProperty> selectAssetsPropertyList(AssetsProperty assetsProperty);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsProperty 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetsProperty(AssetsProperty assetsProperty);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsProperty 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsProperty(AssetsProperty assetsProperty);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsPropertyById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsPropertyByIds(Long[] ids);
}
