package com.ruoyi.assets.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsSchoolWarehouseMapper;
import com.ruoyi.assets.domain.AssetsSchoolWarehouse;
import com.ruoyi.assets.service.IAssetsSchoolWarehouseService;

/**
 * 学校仓库Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@Service
public class AssetsSchoolWarehouseServiceImpl implements IAssetsSchoolWarehouseService 
{
    @Autowired
    private AssetsSchoolWarehouseMapper assetsSchoolWarehouseMapper;

    /**
     * 查询学校仓库
     * 
     * @param id 学校仓库ID
     * @return 学校仓库
     */
    @Override
    public AssetsSchoolWarehouse selectAssetsSchoolWarehouseById(Long id)
    {
        return assetsSchoolWarehouseMapper.selectAssetsSchoolWarehouseById(id);
    }

    /**
     * 查询学校仓库列表
     * 
     * @param assetsSchoolWarehouse 学校仓库
     * @return 学校仓库
     */
    @Override
    public List<AssetsSchoolWarehouse> selectAssetsSchoolWarehouseList(AssetsSchoolWarehouse assetsSchoolWarehouse)
    {
        return assetsSchoolWarehouseMapper.selectAssetsSchoolWarehouseList(assetsSchoolWarehouse);
    }

    /**
     * 新增学校仓库
     * 
     * @param assetsSchoolWarehouse 学校仓库
     * @return 结果
     */
    @Override
    public int insertAssetsSchoolWarehouse(AssetsSchoolWarehouse assetsSchoolWarehouse)
    {
        return assetsSchoolWarehouseMapper.insertAssetsSchoolWarehouse(assetsSchoolWarehouse);
    }

    /**
     * 修改学校仓库
     * 
     * @param assetsSchoolWarehouse 学校仓库
     * @return 结果
     */
    @Override
    public int updateAssetsSchoolWarehouse(AssetsSchoolWarehouse assetsSchoolWarehouse)
    {
        return assetsSchoolWarehouseMapper.updateAssetsSchoolWarehouse(assetsSchoolWarehouse);
    }

    /**
     * 批量删除学校仓库
     * 
     * @param ids 需要删除的学校仓库ID
     * @return 结果
     */
    @Override
    public int deleteAssetsSchoolWarehouseByIds(Long[] ids)
    {
        return assetsSchoolWarehouseMapper.deleteAssetsSchoolWarehouseByIds(ids);
    }

    /**
     * 删除学校仓库信息
     * 
     * @param id 学校仓库ID
     * @return 结果
     */
    @Override
    public int deleteAssetsSchoolWarehouseById(Long id)
    {
        return assetsSchoolWarehouseMapper.deleteAssetsSchoolWarehouseById(id);
    }
}
