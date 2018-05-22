package testcase.dev.channel;

import constants.UrlConstants;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ExcelDataUtils;
import util.HttpRequestUtils;

import java.util.HashMap;

import static common.JsonAnalyze.getStatus;

/**
 * @Author: fanyu
 * @Date: 2018/5/22 18:22
 */
public class SearchNewTownChannelListTest {
    public static final Logger log = Logger.getLogger(SearchNewTownChannelListTest.class);

    @BeforeTest
    @DataProvider(name = "searchnewtownchannellist_dev")
    public Object[][] newTownChannelListData(){

        return ExcelDataUtils.getData("yxsp_channel_dev.xls", "searchnewtownchannellist");

    }

    @Test(dataProvider = "searchnewtownchannellist_dev")
    public void searchNewTownChannelListTest(HashMap<String,String> data) {

        String path;
        path = data.get("path");
        String param = data.get("body");

        String url = UrlConstants.YSXP_DEV+path;
        String result = HttpRequestUtils.sendPost(url, param);

        log.info("返回参数:"+result);
        log.info("URL:"+url+",入参："+param);

        assert Integer.parseInt(getStatus(result)) == Integer.parseInt(data.get("code"));

    }

}
