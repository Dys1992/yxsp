//package testcase;/**
// * @Author: Gosin
// * @Date: 2018/4/17 12:58
// */
//
//import bean.Exec;
//import bean.IsCollected;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import common.JsonAnalyze;
//import constants.UrlConstants;
//import jxl.read.biff.BiffException;
//import org.apache.log4j.Logger;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import util.ExcelUtils;
//import util.HttpUtils;
//
//import java.io.IOException;
//import java.util.HashMap;
//
///**
// * @Author: fanyu
// * @Date: 2018/4/17 12:58
// */
//public class CollectionTest {
//
//    private static final Logger log = Logger.getLogger(CollectionTest.class);
//
//    @BeforeTest
//
//    @DataProvider(name="iscollect")
//    public Object[][] isCollectedData() throws IOException, BiffException {
//        ExcelUtils excelUtils = new ExcelUtils("IsCollected.xls", "iscollected");
//        return excelUtils.getExcelData();
//    }
//
//    @DataProvider(name="exec")
//    public Object[][] execData() throws IOException, BiffException {
//        ExcelUtils excelUtils = new ExcelUtils("IsCollected.xls", "exec");
//        return excelUtils.getExcelData();
//    }
//
//
//
//    @Test(groups = "Collection",dataProvider = "iscollect")
//    public void ssCollectedTest(HashMap<String,String> data) throws IOException {
//
//        //获取请求的URL
//        String realUrl = data.get("URL");
//
//        //读取excel拿到入参，使用jsonbean转换为json去请求
//        IsCollected isCollected = new IsCollected(Integer.parseInt(data.get("uid")), data.get("videoBaseId"));
//        JSONObject jsonObj = (JSONObject) JSON.toJSON(isCollected);
//
//        String param = jsonObj.toJSONString();
//        //获取返回参数，解析出code，判断case是否通过
//        String result = HttpUtils.sendPost(realUrl,param);
//
//        log.info("URL:"+realUrl+",入参："+param);
//        log.info("返回参数:"+result);
//        JsonAnalyze jsonAnalyze  = new JsonAnalyze();
//        assert Integer.parseInt(jsonAnalyze.getStatus(result)) == Integer.parseInt(data.get("Code"));
//
//    }
//
//    @Test(groups = "Collection",dataProvider = "exec")
//    public void exec(HashMap<String,String> data) throws IOException {
//        Exec exec = new Exec(Integer.parseInt(data.get("uid")), data.get("videoBaseId"),Integer.parseInt(data.get("status"))
//                ,Integer.parseInt(data.get("flag")),data.get("bizType"));
//        JSONObject jsonObj = (JSONObject) JSON.toJSON(exec);
//        String realUrl = UrlConstants.EXEC;
//        String param = jsonObj.toJSONString();
//        String result = HttpUtils.sendPost(realUrl,param);
//
//        log.info("URL:"+realUrl+",入参："+param);
//        log.info("返回参数:"+result);
//
//        JsonAnalyze jsonAnalyze  = new JsonAnalyze();
//        assert Integer.parseInt(jsonAnalyze.getStatus(result)) == 0;
//
//    }
//
//
//}
