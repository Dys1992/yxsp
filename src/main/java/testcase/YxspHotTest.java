package testcase;

import common.JsonAnalyze;
import constants.UrlConstants;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ExcelUtils;
import util.HttpRequestUtils;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: fanyu
 * @Date: 2018/5/15 11:13
 */

public class YxspHot {

    public static final Logger log = Logger.getLogger(YxspHot.class);

    @BeforeTest()
    @DataProvider(name="banner")
    public Object[][] bannerData() throws IOException, BiffException {
        ExcelUtils excelUtils = new ExcelUtils("yxsp_hot.xls", "banner");
        return excelUtils.getExcelData();
    }

    @Test(groups = "banner",dataProvider = "banner")
    public void bannerTest(HashMap<String,String> data) {
         String result = null;
        //获取请求的URL
        String path = data.get("path");
        String url = UrlConstants.YSXP_DEV+path;
        String param = data.get("baby");
        String environment = data.get("environment");
        if(Integer.parseInt(environment) == 0){
            result = HttpRequestUtils.sendPost(url, param);
        }
        log.info("URL:"+url+",入参："+param);
        log.info("返回参数:"+result);

        assert Integer.parseInt(JsonAnalyze.getStatus(result)) == Integer.parseInt(data.get("code"));

    }

}
