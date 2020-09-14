package com.ruoyi.assets.mapper;


import com.ruoyi.assets.domain.AssetsPropertiesModel;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
public interface AssetsPropertiesModelMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public AssetsPropertiesModel selectAssetsPropertiesModelById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsPropertiesModel 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetsPropertiesModel> selectAssetsPropertiesModelList(AssetsPropertiesModel assetsPropertiesModel);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsPropertiesModel 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetsPropertiesModel(AssetsPropertiesModel assetsPropertiesModel);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsPropertiesModel 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsPropertiesModel(AssetsPropertiesModel assetsPropertiesModel);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsPropertiesModelById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsPropertiesModelByIds(Long[] ids);
}
