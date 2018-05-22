package testcase.hot.master;

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
 * @Date: 2018/5/17 10:48
 */
public class BannerTest {

    public static final Logger log = Logger.getLogger(BannerTest.class);

    @BeforeTest()
    @DataProvider(name="banner_mst")
    public Object[][] bannerData(){
        return ExcelDataUtils.getData("yxsp_hot.xls", "banner");
    }


    @Test(dataProvider = "banner_mst")
    public void bannerTest(HashMap<String,String> data) {
        String result = null;
        //获取请求的URL
        String path = data.get("path");
        String param = data.get("body");
        String environment = data.get("environment");
        String url = null;

        if (Integer.parseInt(environment) == 1){

            url = UrlConstants.YSXP_DEV+path;
            result = HttpRequestUtils.sendPost(url, param);
        }else{
            url = UrlConstants.YSXP_MST+path;
            result = HttpRequestUtils.sendPost(url,param);

        }

        log.info("返回参数:"+result);
        log.info("URL:"+url+",入参："+param);

        assert Integer.parseInt(JsonAnalyze.getStatus(result)) == Integer.parseInt(data.get("code"));

    }


}
