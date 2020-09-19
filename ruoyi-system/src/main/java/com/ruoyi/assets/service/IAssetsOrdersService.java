package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetsOrders;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-18
 */
public interface IAssetsOrdersService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public AssetsOrders selectAssetsOrdersById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsOrders 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetsOrders> selectAssetsOrdersList(AssetsOrders assetsOrders);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsOrders 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetsOrders(List<AssetsOrders> assetsOrders,SysDept sysDept);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsOrders 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsOrders(AssetsOrders assetsOrders);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsOrdersByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsOrdersById(Long id);

    int withdrawalOrders(List<Long> assetsOrdersIds);

    int confirmOrders(List<Long> assetsOrdersIds);

    void initAssetsOrders(List<AssetsOrders> list, Long state, SysDept dept);
}
