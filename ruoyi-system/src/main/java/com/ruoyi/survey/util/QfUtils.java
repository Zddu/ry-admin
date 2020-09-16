package com.ruoyi.survey.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.survey.domain.QfSchoolAnswer;


import java.util.*;

/**
 * @date 2020/9/10 -- 8:50
 **/
public class QfUtils {


    public static String restructureJson(String str) {
        JSONObject obj = JSON.parseObject(str);
        String listJson=obj.getString("list");

        JSONArray list = JSON.parseArray(listJson);
        for (int i = 0; i < list.size(); i++) {
            String s = UUID.randomUUID().toString().replaceAll("-", "");
            list.getJSONObject(i).put("key",s);
            list.getJSONObject(i).put("model","_"+s);
        }
        obj.put("list",list);
        return JSON.toJSONString(obj);

    }

    public static void verificationRequired(String str) {
        JSONObject obj = JSON.parseObject(str);
        String listJson=obj.getString("list");
        JSONArray list = JSON.parseArray(listJson);
        HashSet<String> titles=new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            String options = list.getJSONObject(i).getString("options");
            JSONObject jsonObject = JSON.parseObject(options);
            Object required = jsonObject.get("required");
            if (required==null){
            }else {
                if ((Boolean)required){
                    titles.add(list.getJSONObject(i).getString("model"));
                }
            }
        }
        QfSchoolAnswer.setRequiredTitles(titles);
    }

    public static String getValueType(Map map, String key) {
        if (map.get(key) instanceof String){
           return "string";
        }
        else if (map.get(key) instanceof Integer){
            return "number";
        }
        else if (map.get(key) ==null){
           return null;
        }else{
           return "array";
        }
    }

    public static void endTime2Last(List<QfCreateForm> qfCreateForms) {
        List<QfCreateForm> item =new ArrayList<>();
        //将截止的放到最后
        for (QfCreateForm createForm : qfCreateForms) {
            if (createForm.getEndTime().getTime()<=new Date().getTime()){
                item.add(createForm);
            }
        }
        for (QfCreateForm qfCreateForm : item) {
            qfCreateForms.remove(qfCreateForm);
        }
        qfCreateForms.addAll(item);

    }


    public static List<QfCreateForm>  rejected2Head(List<QfCreateForm> qfCreateForms) {
        List<QfCreateForm> item =new ArrayList<>();
        //将已驳回的放到最前面
        for (QfCreateForm createForm : qfCreateForms) {
            if (createForm.getState()==2){
                item.add(createForm);
            }
        }
        for (QfCreateForm qfCreateForm : item) {
            qfCreateForms.remove(qfCreateForm);
        }
        item.addAll(qfCreateForms);
       return item;
    }
}
