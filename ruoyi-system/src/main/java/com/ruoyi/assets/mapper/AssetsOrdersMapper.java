package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetsOrders;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-18
 */
public interface AssetsOrdersMapper 
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
    public int insertAssetsOrders(AssetsOrders assetsOrders);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsOrders 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsOrders(AssetsOrders assetsOrders);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsOrdersById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsOrdersByIds(Long[] ids);
}
