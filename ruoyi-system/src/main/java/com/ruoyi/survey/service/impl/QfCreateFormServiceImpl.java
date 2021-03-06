package com.ruoyi.survey.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.survey.domain.QfCreateModel;
import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.domain.vo.QfKeyNameVo;
import com.ruoyi.survey.domain.vo.QfUserFormVo;
import com.ruoyi.survey.domain.vo.SchoolVO;
import com.ruoyi.survey.mapper.QfCreateModelMapper;
import com.ruoyi.survey.mapper.QfKeyNameMapper;
import com.ruoyi.survey.mapper.QfUserFormMapper;
import com.ruoyi.survey.util.QfUtils;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfCreateFormMapper;
import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.survey.service.IQfCreateFormService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@Service
public class QfCreateFormServiceImpl implements IQfCreateFormService {
    @Autowired
    private QfCreateFormMapper qfCreateFormMapper;
    @Autowired
    private QfKeyNameMapper qfKeyNameMapper;
    @Autowired
    private QfUserFormMapper qfUserFormMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private QfCreateModelMapper qfCreateModelMapper;
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public QfCreateForm selectQfCreateFormById(Long id)
    {
        return qfCreateFormMapper.selectQfCreateFormById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<QfCreateForm> selectQfCreateFormList(QfCreateForm qfCreateForm)
    {
        return qfCreateFormMapper.selectQfCreateFormList(qfCreateForm);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQfCreateForm(QfCreateForm qfCreateForm)
    {
        qfCreateForm.setCreateTime(DateUtils.getNowDate());
        return qfCreateFormMapper.insertQfCreateForm(qfCreateForm);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQfCreateForm(QfCreateForm qfCreateForm)
    {
        return qfCreateFormMapper.updateQfCreateForm(qfCreateForm);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteQfCreateFormByIds(Long[] ids) {
        qfKeyNameMapper.deleteQfKeyNameByIds(ids);
        qfUserFormMapper.deleteQfUserFormByIds(ids);
        return qfCreateFormMapper.deleteQfCreateFormByIds(ids);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertQuestionnaire(QfCreateForm qfCreateForm)  {
        qfCreateForm.setStrData(QfUtils.restructureJson(qfCreateForm.getStrData()));
        QfKeyNameVo qfKeyNames = JSONObject.parseObject(qfCreateForm.getStrData(), QfKeyNameVo.class);
        int size =-1;
        size = qfCreateFormMapper.insertQfCreateForm(qfCreateForm);
        HashSet<String> set =new HashSet<>();
        for (QfKeyName qfKeyName : qfKeyNames.getList()) {
            set.add(qfKeyName.getName());
        }
        if (set.size()!=qfKeyNames.getList().size()){
            throw new CustomException("有重复标题的数据");
        }
        for (QfKeyName qfKeyName : qfKeyNames.getList()) {
            size = qfKeyNameMapper.insertQfKeyName(qfKeyName.setCreateId(qfCreateForm.getId()));
        }

        return size;
    }

    @Override
    public List<QfCreateForm> selectQfCreateFormByUsername(String username, QfCreateForm qfCreateForm) {
        List<QfCreateForm> qfCreateForms = qfCreateFormMapper.selectQfCreateFormByUsername(username, qfCreateForm);
        return qfCreateForms;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitQfCreateForm(QfUserFormVo qfUserFormVo) {
        if (qfUserFormVo==null||qfUserFormVo.getEndTime()==null){
            throw new CustomException("请设置截止时间");
        }
        for (SchoolVO school:qfUserFormVo.getSchools()) {
            qfUserFormMapper.insertQfUserForm(new QfUserForm(qfUserFormVo.getCreateId(),school.getSchoolName(),school.getSchoolId()));
        }
        return qfCreateFormMapper.updateQfCreateForm(new QfCreateForm(qfUserFormVo.getCreateId(),1,qfUserFormVo.getEndTime(),new Date()));
    }

    @Override
    public QfCreateForm selectQfCreateFormAndUserFormReasonById(Long cid,Long sid) {

        return qfCreateFormMapper.selectQfCreateFormAndUserFormReasonById(cid,sid);
    }

    @Override
    public int withdrawQfCreateForm(QfUserFormVo qfUserFormVo) {
        for (SchoolVO school:qfUserFormVo.getSchools()) {
            QfUserForm qfUserForm = qfUserFormMapper.selectQfSchoolFormBySId(school.getSchoolId().longValue(), qfUserFormVo.getCreateId());
            qfUserFormMapper.deleteQfUserFormById(qfUserForm.getId());
        }
        return qfCreateFormMapper.updateQfCreateForm(new QfCreateForm(new Date(),qfUserFormVo.getCreateId(),0));
    }

    @Override
    public int insertQuestionnaireCustom(QfCreateForm qfCreateForm, Boolean isMould) {
        qfCreateForm.setStrData(QfUtils.restructureJson(qfCreateForm.getStrData()));
        QfKeyNameVo qfKeyNames = JSONObject.parseObject(qfCreateForm.getStrData(), QfKeyNameVo.class);
        int size =-1;

        QfCreateModel qfCreateModel = new QfCreateModel();
        BeanUtils.copyProperties(qfCreateForm,qfCreateModel);
        HashSet<String> set =new HashSet<>();
        for (QfKeyName qfKeyName : qfKeyNames.getList()) {
            set.add(qfKeyName.getName());
        }
        if (set.size()!=qfKeyNames.getList().size()){
            throw new CustomException("问卷中的标题有重复");
        }

        size += qfCreateFormMapper.insertQfCreateForm(qfCreateForm);
        for (QfKeyName qfKeyName : qfKeyNames.getList()) {
            size += qfKeyNameMapper.insertQfKeyName(qfKeyName.setCreateId(qfCreateForm.getId()));
        }
        if (isMould){
            size+=qfCreateModelMapper.insertQfCreateModel(qfCreateModel);
        }
        return size;
    }
}
