package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsItemsMapper;
import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.service.IAssetsItemsService;

/**
 * 资产管理Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@Service
public class AssetsItemsServiceImpl implements IAssetsItemsService
{
    @Autowired
    private AssetsItemsMapper assetsItemsMapper;

    /**
     * 查询资产管理
     * 
     * @param id 资产管理ID
     * @return 资产管理
     */
    @Override
    public AssetsItems selectAssetsItemsSchoolById(Long id)
    {
        return assetsItemsMapper.selectAssetsItemsSchoolById(id);
    }

    /**
     * 查询资产管理列表
     * 
     * @param assetsItems 资产管理
     * @return 资产管理
     */
    @Override
    public List<AssetsItems> selectAssetsItemsSchoolList(AssetsItems assetsItems)
    {
        return assetsItemsMapper.selectAssetsItemsSchoolList(assetsItems);
    }

    /**
     * 新增资产管理
     * 
     * @param assetsItems 资产管理
     * @return 结果
     */
    @Override
    public int insertAssetsItemsSchool(AssetsItems assetsItems)
    {
        assetsItems.setCreateTime(DateUtils.getNowDate());
        return assetsItemsMapper.insertAssetsItemsSchool(assetsItems);
    }

    /**
     * 修改资产管理
     * 
     * @param assetsItems 资产管理
     * @return 结果
     */
    @Override
    public int updateAssetsItemsSchool(AssetsItems assetsItems)
    {
        return assetsItemsMapper.updateAssetsItemsSchool(assetsItems);
    }

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的资产管理ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsSchoolByIds(Long[] ids)
    {
        return assetsItemsMapper.deleteAssetsItemsSchoolByIds(ids);
    }

    /**
     * 删除资产管理信息
     * 
     * @param id 资产管理ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsSchoolById(Long id)
    {
        return assetsItemsMapper.deleteAssetsItemsSchoolById(id);
    }
}
