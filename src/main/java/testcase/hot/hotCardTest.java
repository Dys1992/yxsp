package testcase;

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

public class YxspHotTest {

    public static final Logger log = Logger.getLogger(YxspHotTest.class);

    @BeforeTest()
    @DataProvider(name="banner")
    public Object[][] bannerData(){
        return ExcelDataUtils.getData("yxsp_hot.xls", "banner");
    }
    @DataProvider(name="hotCard")
    public Object[][] hotCardData()  {
        return ExcelDataUtils.getData("yxsp_hot.xls", "hotCard");
    }




    @Test(groups = "hot",dataProvider = "hotCard")
    public void hotCardTest(HashMap<String,String> data) {
        String result = null;
        String url = UrlConstants.YSXP_DEV+data.get("path");
        String param = data.get("body");
        System.out.println(param);
        String environment = data.get("environment");

        if(Integer.parseInt(environment) == 0){
            result = HttpRequestUtils.sendPost(url, param);
        }
        log.info("URL:"+url+",入参："+param);
        log.info("返回参数:"+result);


        assert Integer.parseInt(JsonAnalyze.getStatus(result))==Integer.parseInt(data.get("code"));
    }

}
