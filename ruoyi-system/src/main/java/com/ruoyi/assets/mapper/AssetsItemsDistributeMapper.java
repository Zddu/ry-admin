package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetsItemsDistribute;
import org.apache.ibatis.annotations.Param;

/**
 * 资产分发Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-10-16
 */
public interface AssetsItemsDistributeMapper 
{
    /**
     * 查询资产分发
     * 
     * @param id 资产分发ID
     * @return 资产分发
     */
    public AssetsItemsDistribute selectAssetsItemsDistributeById(Long id);

    /**
     * 查询资产分发列表
     * 
     * @param assetsItemsDistribute 资产分发
     * @return 资产分发集合
     */
    public List<AssetsItemsDistribute> selectAssetsItemsDistributeList(AssetsItemsDistribute assetsItemsDistribute);

    /**
     * 新增资产分发
     * 
     * @param assetsItemsDistribute 资产分发
     * @return 结果
     */
    public int insertAssetsItemsDistribute(AssetsItemsDistribute assetsItemsDistribute);

    /**
     * 修改资产分发
     * 
     * @param assetsItemsDistribute 资产分发
     * @return 结果
     */
    public int updateAssetsItemsDistribute(AssetsItemsDistribute assetsItemsDistribute);

    /**
     * 删除资产分发
     * 
     * @param id 资产分发ID
     * @return 结果
     */
    public int deleteAssetsItemsDistributeById(Long id);

    /**
     * 批量删除资产分发
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsItemsDistributeByIds(Long[] ids);


    AssetsItemsDistribute selectAssetsItemsDistributeByBelongerAndBatch(@Param("batch") String batch,@Param("itemBelonger") Long itemBelonger);
}
