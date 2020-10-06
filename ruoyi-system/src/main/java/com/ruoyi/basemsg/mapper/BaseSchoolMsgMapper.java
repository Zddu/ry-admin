package com.ruoyi.basemsg.mapper;

import java.util.List;
import com.ruoyi.basemsg.domain.BaseSchoolMsg;

/**
 * 学校基本信息Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
public interface BaseSchoolMsgMapper 
{
    /**
     * 查询学校基本信息
     * 
     * @param id 学校基本信息ID
     * @return 学校基本信息
     */
    public BaseSchoolMsg selectBaseSchoolMsgById(Long id);

    /**
     * 查询学校基本信息列表
     * 
     * @param baseSchoolMsg 学校基本信息
     * @return 学校基本信息集合
     */
    public List<BaseSchoolMsg> selectBaseSchoolMsgList(BaseSchoolMsg baseSchoolMsg);

    /**
     * 新增学校基本信息
     * 
     * @param baseSchoolMsg 学校基本信息
     * @return 结果
     */
    public int insertBaseSchoolMsg(BaseSchoolMsg baseSchoolMsg);

    /**
     * 修改学校基本信息
     * 
     * @param baseSchoolMsg 学校基本信息
     * @return 结果
     */
    public int updateBaseSchoolMsg(BaseSchoolMsg baseSchoolMsg);

    /**
     * 删除学校基本信息
     * 
     * @param id 学校基本信息ID
     * @return 结果
     */
    public int deleteBaseSchoolMsgById(Long id);

    /**
     * 批量删除学校基本信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseSchoolMsgByIds(Long[] ids);
}
