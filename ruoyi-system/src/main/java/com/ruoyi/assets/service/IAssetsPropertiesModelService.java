package com.ruoyi.assets.service;


import com.ruoyi.assets.domain.AssetsPropertiesModel;
import com.ruoyi.assets.domain.vo.ModelVo;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
public interface IAssetsPropertiesModelService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsPropertiesModelByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsPropertiesModelById(Long id);

    List<AssetsPropertiesModel> selectAssetsPropertiesModel();

    int modifyPropertiesModel(ModelVo assetsPropertiesModels);
}
