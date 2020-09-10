package com.ruoyi.survey.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.survey.domain.QfSchoolAnswer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    public static void main(String[] args) {
        verificationRequired("{\"list\":[{\"type\":\"input\",\"icon\":\"icon-input\",\"options\":{\"width\":\"100%\",\"defaultValue\":\"\",\"required\":false,\"dataType\":\"string\",\"pattern\":\"\",\"placeholder\":\"\",\"disabled\":false,\"remoteFunc\":\"func_1599701561000_59718\"},\"name\":\"单行文本\",\"key\":\"1599701561000_59718\",\"model\":\"input_1599701561000_59718\",\"rules\":[{\"type\":\"string\",\"message\":\"单行文本格式不正确\"}]},{\"type\":\"color\",\"icon\":\"icon-color\",\"options\":{\"defaultValue\":\"\",\"disabled\":false,\"showAlpha\":false,\"required\":true,\"remoteFunc\":\"func_1599701574000_2212\"},\"name\":\"颜色选择器\",\"key\":\"1599701574000_2212\",\"model\":\"color_1599701574000_2212\",\"rules\":[{\"required\":true,\"message\":\"颜色选择器必须填写\"}]},{\"type\":\"select\",\"icon\":\"icon-select\",\"options\":{\"defaultValue\":\"\",\"multiple\":false,\"disabled\":false,\"clearable\":false,\"placeholder\":\"\",\"required\":false,\"showLabel\":false,\"width\":\"\",\"options\":[{\"value\":\"Option 1\"},{\"value\":\"Option 2\"},{\"value\":\"Option 3\"}],\"remote\":false,\"filterable\":false,\"remoteOptions\":[],\"props\":{\"value\":\"value\",\"label\":\"label\"},\"remoteFunc\":\"func_1599701575000_28694\"},\"name\":\"下拉选择框\",\"key\":\"1599701575000_28694\",\"model\":\"select_1599701575000_28694\",\"rules\":[]},{\"type\":\"switch\",\"icon\":\"icon-switch\",\"options\":{\"defaultValue\":false,\"required\":true,\"disabled\":false,\"remoteFunc\":\"func_1599701576000_38796\"},\"name\":\"开关\",\"key\":\"1599701576000_38796\",\"model\":\"switch_1599701576000_38796\",\"rules\":[{\"required\":true,\"message\":\"开关必须填写\"}]},{\"type\":\"slider\",\"icon\":\"icon-slider\",\"options\":{\"defaultValue\":0,\"disabled\":false,\"required\":true,\"min\":0,\"max\":100,\"step\":1,\"showInput\":false,\"range\":false,\"width\":\"\",\"remoteFunc\":\"func_1599701578000_95065\"},\"name\":\"滑块\",\"key\":\"1599701578000_95065\",\"model\":\"slider_1599701578000_95065\",\"rules\":[{\"required\":true,\"message\":\"滑块必须填写\"}]},{\"type\":\"textarea\",\"icon\":\"icon-diy-com-textarea\",\"options\":{\"width\":\"100%\",\"defaultValue\":\"\",\"required\":true,\"disabled\":false,\"pattern\":\"\",\"placeholder\":\"\",\"remoteFunc\":\"func_1599701562000_17396\"},\"name\":\"多行文本\",\"key\":\"1599701562000_17396\",\"model\":\"textarea_1599701562000_17396\",\"rules\":[{\"required\":true,\"message\":\"多行文本必须填写\"}]},{\"type\":\"text\",\"icon\":\"icon-wenzishezhi-\",\"options\":{\"defaultValue\":\"This is a text\",\"customClass\":\"\",\"remoteFunc\":\"func_1599701579000_69780\"},\"name\":\"文字\",\"key\":\"1599701579000_69780\",\"model\":\"text_1599701579000_69780\",\"rules\":[]},{\"type\":\"number\",\"icon\":\"icon-number\",\"options\":{\"width\":\"\",\"required\":false,\"defaultValue\":0,\"min\":0,\"max\":0,\"step\":1,\"disabled\":false,\"controlsPosition\":\"\",\"remoteFunc\":\"func_1599701563000_38495\"},\"name\":\"计数器\",\"key\":\"1599701563000_38495\",\"model\":\"number_1599701563000_38495\",\"rules\":[]},{\"type\":\"radio\",\"icon\":\"icon-radio-active\",\"options\":{\"inline\":false,\"defaultValue\":\"\",\"showLabel\":false,\"options\":[{\"value\":\"Option 1\",\"label\":\"Option 1\"},{\"value\":\"Option 2\",\"label\":\"Option 2\"},{\"value\":\"Option 3\",\"label\":\"Option 3\"}],\"required\":true,\"width\":\"\",\"remote\":false,\"remoteOptions\":[],\"props\":{\"value\":\"value\",\"label\":\"label\"},\"remoteFunc\":\"func_1599701564000_41508\",\"disabled\":false},\"name\":\"单选框组\",\"key\":\"1599701564000_41508\",\"model\":\"radio_1599701564000_41508\",\"rules\":[{\"required\":true,\"message\":\"单选框组必须填写\"}]},{\"type\":\"checkbox\",\"icon\":\"icon-check-box\",\"options\":{\"inline\":false,\"defaultValue\":[],\"showLabel\":false,\"options\":[{\"value\":\"Option 1\"},{\"value\":\"Option 2\"},{\"value\":\"Option 3\"}],\"required\":false,\"width\":\"\",\"remote\":false,\"remoteOptions\":[],\"props\":{\"value\":\"value\",\"label\":\"label\"},\"remoteFunc\":\"func_1599701566000_3005\",\"disabled\":false},\"name\":\"多选框组\",\"key\":\"1599701566000_3005\",\"model\":\"checkbox_1599701566000_3005\",\"rules\":[]},{\"type\":\"time\",\"icon\":\"icon-time\",\"options\":{\"defaultValue\":\"\",\"readonly\":false,\"disabled\":false,\"editable\":true,\"clearable\":true,\"placeholder\":\"\",\"startPlaceholder\":\"\",\"endPlaceholder\":\"\",\"isRange\":false,\"arrowControl\":true,\"format\":\"HH:mm:ss\",\"required\":false,\"width\":\"\",\"remoteFunc\":\"func_1599701567000_99823\"},\"name\":\"时间选择器\",\"key\":\"1599701567000_99823\",\"model\":\"time_1599701567000_99823\",\"rules\":[]},{\"type\":\"date\",\"icon\":\"icon-date\",\"options\":{\"defaultValue\":\"\",\"readonly\":false,\"disabled\":false,\"editable\":true,\"clearable\":true,\"placeholder\":\"\",\"startPlaceholder\":\"\",\"endPlaceholder\":\"\",\"type\":\"date\",\"format\":\"yyyy-MM-dd\",\"timestamp\":false,\"required\":false,\"width\":\"\",\"remoteFunc\":\"func_1599701569000_79997\"},\"name\":\"日期选择器\",\"key\":\"1599701569000_79997\",\"model\":\"date_1599701569000_79997\",\"rules\":[]},{\"type\":\"rate\",\"icon\":\"icon-pingfen1\",\"options\":{\"defaultValue\":0,\"max\":5,\"disabled\":false,\"allowHalf\":false,\"required\":false,\"remoteFunc\":\"func_1599701571000_53668\"},\"name\":\"评分\",\"key\":\"1599701571000_53668\",\"model\":\"rate_1599701571000_53668\",\"rules\":[]}],\"config\":{\"labelWidth\":100,\"labelPosition\":\"right\",\"size\":\"small\",\"customClass\":\"\"}}");
    }
}
