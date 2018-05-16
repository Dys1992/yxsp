package bean.mobile.hot;/**
 * @Author: fanyu
 * @Date: 2018/5/4 17:07
 */

/**
 * @Author: Gosin
 * @Date: 2018/5/4 17:07
 */
public class HotCard {

    private String clientId;

    private String secret;

    private String uuid;

    private String appVersion;

    private int deviceOsType;

    private String accessToken;

    private int page;

    private String size;

    public void setClientId(String clientId){
        this.clientId = clientId;
    }
    public String getClientId(){
        return this.clientId;
    }
    public void setSecret(String secret){
        this.secret = secret;
    }
    public String getSecret(){
        return this.secret;
    }
    public void setUuid(String uuid){
        this.uuid = uuid;
    }
    public String getUuid(){
        return this.uuid;
    }
    public void setAppVersion(String appVersion){
        this.appVersion = appVersion;
    }
    public String getAppVersion(){
        return this.appVersion;
    }
    public void setDeviceOsType(int deviceOsType){
        this.deviceOsType = deviceOsType;
    }
    public int getDeviceOsType(){
        return this.deviceOsType;
    }
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    public String getAccessToken(){
        return this.accessToken;
    }
    public void setPage(int page){
        this.page = page;
    }
    public int getPage(){
        return this.page;
    }
    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return this.size;
    }

}
