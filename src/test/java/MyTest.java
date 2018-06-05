import bean.httpbean.HttpHeaderBean;
import util.HttpRequestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fanyu
 * @Date: 2018/6/5 14:51
 */
public class MyTest {
    public static void main(String[] args) {

        //测试http请求
        String url = "http://test.dxapi.youxiang0210.com/mobile/video/getVMusics";
        String post = "{\n" +
                "\t\"clientId\": \"jc_youxiang_app\",\n" +
                "\t\"secret\": \"13c5b701c1ef49c0b032ce41b9bec5c2\",\n" +
                "\t\"uuid\": \"1C8CE778-4286-4810-BDCC-9C7E59DED8D6\",\n" +
                "\t\"appVersion\": \"0.3.3\",\n" +
                "\t\"deviceOsType\": 2,\n" +
                "\t\"accessToken\": \"42790d98edeb4d74952b524027924fa7\",\n" +
                "\t\"uid\": \"20070\",\n" +
                "\t\"offset\": \"1\",\n" +
                "\t\"limit\": \"3\"\n" +
                "}";

        List<HttpHeaderBean> list = new ArrayList<>();
        HttpHeaderBean httpHeaderBean = new HttpHeaderBean();
        httpHeaderBean.setKey("Connection" );
        httpHeaderBean.setValue("keep-alive");

        list.add(httpHeaderBean);

        String response = HttpRequestUtils.sendPost(url,post,list);

        System.out.println(response);
    }
}
