package com.ruoyi.basemsg.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.basemsg.mapper.BaseSchoolMsgMapper;
import com.ruoyi.basemsg.domain.BaseSchoolMsg;
import com.ruoyi.basemsg.service.IBaseSchoolMsgService;
import org.springframework.util.ObjectUtils;

/**
 * 学校基本信息Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
@Service
public class BaseSchoolMsgServiceImpl implements IBaseSchoolMsgService 
{
    @Autowired
    private BaseSchoolMsgMapper baseSchoolMsgMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;
    /**
     * 查询学校基本信息
     * 
     * @param id 学校基本信息ID
     * @return 学校基本信息
     */
    @Override
    public BaseSchoolMsg selectBaseSchoolMsgById(Long id)
    {
        return baseSchoolMsgMapper.selectBaseSchoolMsgById(id);
    }

    /**
     * 查询学校基本信息列表
     * 
     * @param baseSchoolMsg 学校基本信息
     * @return 学校基本信息
     */
    @Override
    public List<BaseSchoolMsg> selectBaseSchoolMsgList(BaseSchoolMsg baseSchoolMsg)
    {
        List<BaseSchoolMsg> baseSchoolMsgs = baseSchoolMsgMapper.selectBaseSchoolMsgList(baseSchoolMsg);
        for (BaseSchoolMsg schoolMsg : baseSchoolMsgs) {
            SysDept sysDept = sysDeptMapper.selectDeptById(schoolMsg.getSchoolId());
            if (sysDept==null){
                throw new RuntimeException("学校id查询不到名称");
            }
            schoolMsg.setSchoolName(sysDept.getDeptName());
        }
        return baseSchoolMsgs;
    }

    /**
     * 新增学校基本信息
     * 
     * @param baseSchoolMsg 学校基本信息
     * @return 结果
     */
    @Override
    public int insertBaseSchoolMsg(BaseSchoolMsg baseSchoolMsg)
    {
        return baseSchoolMsgMapper.insertBaseSchoolMsg(baseSchoolMsg);
    }

    /**
     * 修改学校基本信息
     * 
     * @param baseSchoolMsg 学校基本信息
     * @return 结果
     */
    @Override
    public int updateBaseSchoolMsg(BaseSchoolMsg baseSchoolMsg)
    {
        return baseSchoolMsgMapper.updateBaseSchoolMsg(baseSchoolMsg);
    }

    /**
     * 批量删除学校基本信息
     * 
     * @param ids 需要删除的学校基本信息ID
     * @return 结果
     */
    @Override
    public int deleteBaseSchoolMsgByIds(Long[] ids)
    {
        return baseSchoolMsgMapper.deleteBaseSchoolMsgByIds(ids);
    }

    /**
     * 删除学校基本信息信息
     * 
     * @param id 学校基本信息ID
     * @return 结果
     */
    @Override
    public int deleteBaseSchoolMsgById(Long id)
    {
        return baseSchoolMsgMapper.deleteBaseSchoolMsgById(id);
    }
}
