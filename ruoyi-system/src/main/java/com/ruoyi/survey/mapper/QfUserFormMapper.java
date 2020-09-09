package com.ruoyi.survey.mapper;

import java.util.List;
import com.ruoyi.survey.domain.QfUserForm;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public interface QfUserFormMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public QfUserForm selectQfUserFormById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<QfUserForm> selectQfUserFormList(QfUserForm qfUserForm);

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 结果
     */
    public int insertQfUserForm(QfUserForm qfUserForm);

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 结果
     */
    public int updateQfUserForm(QfUserForm qfUserForm);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfUserFormById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQfUserFormByIds(Long[] ids);

    List<QfUserForm> selectQfSchoolFormList(@Param("id") Long id);

    QfUserForm selectQfSchoolFormBySId(@Param("sid") Long sid,@Param("cid") Long cid);
}
