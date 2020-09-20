package com.ruoyi.assets.service.impl;

import java.util.List;

import com.ruoyi.assets.domain.AssetsAdminWarehouse;
import com.ruoyi.assets.domain.AssetsItemRecord;
import com.ruoyi.assets.domain.AssetsSchoolWarehouse;
import com.ruoyi.assets.mapper.AssetsAdminWarehouseMapper;
import com.ruoyi.assets.mapper.AssetsSchoolWarehouseMapper;
import com.ruoyi.assets.service.IAssetsItemRecordService;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsOrdersMapper;
import com.ruoyi.assets.domain.AssetsOrders;
import com.ruoyi.assets.service.IAssetsOrdersService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-18
 */
@Service
public class AssetsOrdersServiceImpl implements IAssetsOrdersService {
    @Autowired
    private AssetsOrdersMapper assetsOrdersMapper;
    @Autowired
    private IAssetsItemRecordService  assetsItemRecordService;
    @Autowired
    private AssetsAdminWarehouseMapper assetsAdminWarehouseMapper;
    @Autowired
    private AssetsSchoolWarehouseMapper assetsSchoolWarehouseMapper;
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public AssetsOrders selectAssetsOrdersById(Long id)
    {
        return assetsOrdersMapper.selectAssetsOrdersById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsOrders 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetsOrders> selectAssetsOrdersList(AssetsOrders assetsOrders)
    {
        return assetsOrdersMapper.selectAssetsOrdersList(assetsOrders);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsOrdersList 【请填写功能名称】
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAssetsOrders(List<AssetsOrders> assetsOrdersList,SysDept sysDept) {
        for (AssetsOrders assetsOrders : assetsOrdersList) {
            if (assetsOrders.getItemNum()==null){
                continue;
            }
            AssetsItemRecord record = new AssetsItemRecord();
            BeanUtils.copyProperties(assetsOrders,record);
            assetsItemRecordService.insertAssetsItemRecordOperation(assetsOrders,sysDept);
            AssetsAdminWarehouse assetsAdminWarehouse = assetsAdminWarehouseMapper.selectAssetsAdminWarehouseByItemId(assetsOrders.getItemId());
            if (assetsAdminWarehouse.getItemNum()-assetsOrders.getItemNum()<0||assetsOrders.getItemNum()<0){
                throw new CustomException("商品数量异常");
            }
            assetsAdminWarehouse.setItemNum(assetsAdminWarehouse.getItemNum()-assetsOrders.getItemNum());
            assetsAdminWarehouseMapper.updateAssetsAdminWarehouse(assetsAdminWarehouse);
            assetsOrdersMapper.insertAssetsOrders(assetsOrders);
        }
        return 1;
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsOrders 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetsOrders(AssetsOrders assetsOrders)
    {
        return assetsOrdersMapper.updateAssetsOrders(assetsOrders);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsOrdersByIds(Long[] ids)
    {
        return assetsOrdersMapper.deleteAssetsOrdersByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsOrdersById(Long id)
    {
        return assetsOrdersMapper.deleteAssetsOrdersById(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int confirmOrders(List<Long> assetsOrdersIds,SysDept sysDept) {
        for (Long id : assetsOrdersIds) {
            AssetsOrders assetsOrders = assetsOrdersMapper.selectAssetsOrdersById(id);
            assetsOrders.setState(2L);
            assetsOrders.setCreateTime(DateUtils.getNowDate());
            assetsItemRecordService.insertAssetsItemRecordOperation(assetsOrders,sysDept);

            AssetsSchoolWarehouse assetsSchoolWarehouse = new AssetsSchoolWarehouse();
            BeanUtils.copyProperties(
                    assetsAdminWarehouseMapper.selectAssetsAdminWarehouseByItemId(assetsOrders.getItemId()),
                    assetsSchoolWarehouse);
            assetsSchoolWarehouse.setItemNum(assetsOrders.getItemNum());
            assetsSchoolWarehouseMapper.insertAssetsSchoolWarehouse(assetsSchoolWarehouse);
        }
        return 1;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public int withdrawalOrders(List<Long> assetsOrdersIds, SysDept sysDept) {
        for (Long id : assetsOrdersIds) {
            AssetsOrders assetsOrders = assetsOrdersMapper.selectAssetsOrdersById(id);
            assetsOrders.setState(1L);
            assetsOrders.setCreateTime(DateUtils.getNowDate());
            assetsItemRecordService.insertAssetsItemRecordOperation(assetsOrders,sysDept);
            AssetsAdminWarehouse assetsAdminWarehouse = assetsAdminWarehouseMapper.selectAssetsAdminWarehouseByItemId(assetsOrders.getItemId());
            assetsAdminWarehouse.setItemNum(assetsAdminWarehouse.getItemNum()+assetsOrders.getItemNum());
            assetsAdminWarehouseMapper.updateAssetsAdminWarehouse(assetsAdminWarehouse);
            assetsOrdersMapper.deleteAssetsOrdersById(assetsOrders.getId());
        }
        return 1;
    }
}
