package com.ruoyi.assets.service.impl;


import com.ruoyi.assets.domain.AssetsPropertiesModel;
import com.ruoyi.assets.mapper.AssetsPropertiesModelMapper;
import com.ruoyi.assets.service.IAssetsPropertiesModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
@Service
public class AssetsPropertiesModelServiceImpl implements IAssetsPropertiesModelService {
    @Autowired
    private AssetsPropertiesModelMapper assetsPropertiesModelMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public AssetsPropertiesModel selectAssetsPropertiesModelById(Long id)
    {
        return assetsPropertiesModelMapper.selectAssetsPropertiesModelById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsPropertiesModel 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetsPropertiesModel> selectAssetsPropertiesModelList(AssetsPropertiesModel assetsPropertiesModel)
    {
        return assetsPropertiesModelMapper.selectAssetsPropertiesModelList(assetsPropertiesModel);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsPropertiesModel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetsPropertiesModel(AssetsPropertiesModel assetsPropertiesModel)
    {
        return assetsPropertiesModelMapper.insertAssetsPropertiesModel(assetsPropertiesModel);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsPropertiesModel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetsPropertiesModel(AssetsPropertiesModel assetsPropertiesModel)
    {
        return assetsPropertiesModelMapper.updateAssetsPropertiesModel(assetsPropertiesModel);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsPropertiesModelByIds(Long[] ids)
    {
        return assetsPropertiesModelMapper.deleteAssetsPropertiesModelByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsPropertiesModelById(Long id)
    {
        return assetsPropertiesModelMapper.deleteAssetsPropertiesModelById(id);
    }

    @Override
    public List<AssetsPropertiesModel> selectAssetsPropertiesModel() {

        return assetsPropertiesModelMapper.selectAssetsPropertiesModel();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int modifyPropertiesModel(List<AssetsPropertiesModel> assetsPropertiesModels) {
        assetsPropertiesModelMapper.deleteAssetsPropertiesModel();
        return assetsPropertiesModelMapper.modifyPropertiesModel(assetsPropertiesModels);
    }
}
