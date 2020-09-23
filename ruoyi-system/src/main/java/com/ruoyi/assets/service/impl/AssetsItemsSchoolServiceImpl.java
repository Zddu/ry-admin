package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsItemsSchoolMapper;
import com.ruoyi.assets.domain.AssetsItemsSchool;
import com.ruoyi.assets.service.IAssetsItemsSchoolService;

/**
 * 资产管理Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@Service
public class AssetsItemsSchoolServiceImpl implements IAssetsItemsSchoolService 
{
    @Autowired
    private AssetsItemsSchoolMapper assetsItemsSchoolMapper;

    /**
     * 查询资产管理
     * 
     * @param id 资产管理ID
     * @return 资产管理
     */
    @Override
    public AssetsItemsSchool selectAssetsItemsSchoolById(Long id)
    {
        return assetsItemsSchoolMapper.selectAssetsItemsSchoolById(id);
    }

    /**
     * 查询资产管理列表
     * 
     * @param assetsItemsSchool 资产管理
     * @return 资产管理
     */
    @Override
    public List<AssetsItemsSchool> selectAssetsItemsSchoolList(AssetsItemsSchool assetsItemsSchool)
    {
        return assetsItemsSchoolMapper.selectAssetsItemsSchoolList(assetsItemsSchool);
    }

    /**
     * 新增资产管理
     * 
     * @param assetsItemsSchool 资产管理
     * @return 结果
     */
    @Override
    public int insertAssetsItemsSchool(AssetsItemsSchool assetsItemsSchool)
    {
        assetsItemsSchool.setCreateTime(DateUtils.getNowDate());
        return assetsItemsSchoolMapper.insertAssetsItemsSchool(assetsItemsSchool);
    }

    /**
     * 修改资产管理
     * 
     * @param assetsItemsSchool 资产管理
     * @return 结果
     */
    @Override
    public int updateAssetsItemsSchool(AssetsItemsSchool assetsItemsSchool)
    {
        return assetsItemsSchoolMapper.updateAssetsItemsSchool(assetsItemsSchool);
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
        return assetsItemsSchoolMapper.deleteAssetsItemsSchoolByIds(ids);
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
        return assetsItemsSchoolMapper.deleteAssetsItemsSchoolById(id);
    }
}
