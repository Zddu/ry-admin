package com.ruoyi.assets.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsItemsMaintenanceMapper;
import com.ruoyi.assets.domain.AssetsItemsMaintenance;
import com.ruoyi.assets.service.IAssetsItemsMaintenanceService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
@Service
public class AssetsItemsMaintenanceServiceImpl implements IAssetsItemsMaintenanceService 
{
    @Autowired
    private AssetsItemsMaintenanceMapper assetsItemsMaintenanceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public AssetsItemsMaintenance selectAssetsItemsMaintenanceById(Long id)
    {
        return assetsItemsMaintenanceMapper.selectAssetsItemsMaintenanceById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsItemsMaintenance 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetsItemsMaintenance> selectAssetsItemsMaintenanceList(AssetsItemsMaintenance assetsItemsMaintenance)
    {
        return assetsItemsMaintenanceMapper.selectAssetsItemsMaintenanceList(assetsItemsMaintenance);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsItemsMaintenance 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetsItemsMaintenance(AssetsItemsMaintenance assetsItemsMaintenance)
    {
        return assetsItemsMaintenanceMapper.insertAssetsItemsMaintenance(assetsItemsMaintenance);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsItemsMaintenance 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetsItemsMaintenance(AssetsItemsMaintenance assetsItemsMaintenance)
    {
        return assetsItemsMaintenanceMapper.updateAssetsItemsMaintenance(assetsItemsMaintenance);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsMaintenanceByIds(Long[] ids)
    {
        return assetsItemsMaintenanceMapper.deleteAssetsItemsMaintenanceByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsMaintenanceById(Long id)
    {
        return assetsItemsMaintenanceMapper.deleteAssetsItemsMaintenanceById(id);
    }
}
