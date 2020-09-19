package com.ruoyi.assets.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsItemRecordMapper;
import com.ruoyi.assets.domain.AssetsItemRecord;
import com.ruoyi.assets.service.IAssetsItemRecordService;

/**
 * 记录表Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@Service
public class AssetsItemRecordServiceImpl implements IAssetsItemRecordService {
    @Autowired
    private AssetsItemRecordMapper assetsItemRecordMapper;

    /**
     * 查询记录表
     * 
     * @param id 记录表ID
     * @return 记录表
     */
    @Override
    public AssetsItemRecord selectAssetsItemRecordById(Long id) {
        return assetsItemRecordMapper.selectAssetsItemRecordById(id);
    }

    /**
     * 查询记录表列表
     * 
     * @param assetsItemRecord 记录表
     * @return 记录表
     */
    @Override
    public List<AssetsItemRecord> selectAssetsItemRecordList(AssetsItemRecord assetsItemRecord) {
        List<AssetsItemRecord> assetsItemRecords = assetsItemRecordMapper.selectAssetsItemRecordList(assetsItemRecord);
        return assetsItemRecords;
    }

    /**
     * 新增记录表
     * 
     * @param assetsItemRecord 记录表
     * @return 结果
     */
    @Override
    public int insertAssetsItemRecord(AssetsItemRecord assetsItemRecord) {
        return assetsItemRecordMapper.insertAssetsItemRecord(assetsItemRecord);
    }

    /**
     * 修改记录表
     * 
     * @param assetsItemRecord 记录表
     * @return 结果
     */
    @Override
    public int updateAssetsItemRecord(AssetsItemRecord assetsItemRecord)
    {
        return assetsItemRecordMapper.updateAssetsItemRecord(assetsItemRecord);
    }

    /**
     * 批量删除记录表
     * 
     * @param ids 需要删除的记录表ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemRecordByIds(Long[] ids)
    {
        return assetsItemRecordMapper.deleteAssetsItemRecordByIds(ids);
    }

    /**
     * 删除记录表信息
     * 
     * @param id 记录表ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemRecordById(Long id)
    {
        return assetsItemRecordMapper.deleteAssetsItemRecordById(id);
    }

    @Override
    public List<AssetsItemRecord> selectAssetsItemRecordByRecordId(String recordId) {
        return assetsItemRecordMapper.selectAssetsItemRecordByRecordId(recordId);
    }
}
