package com.ruoyi.survey.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.uuid.UUID;

/**
 * @date 2020/9/10 -- 8:50
 **/
public class QfUtils {
    public static void verificationRequired(String answer, String form) {

    }

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
}
