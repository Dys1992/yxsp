package testcase.dev.hot;

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
 * @Date: 2018/5/15 11:13
 */

public class HotCardTest {

    public static final Logger log = Logger.getLogger(HotCardTest.class);

    @BeforeTest()
    @DataProvider(name="hotCard_dev")
    public Object[][] hotCardData()  {
        return ExcelDataUtils.getData("yxsp_hot.xls", "hotCard");
    }

    @Test(dataProvider = "hotCard_dev")
    public void hotCardTest(HashMap<String,String> data) {

        String url = UrlConstants.YSXP_DEV+data.get("path");
        String param = data.get("body");
        System.out.println(param);
        String result = HttpRequestUtils.sendPost(url, param);

        log.info("URL:"+url+",入参："+param);
        log.info("返回参数:"+result);

        assert Integer.parseInt(JsonAnalyze.getStatus(result))==Integer.parseInt(data.get("code"));
    }

}
