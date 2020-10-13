package com.ruoyi.survey.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.file.mapper.FileMapper;
import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.domain.vo.QfKeyIndexAnswer;
import com.ruoyi.survey.mapper.QfCreateFormMapper;
import com.ruoyi.survey.mapper.QfKeyNameMapper;
import com.ruoyi.survey.mapper.QfUserFormMapper;
import com.ruoyi.survey.util.ExcelUtil;
import com.ruoyi.survey.util.ImportData2ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfSchoolAnswerMapper;
import com.ruoyi.survey.domain.QfSchoolAnswer;
import com.ruoyi.survey.service.IQfSchoolAnswerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-08
 */
@Service
public class QfSchoolAnswerServiceImpl implements IQfSchoolAnswerService{
    @Autowired
    private QfSchoolAnswerMapper qfSchoolAnswerMapper;
    @Autowired
    private QfUserFormMapper qfUserFormMapper;
    @Autowired
    private QfKeyNameMapper qfKeyNameMapper;
    @Autowired
    private QfCreateFormMapper qfCreateFormMapper;
    @Autowired
    private FileMapper fileMapper;
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public QfSchoolAnswer selectQfSchoolAnswerById(Long id)
    {
        return qfSchoolAnswerMapper.selectQfSchoolAnswerById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<QfSchoolAnswer> selectQfSchoolAnswerList(QfSchoolAnswer qfSchoolAnswer)
    {
        return qfSchoolAnswerMapper.selectQfSchoolAnswerList(qfSchoolAnswer);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer) {

        if(qfSchoolAnswer!=null&&qfSchoolAnswer.getId()!=null){
            if (qfSchoolAnswer.getIsTemporary()==1){
                throw new CustomException("您不能重复提交，如需修改请联系问卷发布者");
            }
            return qfSchoolAnswerMapper.updateQfSchoolAnswer(qfSchoolAnswer);
        }
        return qfSchoolAnswerMapper.insertQfSchoolAnswer(qfSchoolAnswer);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer)
    {
        return qfSchoolAnswerMapper.updateQfSchoolAnswer(qfSchoolAnswer);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfSchoolAnswerByIds(Long[] ids)
    {
        return qfSchoolAnswerMapper.deleteQfSchoolAnswerByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfSchoolAnswerById(Long id)
    {
        return qfSchoolAnswerMapper.deleteQfSchoolAnswerById(id);
    }

    @Override
    public List<QfSchoolAnswer> selectQfSchoolAnswerListBySId(Long cid, Long sid, Integer isSchool) {
        return qfSchoolAnswerMapper.selectQfSchoolAnswerListBySId(cid,sid,isSchool);
    }


    @Override
    public AjaxResult exportQfSchoolAnswer(Long cid) {
        Map<String,String> titleMap =new HashMap<>();
//        titleMap.put("学校","学校名称");
        List<String> titleList =new ArrayList<>();
//        titleList.add("学校名称");
        List<QfKeyName> keyNames = qfKeyNameMapper.selectQfKeyNameList(new QfKeyName(cid));

        for (QfKeyName keyName : keyNames) {
            titleMap.put(keyName.getKey(),keyName.getName());
            titleList.add(keyName.getName());
        }
        List<List<QfKeyIndexAnswer>> values =new ArrayList<>();
        for (QfUserForm qfUserForm:qfUserFormMapper.selectQfUserFormList(new QfUserForm(cid))){
            List<QfSchoolAnswer> qfSchoolAnswers = qfSchoolAnswerMapper.selectQfSchoolAnswerListBySId(cid, qfUserForm.getSchoolId().longValue(), 0);
            List<QfKeyIndexAnswer> answers = new ArrayList<>();

//            answers.add(new QfKeyIndexAnswer(0,qfUserForm.getSchoolName()));
            for (QfSchoolAnswer qfSchoolAnswer : qfSchoolAnswers) {
                QfKeyIndexAnswer answer = new QfKeyIndexAnswer();
                answer.setKeyIndex(
                        titleList.indexOf(
                                titleMap.get(qfSchoolAnswer.getKey().substring(qfSchoolAnswer.getKey().indexOf("_")+1)
                                )
                        )
                );
                answer.setValue(qfSchoolAnswer.getValue());
                answers.add(answer);
            }
            if (!answers.isEmpty()){
                values.add(answers);
            }

        }
        return ExcelUtil.emloyeeExcel(titleList,values,qfCreateFormMapper.selectQfCreateFormById(cid).getTitle()+".xlsx");
    }

    @Override
    public AjaxResult exportQfSchoolAnswerByModel(Long cid,Long mid) {
        String fileName=qfCreateFormMapper.selectQfCreateFormById(cid).getTitle()+".xls";
        List<QfUserForm> list= qfUserFormMapper.selectQfUserFormList(new QfUserForm(cid));
        List<List<String>> values = new ArrayList<>();
        for (QfUserForm qfUserForm : list) {
            List<String> answers =new ArrayList<>();
            answers.addAll(qfSchoolAnswerMapper.selectAnswerBySFid(qfUserForm.getId()));
            if (!answers.isEmpty()){
                values.add(answers);
            }

        }
        try (FileInputStream fileInputStream = new FileInputStream(new File(fileMapper.selectModelByQfModelId(mid).getModelUrl()))) {
            ImportData2ExcelUtils importData2ExcelUtils = new ImportData2ExcelUtils(fileInputStream);
            importData2ExcelUtils.fillData2OriginExcel(new FileOutputStream(getAbsoluteFile(fileName)),values);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("文件创建失败");
        }
        return AjaxResult.success(fileName);
    }



    private static String getAbsoluteFile(String filename) {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }
}
