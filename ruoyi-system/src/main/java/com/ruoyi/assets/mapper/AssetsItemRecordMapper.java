package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetsItemRecord;

/**
 * 记录表Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public interface AssetsItemRecordMapper 
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
     * @return 记录表集合
     */
    public List<AssetsItemRecord> selectAssetsItemRecordList(AssetsItemRecord assetsItemRecord);

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
     * 删除记录表
     * 
     * @param id 记录表ID
     * @return 结果
     */
    public int deleteAssetsItemRecordById(Long id);

    /**
     * 批量删除记录表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsItemRecordByIds(Long[] ids);

    List<AssetsItemRecord> selectAssetsItemRecordByRecordId(String recordId);


}
