package com.ruoyi.assets.service.impl;

import java.util.List;

import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.mapper.AssetsItemsMapper;
import com.ruoyi.common.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsAdminWarehouseMapper;
import com.ruoyi.assets.domain.AssetsAdminWarehouse;
import com.ruoyi.assets.service.IAssetsAdminWarehouseService;
import org.springframework.util.ObjectUtils;

/**
 * 管理员仓库Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@Service
public class AssetsAdminWarehouseServiceImpl implements IAssetsAdminWarehouseService 
{
    @Autowired
    private AssetsAdminWarehouseMapper assetsAdminWarehouseMapper;
    @Autowired
    private AssetsItemsMapper assetsItemsMapper;

    /**
     * 查询管理员仓库
     * 
     * @param id 管理员仓库ID
     * @return 管理员仓库
     */
    @Override
    public AssetsAdminWarehouse selectAssetsAdminWarehouseById(Long id)
    {
        return assetsAdminWarehouseMapper.selectAssetsAdminWarehouseById(id);
    }

    /**
     * 查询管理员仓库列表
     * 
     * @param assetsAdminWarehouse 管理员仓库
     * @return 管理员仓库
     */
    @Override
    public List<AssetsAdminWarehouse> selectAssetsAdminWarehouseList(AssetsAdminWarehouse assetsAdminWarehouse)
    {
        return assetsAdminWarehouseMapper.selectAssetsAdminWarehouseList(assetsAdminWarehouse);
    }

    /**
     * 新增管理员仓库
     * 
     * @param assetsAdminWarehouse 管理员仓库
     * @return 结果
     */
    @Override
    public int insertAssetsAdminWarehouse(AssetsAdminWarehouse assetsAdminWarehouse) {
        Long depositedWarehouseNum =assetsAdminWarehouse.getItemNum();
        AssetsItems assetsItems = assetsItemsMapper.selectAssetsItemsById(assetsAdminWarehouse.getItemId());
        if (assetsItems==null){
            throw new CustomException("选择的商品不存在");
        }
        AssetsAdminWarehouse adminWarehouse = assetsAdminWarehouseMapper.selectAssetsAdminWarehouseByItemId(assetsAdminWarehouse.getItemId());
        if (adminWarehouse!=null){
            depositedWarehouseNum+=adminWarehouse.getItemNum();
            adminWarehouse.setItemNum(depositedWarehouseNum);
            assetsAdminWarehouse=adminWarehouse;
        }
        if (assetsItems.getItemTotal()<depositedWarehouseNum||depositedWarehouseNum<0){
            throw new CustomException("存入商品数量不符实际");
        }
        return assetsAdminWarehouseMapper.insertAssetsAdminWarehouse(assetsAdminWarehouse);
    }

    /**
     * 修改管理员仓库
     * 
     * @param assetsAdminWarehouse 管理员仓库
     * @return 结果
     */
    @Override
    public int updateAssetsAdminWarehouse(AssetsAdminWarehouse assetsAdminWarehouse) {
        return assetsAdminWarehouseMapper.updateAssetsAdminWarehouse(assetsAdminWarehouse);
    }

    /**
     * 批量删除管理员仓库
     * 
     * @param ids 需要删除的管理员仓库ID
     * @return 结果
     */
    @Override
    public int deleteAssetsAdminWarehouseByIds(Long[] ids)
    {
        return assetsAdminWarehouseMapper.deleteAssetsAdminWarehouseByIds(ids);
    }

    /**
     * 删除管理员仓库信息
     * 
     * @param id 管理员仓库ID
     * @return 结果
     */
    @Override
    public int deleteAssetsAdminWarehouseById(Long id)
    {
        return assetsAdminWarehouseMapper.deleteAssetsAdminWarehouseById(id);
    }
}
