package util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @Author: fanyu
 * @Date: 2018/5/17 11:03
 */
public class AnalysisJson {

    public static List<Object> analysisJson(String str,String assertKey){
        List<Object> list = null;
        Map<String,Object> map = JSON.parseObject(str);
        for (Map.Entry<String,Object> entry:map.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();
            if( value instanceof JSONObject){
                analysisJson(((JSONObject) value).toJSONString(),assertKey);
            }
            if (value instanceof JSONArray){
                analysisJsonArray((JSONArray) value,assertKey);
            }else {
                if (assertKey .equals(key)){
                    System.out.println(key +"1111111111111"+assertKey);
                    list.add(value);
                }
            }
        }
        return list;
    }

    private static Object analysisJsonArray(JSONArray jsonArray,String assertKey){
        Object value = null;
        for(int i = 0 ; i < jsonArray.size(); i++){
            Object json = jsonArray.get(i);
            if(json instanceof JSONObject){
                analysisJson(String.valueOf(json),assertKey);
            }else if (json instanceof JSONArray){
                analysisJsonArray((JSONArray) json,assertKey);
            }else {
                value = String.valueOf(json);
            }
        }
        return value;
    }



    public static void main(String[] args) {
        List<Object> st1 = analysisJson("{\"code\":0,\"errmsg\":null,\"data\":{\"models\":[{\"id\":10607,\"cardName\":\"直播间\",\"layoutId\":1,\"cardType\":1,\"title\":null,\"moreFlag\":0,\"moreUrl\":null,\"sort\":1,\"channelId\":100068,\"backImg\":\"\",\"backLayout\":null,\"enable\":1,\"gmtCreated\":1524906174000,\"gmtModified\":1526525661000,\"cardName2\":null,\"mdata\":[{\"id\":126,\"cardId\":10607,\"name\":\"重庆国际少儿时装周\",\"title\":\"2018重庆国际少儿时装周\",\"liveRoomId\":\"l2698431516148736\",\"liveStatus\":1,\"liveRoomStatus\":1,\"liveDesc\":\"<p>2018重庆国际少儿时装周，将于5.16-5.20在重庆TMG艺术中心盛大开幕，11场大牌童装发布会。届时，来自全国各地的少模汇聚一堂，上演5天4夜的大牌童装发布秀，是不是已经按捺不住那颗想要绽放在绚丽舞台上躁动的心了？与小象一起，静待5月吧~</p>\",\"sort\":1,\"imgUrl\":\"back-1526452926737-cTi9Mo3lMB\",\"rtmpPlayUrl\":\"rtmp://pili-live-rtmp.youxiang0210.com/live-prod/l2698431516148736\",\"hlsPlayUrl\":\"https://pili-live-hls.youxiang0210.com/live-prod/l2698431516148736.m3u8\",\"scheduleTime\":1526526000000,\"playbackStatus\":0,\"playbackUrl\":\"http://live-prod.youxiang0210.com/recordings/z1.live-prod.l2698431516148736/1526525836_1526527075.m3u8\"}],\"imageBannerUrl\":\"back-1526525660536-Mt7F1IQmAx\",\"titleStyleType\":null,\"imgTitleStyleUrl\":null,\"buttomStyleType\":null,\"imgButtomStyleUrl\":null,\"type\":null},{\"id\":10608,\"cardName\":\"专场发布预告\",\"layoutId\":2,\"cardType\":2,\"title\":null,\"moreFlag\":0,\"moreUrl\":null,\"sort\":2,\"channelId\":100068,\"backImg\":\"\",\"backLayout\":null,\"enable\":1,\"gmtCreated\":1524906222000,\"gmtModified\":1526525641000,\"cardName2\":null,\"mdata\":{\"videos\":[{\"id\":3287,\"cardId\":10608,\"name\":\"开幕式【完整版】\",\"subName\":null,\"videoId\":\"v2698730969662464\",\"videoName\":null,\"sort\":1,\"url\":\"\",\"imageUrl\":\"back-1526472991549-H54wuEihNW\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3276,\"cardId\":10608,\"name\":\"孙海涛童装发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":2,\"url\":\"#\",\"imageUrl\":\"back-1524906605826-dgFBskZNDL\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3277,\"cardId\":10608,\"name\":\"Maya’s童装发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":3,\"url\":\"#\",\"imageUrl\":\"back-1524906663771-SJ7MRTUX0X\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3278,\"cardId\":10608,\"name\":\"草莓南瓜童装发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":4,\"url\":\"#\",\"imageUrl\":\"back-1524906731635-ltpm45trxv\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3279,\"cardId\":10608,\"name\":\"LE LUPERCUS童装发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":5,\"url\":\"#\",\"imageUrl\":\"back-1524906787623-8rfcAsNZvb\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3280,\"cardId\":10608,\"name\":\"DKLTJU少儿定制服饰发布会\",\"subName\":null,\"videoId\":\"\",\"videoName\":null,\"sort\":6,\"url\":\"#\",\"imageUrl\":\"back-1524907473860-VUhuD7LBoT\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3281,\"cardId\":10608,\"name\":\"映画童衣少儿定制服饰发布会\",\"subName\":null,\"videoId\":\"\",\"videoName\":null,\"sort\":7,\"url\":\"#\",\"imageUrl\":\"back-1524907514808-bFg0ZvuFXe\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3282,\"cardId\":10608,\"name\":\"Joy&Joa儿童高级定制发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":8,\"url\":\"#\",\"imageUrl\":\"back-1524907154839-C53csi5stO\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3283,\"cardId\":10608,\"name\":\"FolliFollie童装发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":9,\"url\":\"#\",\"imageUrl\":\"back-1524907217053-a1CBVWmCOW\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3284,\"cardId\":10608,\"name\":\"意树童装发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":10,\"url\":\"#\",\"imageUrl\":\"back-1524907266244-fmu5abQ7SX\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3285,\"cardId\":10608,\"name\":\"JOJO by sunwei概念发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":11,\"url\":\"#\",\"imageUrl\":\"back-1524907335384-9CFcwmS4AM\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3286,\"cardId\":10608,\"name\":\"蒂莉娅高端私人订制发布会\",\"subName\":null,\"videoId\":null,\"videoName\":null,\"sort\":12,\"url\":\"#\",\"imageUrl\":\"back-1524907386608-lZK7lQgCCE\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null}]},\"imageBannerUrl\":\"back-1526525639089-ScUiAhP3Xw\",\"titleStyleType\":0,\"imgTitleStyleUrl\":null,\"buttomStyleType\":1,\"imgButtomStyleUrl\":null,\"type\":null},{\"id\":10605,\"cardName\":\"2017重庆国际少儿时装周\",\"layoutId\":4,\"cardType\":2,\"title\":null,\"moreFlag\":0,\"moreUrl\":null,\"sort\":3,\"channelId\":100068,\"backImg\":\"\",\"backLayout\":null,\"enable\":1,\"gmtCreated\":1524904694000,\"gmtModified\":1526525648000,\"cardName2\":\"未来由我设计\",\"mdata\":{\"videos\":[{\"id\":3263,\"cardId\":10605,\"name\":\"重庆国际少儿时装周开幕式\",\"subName\":null,\"videoId\":\"v2658865051354112\",\"videoName\":null,\"sort\":1,\"url\":null,\"imageUrl\":\"back-1524905374207-Y2C9HafwvI\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3264,\"cardId\":10605,\"name\":\"B+王玉涛童装发布会\",\"subName\":null,\"videoId\":\"v2658867573638144\",\"videoName\":null,\"sort\":2,\"url\":null,\"imageUrl\":\"back-1524905067450-vLmTxItgQf\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3265,\"cardId\":10605,\"name\":\"CHiVCHilD【恩致】高级定制童装发布会\",\"subName\":null,\"videoId\":\"v2658870047933440\",\"videoName\":null,\"sort\":3,\"url\":null,\"imageUrl\":\"back-1524905095182-VoWsNl9PeW\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3266,\"cardId\":10605,\"name\":\"gxg.kids“Color Kingdom”童装发布\",\"subName\":null,\"videoId\":\"v2658871242884096\",\"videoName\":null,\"sort\":4,\"url\":null,\"imageUrl\":\"back-1524905125939-xb5mfAQ03Y\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3267,\"cardId\":10605,\"name\":\"Folli Follie童装发布会\",\"subName\":null,\"videoId\":\"v2658871776789504\",\"videoName\":null,\"sort\":5,\"url" +
                "\":null,\"imageUrl\":\"back-1524905142726-rUpoT2hI0N\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3268,\"cardId\":10605,\"name\":\"山海经·异想 JOJO by sunwei概念发布会\",\"subName\":null,\"videoId\":\"v2658872366908416\",\"videoName\":null,\"sort\":6,\"url\":null,\"imageUrl\":\"back-1524905171469-punfx2Df2z\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null}]},\"imageBannerUrl\":\"back-1526525646875-6pnjUR37GG\",\"titleStyleType\":0,\"imgTitleStyleUrl\":null,\"buttomStyleType\":1,\"imgButtomStyleUrl\":null,\"type\":null},{\"id\":10605,\"cardName\":\"未来由我设计\",\"layoutId\":4,\"cardType\":2,\"title\":null,\"moreFlag\":0,\"moreUrl\":null,\"sort\":3,\"channelId\":100068,\"backImg\":\"\",\"backLayout\":null,\"enable\":1,\"gmtCreated\":1524904694000,\"gmtModified\":1526525648000,\"cardName2\":\"未来由我设计\",\"mdata\":{\"videos\":[{\"id\":3269,\"cardId\":10605,\"name\":\"重心起航T100童装发布会\",\"subName\":null,\"videoId\":\"v2658872855004160\",\"videoName\":null,\"sort\":7,\"url\":null,\"imageUrl\":\"back-1524905195165-a20jTO2b1O\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3270,\"cardId\":10605,\"name\":\"Joy&Joa儿童高级定制发布会\",\"subName\":null,\"videoId\":\"v2658873344656384\",\"videoName\":null,\"sort\":8,\"url\":null,\"imageUrl\":\"back-1524905212638-zkBStG6CRR\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3271,\"cardId\":10605,\"name\":\"Pider BB童装发布会\",\"subName\":null,\"videoId\":\"v2658873797444608\",\"videoName\":null,\"sort\":9,\"url\":null,\"imageUrl\":\"back-1524905229129-jSsIds4anx\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3272,\"cardId\":10605,\"name\":\"重庆国际少儿时装周闭幕式\",\"subName\":null,\"videoId\":\"v2658874333856768\",\"videoName\":null,\"sort\":10,\"url\":null,\"imageUrl\":\"back-1524905251578-MDZQkdhzcZ\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3273,\"cardId\":10605,\"name\":\"2017届官方宣传片\",\"subName\":null,\"videoId\":\"v2658863738078208\",\"videoName\":null,\"sort\":11,\"url\":null,\"imageUrl\":\"back-1524905367723-7q1SE746RS\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3274,\"cardId\":10605,\"name\":\"2017届完整版合集\",\"subName\":null,\"videoId\":\"v2657365020689408\",\"videoName\":null,\"sort\":12,\"url\":null,\"imageUrl\":\"back-1524905343649-akftTGynki\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null}]},\"imageBannerUrl\":\"back-1526525646875-6pnjUR37GG\",\"titleStyleType\":0,\"imgTitleStyleUrl\":null,\"buttomStyleType\":1,\"imgButtomStyleUrl\":null,\"type\":null},{\"id\":10609,\"cardName\":\"首届回顾\",\"layoutId\":3,\"cardType\":2,\"title\":null,\"moreFlag\":0,\"moreUrl\":null,\"sort\":9999,\"channelId\":100068,\"backImg\":\"\",\"backLayout\":null,\"enable\":1,\"gmtCreated\":1524909283000,\"gmtModified\":1526525656000,\"cardName2\":null,\"mdata\":{\"videos\":[{\"id\":3288,\"cardId\":10609,\"name\":\"首届重庆国际少儿时装周开幕式\",\"subName\":null,\"videoId\":\"v2658746401620992\",\"videoName\":null,\"sort\":1,\"url\":null,\"imageUrl\":\"back-1524909473013-LNLpM5q0KU\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3289,\"cardId\":10609,\"name\":\"JOJO童装发布会\",\"subName\":null,\"videoId\":\"v2658747756528640\",\"videoName\":null,\"sort\":2,\"url\":null,\"imageUrl\":\"back-1524909492204-V0KglOfwYR\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3290,\"cardId\":10609,\"name\":\"轻奢潮牌Follifollie发布会\",\"subName\":null,\"videoId\":\"v2658748492612608\",\"videoName\":null,\"sort\":3,\"url\":null,\"imageUrl\":\"back-1524909509169-zMFNY0ny2X\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3291,\"cardId\":10609,\"name\":\"新锐潮牌Pider BB发布会\",\"subName\":null,\"videoId\":\"v2658749329589248\",\"videoName\":null,\"sort\":4,\"url\":null,\"imageUrl\":\"back-1524909525202-PrBWerfZik\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3292,\"cardId\":10609,\"name\":\"著名设计师品牌恩致Chivchild发布会\",\"subName\":null,\"videoId\":\"v2658750432838656\",\"videoName\":null,\"sort\":5,\"url\":null,\"imageUrl\":\"back-1524909542491-CTPiDNqYHC\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3293,\"cardId\":10609,\"name\":\"中法跨国设计师品牌BALLON ROUGE发布会\",\"subName\":null,\"videoId\":\"v2658751234327552\",\"videoName\":null,\"sort\":6,\"url\":null,\"imageUrl\":\"back-1524909556804-hXz1KSXD02\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3294,\"cardId\":10609,\"name\":\"大卫·查尔斯专场发布会\",\"subName\":null,\"videoId\":\"v2658844915319808\",\"videoName\":null,\"sort\":7,\"url\":null,\"imageUrl\":\"back-1524909599704-VVU498bUbV\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3295,\"cardId\":10609,\"name\":\"PIU’PIU’AMORE发布会\",\"subName\":null,\"videoId\":\"v2658845893919744\",\"videoName\":null,\"sort\":8,\"url\":null,\"imageUrl\":\"back-1524909624522-dmokA8qwQi\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null},{\"id\":3296,\"cardId\":10609,\"name\":\"2016重庆国际少儿时装周闭幕式\",\"subName\":null,\"videoId\":\"v2658846656103424\",\"videoName\":null,\"sort\":9,\"url\":null,\"imageUrl\":\"back-1524909644171-5mVhvUtJvU\",\"intro\":null,\"videoResourceStatusVo\":null,\"scheduleTime\":null,\"type\":null}]},\"imageBannerUrl\":\"back-1526525654722-E12qgbs6fE\",\"titleStyleType\":0,\"imgTitleStyleUrl\":null,\"buttomStyleType\":1,\"imgButtomStyleUrl\":null,\"type\":null}],\"channelInfo\":{\"id\":100068,\"name\":\"2018重庆国际少儿时装周\",\"title\":\"2018重庆国际少儿时装周\",\"testUrl\":null,\"prodUrl\":null,\"shareTitle\":\"【有象视频独家直播】2018重庆国际少儿时装周\",\"shareDesc\":\"少儿时尚向西看\",\"shareImg\":\"back-1524904362682-dBlerwhBQe\",\"gmtCreated\":1524904364000,\"gmtModified\":1524904364000,\"headImgPc\":\"back-1526527195291-cMcToKq0BM\",\"headImgMweb\":\"back-1526527600713-Q8iK9hatE6\",\"backPc\":\"back-1526527216773-raLbAy5GhL\",\"backMweb\":\"back-1526527607462-DzcN7p6nuG\",\"backType\":0,\"enable\":1,\"type\":0,\"footType\":1,\"footImgMweb\":\"\",\"footImgPc\":\"\"}}}",
                "imageUrl");
        System.out.println(st1.get(0));
    }

}
