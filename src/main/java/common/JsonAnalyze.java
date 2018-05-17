package common;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * @Author: fanyu
 * @Date: 2018/4/17 15:52
 */

public class JsonAnalyze {

    private static final Logger log = Logger.getLogger(JsonAnalyze.class);

    public static String getStatus(String str) {
        String status = null;
        if (str != null) {
            JSONObject jsonObject = JSONObject.parseObject(str);
            status = jsonObject.getString("code");


        } else {
            log.error("返回参数为空");
        }

        return status;
    }

    public static String getAssert(String str){


        return "";
    }



}
