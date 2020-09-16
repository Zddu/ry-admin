package com.ruoyi.survey.mapper;

import java.util.List;
import com.ruoyi.survey.domain.QfSchoolAnswer;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-08
 */
public interface QfSchoolAnswerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public QfSchoolAnswer selectQfSchoolAnswerById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<QfSchoolAnswer> selectQfSchoolAnswerList(QfSchoolAnswer qfSchoolAnswer);

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    public int insertQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer);

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    public int updateQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfSchoolAnswerById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQfSchoolAnswerByIds(Long[] ids);

    List<QfSchoolAnswer> selectQfSchoolAnswerListBySId(@Param("cid") Long cid,@Param("sid") Long sid);

    List<QfSchoolAnswer> selectAllQfSchoolAnswer();

    int updateQfSchoolAnswerByKeyAndSchool(QfSchoolAnswer keyName);

    List<String> selectAnswerBySFid(@Param("id") Long id);
}
