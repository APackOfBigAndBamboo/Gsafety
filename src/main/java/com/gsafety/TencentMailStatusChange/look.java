package com.gsafety.TencentMailStatusChange;

import java.util.List;

import static com.gsafety.TencentMailStatusChange.Add.httpsRequestSyncUser;

public class look {
    public static void main(String[] args) {
        List<String> list = JDBCGetNeedToDisableEmail.getAllLiZhiEmailFromU8CRm();
        System.out.println(list);
        for (String s : list) {
            String jsobj = "{ \"userid\" : \"" + s + "\",  " + "\"enable\":" + "0 }";
            String a = null;
            try {
                a = httpsRequestSyncUser(jsobj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (a){
                case "ok":
                    System.out.println("ok:"+a);
                    break;
                case "userid not found":
                    System.out.println("not found:"+a);
                    break;
                default:
                        System.out.println("default");
                        break;
            }
           // System.out.println("第一次打印："+a);
//            if ("ok".equals(a)) {
//                System.out.println("OK时打印："+a);
//            }else if ("userid not found".equals(a)){
//                System.out.println("userid not found时打印："+a);
//            }else {
//                System.out.println("else打印："+a);
//            }
//            System.out.println("第一次打印："+a);
//            if (a.equals("ok")) {
//                System.out.println("OK时打印："+a);
//            }else if (a.equals("userid not found")){
//                System.out.println("userid not found时打印："+a);
//            }else {
//                System.out.println("else打印："+a);
//            }
//            if (a.equals("ok")) {
//                JDBCGetNeedToDisableEmail.UpdateMALLstateinU8CRm(s);
//            }else if (a.equals("userid not found")){
//                JDBCGetNeedToDisableEmail.UpdateMALLstateinU8CRm(s);
//            }else {
//                System.out.println(s);
//            }

        }
    }
}
