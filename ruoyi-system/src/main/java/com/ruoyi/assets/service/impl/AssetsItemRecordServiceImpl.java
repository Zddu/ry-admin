package com.ruoyi.assets.service.impl;

import java.util.List;

import com.ruoyi.assets.domain.AssetsOrders;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private SysDeptMapper sysDeptMapper;
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
     * @param sysDept
     * @return 记录表
     */
    @Override
    public List<AssetsItemRecord> selectAssetsItemRecordList(AssetsItemRecord assetsItemRecord, SysDept sysDept) {

        initAssetsItemRecordByDeptId(assetsItemRecord,sysDept);

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

    @Override
    public int insertAssetsItemRecordOperation(AssetsOrders assetsOrders, SysDept sysDept) {
//        initRecordByDeptId(assetsOrders,sysDept);
        AssetsItemRecord assetsItemRecord = new AssetsItemRecord();
        BeanUtils.copyProperties(assetsOrders,assetsItemRecord);
        Long pid = sysDeptMapper.selectParentDepByChildId(sysDept.getDeptId());
        if (pid==0){
            assetsItemRecord.setOperatorId(sysDept.getDeptId());
        }else{
            assetsItemRecord.setOperatorId(pid);
        }
        return assetsItemRecordMapper.insertAssetsItemRecord(assetsItemRecord);
    }


    /**
     * 根据登录用户所属单位初始化查询条件类
     * @param assetsItemRecord 查询条件类
     * @param sysDept 登录用户的单位信息类
     */

    private void initAssetsItemRecordByDeptId(AssetsItemRecord assetsItemRecord, SysDept sysDept) {
        if (sysDept.getParentId()==0){
            assetsItemRecord.setAdminDelete(0);
        }else{
            assetsItemRecord.setOperatorId(sysDept.getParentId());
            assetsItemRecord.setSchoolDelete(0);
        }
    }
}
