package util;

import bean.httpbean.HttpHeaderBean;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * @author fanyu
 * @Date: 2018/5/15 11:13
 */
public class HttpRequestUtils {

    public static final Logger log = Logger.getLogger(HttpRequestUtils.class);
    private static String result;

    /**
     * 私有构造方法
     * */
    private HttpRequestUtils(){

    }

    private static RequestConfig requestConfig;

    static {
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectionRequestTimeout(2000).build();
    }

    /**
     * @param url 请求url地址
     * @param strParam 请求参数
     */
    public static String sendGet(String url,String strParam){

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url+"?"+strParam);
        try {
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse result1 = client.execute(httpGet);

            if(result1.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                try{

                    result = EntityUtils.toString(result1.getEntity(),"UTF-8");

                }catch (Exception e){

                    log.error("post请求提交失败:" + url, e);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    /**
     * @param url 请求url地址
     * @param strParam 请求参数
     */
    public static String sendPost(String url, String strParam){

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try{
            if(null != strParam){
                StringEntity entity = new StringEntity(strParam,"UTF-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
                httpPost.setConfig(requestConfig);
            }else {
                log.error("请求参数为空");
            }

            CloseableHttpResponse result1 = client.execute(httpPost);

            if (result1.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                try{

                    result = EntityUtils.toString(result1.getEntity(),"UTF-8");

                }catch (Exception e){

                    log.error("post请求提交失败:" + url, e);

                }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
            e.printStackTrace();
        }

        return result;
    }

    /**
     * @param url 请求地址
     * @param dataStr 请求体
     * @param list 请求头
     * */
    public static String sendPost(String url, String dataStr, List<HttpHeaderBean> list){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        try{
            if(null != dataStr){
                for(HttpHeaderBean httpRequest : list){
                    httpPost.addHeader(httpRequest.getKey(),httpRequest.getValue());
                }
                StringEntity entity = new StringEntity(dataStr,"UTF-8");
                entity.setContentEncoding("UTF-8");

                entity.setContentType("application/json");
                httpPost.setEntity(entity);
                httpPost.setConfig(requestConfig);
            }else {
                log.error("请求参数为空");
            }

            CloseableHttpResponse result1 = client.execute(httpPost);

            if (result1.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                try{

                    result = EntityUtils.toString(result1.getEntity(),"UTF-8");

                }catch (Exception e){

                    log.error("post请求提交失败:" + url, e);

                }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
            e.printStackTrace();
        }

        return result;
    }



}
