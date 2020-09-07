package com.ruoyi.survey.service;

import java.util.HashMap;
import java.util.List;
import com.ruoyi.survey.domain.QfKeyName;

import javax.servlet.http.HttpServletResponse;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public interface IQfKeyNameService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public QfKeyName selectQfKeyNameById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfKeyName 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<QfKeyName> selectQfKeyNameList(QfKeyName qfKeyName);

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfKeyName 【请填写功能名称】
     * @return 结果
     */
    public int insertQfKeyName(QfKeyName qfKeyName);

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfKeyName 【请填写功能名称】
     * @return 结果
     */
    public int updateQfKeyName(QfKeyName qfKeyName);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfKeyNameByIds(Long[] ids);





    void export(HttpServletResponse response, Long id);
}
