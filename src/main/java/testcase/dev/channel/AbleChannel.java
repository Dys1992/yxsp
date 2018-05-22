package testcase.dev.channel;

import common.JsonAnalyze;
import constants.UrlConstants;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ExcelDataUtils;
import util.HttpRequestUtils;

import java.util.HashMap;

/**
 * @Author: fanyu
 * @Date: 2018/5/22 18:22
 */
public class AbleChannel {
    public static final Logger log = Logger.getLogger(AbleChannel.class);

    @BeforeTest
    @DataProvider(name = "ablechannel_dev")
    public Object[][] ableChannelData(){

        return ExcelDataUtils.getData("yxsp_channel_dev.xls", "AbleChannel");

    }

    @Test(dataProvider = "ablechannel_dev")
    public void ableChannelTest(HashMap<String,String> data) {

        String path = data.get("path");
        String param = data.get("body");

        String url = UrlConstants.YSXP_DEV+path;
        String result = HttpRequestUtils.sendPost(url, param);

        log.info("返回参数:"+result);
        log.info("URL:"+url+",入参："+param);

        assert Integer.parseInt(JsonAnalyze.getStatus(result)) == Integer.parseInt(data.get("code"));

    }

}
