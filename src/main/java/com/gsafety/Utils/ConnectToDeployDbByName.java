package com.gsafety.Utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;


public class ConnectToDeployDbByName {
    public static final String GET_URL = "http://lpf.gsafety.com/api/system/?name=";
    public static final String GET_URL_ALL_NAME = "http://lpf.gsafety.com/api/system/?all";

    public static HashMap getDetailByname(String name) {
        HashMap<String, Object> fieldsMap = new HashMap<>();
        StringBuffer buffer = new StringBuffer();
        InputStream inputStream = null;
        try {
                     URL url = new URL(GET_URL + URLEncoder.encode((name), "utf-8"));
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setRequestProperty("Accept", "application/json");
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            //将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

            JSONObject object = JSON.parseObject(buffer.toString());
            List fields = object.getObject("fields", List.class);

            for (Object field : fields.toArray()) {
                JSONObject jo = (JSONObject) field;
                String key = jo.getString("key");
                Object val = jo.getJSONObject("value").get("value");
                if (val instanceof JSONArray) {
                    fieldsMap.put(key, ((JSONArray) val).toArray());
                } else if (val instanceof String) {
                    fieldsMap.put(key, val);
                }
            }
        } catch (ConnectException ce) {
            ce.printStackTrace();
            System.out.println("server connection timed out");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("http request error:{}");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return fieldsMap;
    }

    public static List<String> getDetailALLName() {
        List<String> objects = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        InputStream inputStream = null;
        try {
            URL url = new URL(GET_URL_ALL_NAME);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setRequestProperty("Accept", "application/json");
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            //将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

            JSONObject object = JSON.parseObject(buffer.toString());
            objects = object.getObject("name_list", List.class);

        } catch (ConnectException ce) {
            ce.printStackTrace();
            System.out.println("server connection timed out");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("http request error:{}");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return objects;
    }

    public static void main(String[] args) {
        Map map = ConnectToDeployDbByName.getDetailByname("国家安全生产应急平台");
        System.out.println(map.get("name"));
        System.out.println(Arrays.toString((Object[]) map.get("script")));
        for(Object o : ((Object[]) map.get("script"))) {
            System.out.println(o);
        }
        getDetailALLName();
        for (String d : getDetailALLName()) {
            System.out.println(d);
        }
    }

}

