package bean;

/**
 * @Author: fanyu
 * @Date: 2018/4/17 17:41
 */
public class Exec {

    private int uid;
    private String videoBaseId;
    private int status;
    private int flag;
    private String bizType;

    public Exec(){
        super();
    }


    public Exec(int uid,String videoBaseId,int status,int flag,String bizType){
        super();
        this.uid = uid;
        this.videoBaseId = videoBaseId;
        this.status = status;
        this.flag = flag;
        this.bizType = bizType;

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getVideoBaseId() {
        return videoBaseId;
    }

    public void setVideoBaseId(String videoBaseId) {
        this.videoBaseId = videoBaseId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
