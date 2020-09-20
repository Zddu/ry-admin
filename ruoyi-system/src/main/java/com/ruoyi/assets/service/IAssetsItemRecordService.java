package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetsItemRecord;
import com.ruoyi.assets.domain.AssetsOrders;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 记录表Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public interface IAssetsItemRecordService 
{
    /**
     * 查询记录表
     * 
     * @param id 记录表ID
     * @return 记录表
     */
    public AssetsItemRecord selectAssetsItemRecordById(Long id);

    /**
     * 查询记录表列表
     * 
     * @param assetsItemRecord 记录表
     * @param sysDept
     * @return 记录表集合
     */
    public List<AssetsItemRecord> selectAssetsItemRecordList(AssetsItemRecord assetsItemRecord, SysDept sysDept);

    /**
     * 新增记录表
     * 
     * @param assetsItemRecord 记录表
     * @return 结果
     */
    public int insertAssetsItemRecord(AssetsItemRecord assetsItemRecord);

    /**
     * 修改记录表
     * 
     * @param assetsItemRecord 记录表
     * @return 结果
     */
    public int updateAssetsItemRecord(AssetsItemRecord assetsItemRecord);

    /**
     * 批量删除记录表
     * 
     * @param ids 需要删除的记录表ID
     * @return 结果
     */
    public int deleteAssetsItemRecordByIds(Long[] ids);

    /**
     * 删除记录表信息
     * 
     * @param id 记录表ID
     * @return 结果
     */
    public int deleteAssetsItemRecordById(Long id);

    List<AssetsItemRecord> selectAssetsItemRecordByRecordId(String recordId);

    int insertAssetsItemRecordOperation(AssetsOrders assetsOrders, SysDept sysDept);
}
