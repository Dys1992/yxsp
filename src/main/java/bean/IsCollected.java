package bean;/**
 * @Author: Gosin
 * @Date: 2018/4/17 16:46
 */

import java.io.Serializable;

/**
 * @Author: fanyu
 * @Date: 2018/4/17 16:46
 */
public class IsCollected implements Serializable {

    private int uid;
    private String videoBaseId;

    public IsCollected(){
        super();
    }

    public IsCollected(int uid, String videoBaseId){
        super();
        this.uid = uid;
        this.videoBaseId = videoBaseId;
    }

    public int getUid() {
        return uid;
    }


    public String getVideoBaseId() {
        return videoBaseId;
    }

}
