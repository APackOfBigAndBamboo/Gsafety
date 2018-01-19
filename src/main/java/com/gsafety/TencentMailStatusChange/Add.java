package com.gsafety.TencentMailStatusChange;

import com.alibaba.fastjson.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

public class Add  {
    public static String GET_TOKEN_URL = "https://api.exmail.qq.com/cgi-bin/gettoken?corpid=wm35599320faaaf2ff&corpsecret=pUpD_MILpx08UXeRjMSrBWhXeSwyuJl8mWttOButQmU2ZMGIpSq_pnMUSCzIyMlQ";
    public static String requestMethod = "GET";


    public static String SYNC_USER_URL = " https://api.exmail.qq.com/cgi-bin/user/update";
    public static String requestPOST_Method = "POST";

    public static String GET_USER_URL = "https://api.exmail.qq.com/cgi-bin/user/get";


//    public static void main(String[] args) {
//        System.out.println(httpsRequest());
//        //Https GET获取access-token
////        String s = httpsRequest( );
////        JSONObject jsonObject = JSONObject.parseObject(s);
////        System.out.println(jsonObject.get("access_token"));
////        String accesstoken = jsonObject.getString("access_token");
//        //获取需要变更员工邮箱
//        String userid = "zhurong@gsafety.com";
//
//        //拼接需要post的数据
//        String jsobj = "{ \"userid\" : \"" + userid + "\",  " + "\"enable\":" + "0 }";
//        System.out.println(jsobj);
//
//        //Https POST提交数据
//        String a = httpsRequestSyncUser(jsobj);
//        System.out.println(a);
//
//        //HTTPS GET通过userid（邮箱）获取 员工信息
//        String users = httpsRequestGetUser(GET_USER_URL, userid, requestMethod, null);
//        System.out.println(users);
//    }

    public static String httpsRequestSyncUser( String outputStr) throws Exception {
        String requestUrl=" https://api.exmail.qq.com/cgi-bin/user/update";
        String requestMethod = "POST";
        StringBuffer buffer = null;

            //创建SSLContext
            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManager[] tm = {new MyX509trustManager()};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());
            ;
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl + "?access_token=" + httpsRequest());
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if (null != outputStr) {
                OutputStream os = conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }
            //读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }

        JSONObject json1 = JSONObject.parseObject(buffer.toString());
        System.out.println(json1);
        String msg = json1 .getString("errmsg");
        if("ok".equals(msg)||"userid not found".equals(msg)){
            return msg;
        }else {
            return "token";
        }

    }


    /*
     * 处理https GET/POST请求
     * 请求地址、请求方法、参数
     * */
    public static String httpsRequest() throws Exception {
        String requestUrl ="https://api.exmail.qq.com/cgi-bin/gettoken?corpid=wm35599320faaaf2ff&corpsecret=pUpD_MILpx08UXeRjMSrBWhXeSwyuJl8mWttOButQmU2ZMGIpSq_pnMUSCzIyMlQ";
        String requestMethod ="GET";
        String outputStr=null;
        StringBuffer buffer = null;

            //创建SSLContext
            SSLContext sslContext = SSLContext.getInstance("SSL");
            TrustManager[] tm = {new MyX509trustManager()};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());

            //获取SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if (null != outputStr) {
                OutputStream os = conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }


        JSONObject jsonObject = JSONObject.parseObject(buffer.toString());
        String accesstoken = jsonObject.getString("access_token");
        System.out.println(accesstoken);
        return accesstoken;
    }

//    public static String httpsRequestGetUser(String requestUrl,  String userid, String requestMethod, String outputStr) {
//        StringBuffer buffer = null;
//        try {
//            //创建SSLContext
//            SSLContext sslContext = SSLContext.getInstance("SSL");
//            TrustManager[] tm = {new MyX509trustManager()};
//            //初始化
//            sslContext.init(null, tm, new java.security.SecureRandom());
//            ;
//            //获取SSLSocketFactory对象
//            SSLSocketFactory ssf = sslContext.getSocketFactory();
//            URL url = new URL(requestUrl + "?access_token=" + httpsRequest() + "&userid=" + userid);
//            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            conn.setUseCaches(false);
//            conn.setRequestMethod(requestMethod);
//            //设置当前实例使用的SSLSoctetFactory
//            conn.setSSLSocketFactory(ssf);
//            conn.connect();
//            //往服务器端写内容
//            if (null != outputStr) {
//                OutputStream os = conn.getOutputStream();
//                os.write(outputStr.getBytes("utf-8"));
//                os.close();
//            }
//
//            //读取服务器端返回的内容
//            InputStream is = conn.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is, "utf-8");
//            BufferedReader br = new BufferedReader(isr);
//            buffer = new StringBuffer();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                buffer.append(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return buffer.toString();
//    }
    //        public static String httpsRequestGetUser(String requestUrl, String requestMethod, String outputStr) {
//            StringBuffer buffer=null;
//            try{
//                URL url=new URL(requestUrl);
//                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//                conn.setRequestMethod(requestMethod);
//                conn.connect();
//                //往服务器端写内容 也就是发起http请求需要带的参数
//                if(null!=outputStr){
//                    OutputStream os=conn.getOutputStream();
//                    os.write(outputStr.getBytes("utf-8"));
//                    os.close();
//                }
//                //读取服务器端返回的内容
//                InputStream is=conn.getInputStream();
//                InputStreamReader isr=new InputStreamReader(is,"utf-8");
//                BufferedReader br=new BufferedReader(isr);
//                buffer=new StringBuffer();
//                String line=null;
//                while((line=br.readLine())!=null){
//                    buffer.append(line);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            return buffer.toString();
//        }
}
