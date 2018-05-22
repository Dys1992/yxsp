//package util;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author: fanyu
// * @Date: 2018/5/17 11:03
// */
//public class AnalysisJsonUtils {
//
//    public static List<Object> analysisJson(String str,String assertKey){
//        List<Object> list = null;
//        Map<String,Object> map = JSON.parseObject(str);
//        for (Map.Entry<String,Object> entry:map.entrySet()){
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if( value instanceof JSONObject){
//                analysisJson(((JSONObject) value).toJSONString(),assertKey);
//            }
//            if (value instanceof JSONArray){
//                analysisJsonArray((JSONArray) value,assertKey);
//            }else {
//                if (assertKey .equals(key)){
//                    System.out.println(key +"1111111111111"+assertKey);
//                    list.add(value);
//                }
//            }
//        }
//        return list;
//    }
//
//    private static Object analysisJsonArray(JSONArray jsonArray,String assertKey){
//        Object value = null;
//        for(int i = 0 ; i < jsonArray.size(); i++){
//            Object json = jsonArray.get(i);
//            if(json instanceof JSONObject){
//                analysisJson(String.valueOf(json),assertKey);
//            }else if (json instanceof JSONArray){
//                analysisJsonArray((JSONArray) json,assertKey);
//            }else {
//                value = String.valueOf(json);
//            }
//        }
//        return value;
//    }
//
//
//
//}
