package common;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * @Author: fanyu
 * @Date: 2018/4/17 15:52
 */

public class JsonAnalyze {

    private static final Logger log = Logger.getLogger(JsonAnalyze.class);

    public String getStatus(String str){

        if (str ==""){
            log.error("返回参数为空");
        }
        JSONObject jsonObject = JSONObject.parseObject(str);
        String status = jsonObject.getString("code");
        return status;

    }



}
