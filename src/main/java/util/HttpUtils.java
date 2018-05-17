package util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * @author fanyu
 */
public class HttpUtils {

    private static final Logger log = Logger.getLogger(HttpUtils.class);

    private static RequestConfig requestConfig;

    static {
        requestConfig = RequestConfig.custom().setSocketTimeout(4000).setConnectionRequestTimeout(4000).build();
    }

    /**
     * 发送get请求
     * @url url 路径
     * @param param 参数
     */
    public static String senGet(String url,String param) {

        String realUrl = url+"?"+param;
        String result = null ;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(realUrl);
        request.setConfig(requestConfig);

        try{
            CloseableHttpResponse response = client.execute(request);

            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //读取服务器返回的字符串
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity,"utf-8");
            }else{
                log.error("get请求提交失败："+realUrl);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("get请求提交失败："+realUrl);
            e.printStackTrace();
        } finally {
            request.releaseConnection();
        }


        return result;
    }


//    public static String sendPost(String url, String strParam){
//
//        CloseableHttpClient client = HttpClients.createDefault();
//        String  result = null;
//        HttpPost httpPost = new HttpPost(url);
//        try{
//            if(null != strParam){
//
//                StringEntity entity = new StringEntity(strParam,"UTF-8");
//                entity.setContentEncoding("UTF-8");
//                entity.setContentType("application/json");
//                httpPost.setEntity(entity);
//            }
//            CloseableHttpResponse result1 = client.execute(httpPost);
//
//            if (result1.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//                try{
//                    result = EntityUtils.toString(result1.getEntity(),"UTF-8");
//                }catch (Exception e){
//                    log.error("post请求提交失败:" + url, e);
//                }
//            }
//
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            log.error("post请求提交失败:" + url, e);
//            e.printStackTrace();
//        }
//
//        return result;
//
//    }

//    public static String sendPost(String url, String data) {
//        String response = null;
//        log.info("url: " + url);
//        log.info("request: " + data);
//        try {
//            CloseableHttpClient httpclient = null;
//            CloseableHttpResponse httpresponse = null;
//            try {
//                httpclient = HttpClients.createDefault();
//                HttpPost httppost = new HttpPost(url);
//                StringEntity stringentity = new StringEntity(data,
//                        ContentType.create("text/json", "UTF-8"));
//                httppost.setEntity(stringentity);
//                httpresponse = httpclient.execute(httppost);
//                response = EntityUtils
//                        .toString(httpresponse.getEntity());
//                log.info("response: " + response);
//            } finally {
//                if (httpclient != null) {
//                    httpclient.close();
//                }
//                if (httpresponse != null) {
//                    httpresponse.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return response;
//    }
}
