package com.gsafety.mappers;

import java.text.MessageFormat;
import java.util.List;

public class DeployDynamicSQLProvider {
    //拼接sql实现系统列表分页，模糊查询，根据用户权限确定是否显示
    public String getDeployAccessControlByCriteriaWithObjects(String searchText, int offset, int limit, String accessControlArr) {

        String[] arr = accessControlArr.split(",");

        String sql = " SELECT id,browser,contact,deploymentInterfacePeople,deploymentServices,industry,manual,script,storageSpace,systemStatus,systemSynopsis,url,master_id,systemName,picture FROM deploy ";
        String and = "WHERE ";
        if (accessControlArr.length() > 0) {
            and += "  (";
            String sql1 = "";
            for (int i = 0; i < arr.length; i++) {
                sql1 = sql1 + "  id in (" + arr[i] + ") ";
                if (i < arr.length - 1) {
                    sql1 += "OR";
                }
            }
            sql = sql + and + sql1 + " )";
            and = "AND ";
        }
        if (searchText != null && searchText.length() > 0) {
            sql = sql + and + "(systemName LIKE '%" + searchText + "%' " +
                    "OR industry LIKE '%" + searchText + "%') ";
        }

        sql += "ORDER BY id ";
        sql += "LIMIT " + offset + ", " + limit + " ";
        System.out.println(sql);
        return sql;
    }
    //分页时使用获取特定查询结果集数量
    public String getDeployAccessControlPage(String searchText, String accessControlArr) {

        String[] arr = accessControlArr.split(",");

        String sql = " SELECT id,browser,contact,deploymentInterfacePeople,deploymentServices,industry,manual,script,storageSpace,systemStatus,systemSynopsis,url,master_id,systemName,picture FROM deploy ";
        String and = "WHERE ";
        if (accessControlArr.length() > 0) {
            and += "  (";
            String sql1 = "";
            for (int i = 0; i < arr.length; i++) {
                sql1 = sql1 + "  id in (" + arr[i] + ") ";
                if (i < arr.length - 1) {
                    sql1 += "OR";
                }
            }
            sql = sql + and + sql1 + " )";
            and = "AND ";
        }
        if (searchText != null && searchText.length() > 0) {
            sql = sql + and + "(systemName LIKE '%" + searchText + "%' " +
                    "OR industry LIKE '%" + searchText + "%') ";
        }
        sql += "ORDER BY id ";
        System.out.println(sql);
        return sql;
    }

    //拼接sql实现所有系统列表分页，模糊查询,供分配演示系统权限时使用
    public String getDeployAllByCriteriaWithObjects(String searchText, int offset, int limit) {

        String sql = " SELECT id,browser,contact,deploymentInterfacePeople,deploymentServices,industry,manual,script,storageSpace,systemStatus,systemSynopsis,url,master_id,systemName,picture FROM deploy ";
        String and = "WHERE ";

        if (searchText != null && searchText.length() > 0) {
            sql = sql + and + "(systemName LIKE '%" + searchText + "%' " +
                    "OR industry LIKE '%" + searchText + "%') ";
        }

        sql += "ORDER BY id ";
        sql += "LIMIT " + offset + ", " + limit + " ";
        System.out.println(sql);
        return sql;
    }
    //分页时使用获取特定查询结果集数量
    public String getDeployPage(String searchText) {
        String sql = " SELECT id,browser,contact,deploymentInterfacePeople,deploymentServices,industry,manual,script,storageSpace,systemStatus,systemSynopsis,url,master_id,systemName,picture FROM deploy ";
        String and = "WHERE ";
        if (searchText != null && searchText.length() > 0) {
            sql = sql + and + "(systemName LIKE '%" + searchText + "%' " +
                    "OR industry LIKE '%" + searchText + "%') ";
        }
        sql += "ORDER BY id ";
        System.out.println(sql);
        return sql;
    }





    //拼接sql，实现系统用户列表分页，模糊查询
    public String getUserByCriteriaWithObjects(String searchText, int offset, int limit) {

        String sql = " SELECT id,account,accountStatus,accountType,department,password,name,email,mobile,accessControl FROM user ";
        String and = "WHERE ";
        if (searchText != null && searchText.length() > 0) {
            sql += and + "(accountType LIKE '%" + searchText + "%' " +
                    "OR accountStatus LIKE '%" + searchText + "%' " +
                    "OR name LIKE '%" + searchText + "%' " +
                    "OR department LIKE '%" + searchText + "%') ";

            and = "AND ";
        }

        sql += "ORDER BY id ";
        sql += "LIMIT " + offset + ", " + limit + " ";
        System.out.println(sql);
        return sql;
    }

    //分页时使用获取特定查询结果集数量
    public String getUserPage(String searchText) {
        String sql = " SELECT id,account,accountStatus,accountType,department,password,name,email,mobile,accessControl FROM user ";
        String and = "WHERE ";
        if (searchText != null && searchText.length() > 0) {
            sql += and + "(accountType LIKE '%" + searchText + "%' " +
                    "OR accountStatus LIKE '%" + searchText + "%' " +
                    "OR name LIKE '%" + searchText + "%' " +
                    "OR department LIKE '%" + searchText + "%') ";

            and = "AND ";
        }

        sql += "ORDER BY id ";

        System.out.println(sql);
        return sql;
    }

//
//    public String insertAll(List list) {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("INSERT INTO cperson ");
//        sb.append("(cEmail,cMobile,cName,cDepartment) ");
//        sb.append("VALUES ");
//        MessageFormat mf = new MessageFormat("(#'{'list[{0}].cEmail'}', #'{'list[{0}].cMobile'}', #'{'list[{0}].cName'}', #'{'list[{0}].cDepartment'}')");
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(mf.format(new Object[i]));
//            if (i < list.size() - 1) {
//                sb.append(",");
//            }
//        }
//        return sb.toString();
//    }

}
