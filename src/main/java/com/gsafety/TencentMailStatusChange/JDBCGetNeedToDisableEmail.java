package com.gsafety.TencentMailStatusChange;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCGetNeedToDisableEmail {

    public static void main(String[] args) {
        System.out.println(getAllLiZhiEmailFromU8CRm());
    }

    private static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String SQLSERVER_URL = "";

    // 注册数据库驱动
    static {
        try {
            Class.forName(SQLSERVER_DRIVER).newInstance();
        } catch (Exception e) {
            System.out.println("注册失败！");
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConn() throws SQLException {
        String url = SQLSERVER_URL;
        return DriverManager.getConnection(url, "", "");
    }

    // 关闭连接
    public static void closeConn(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭连接失败！");
                e.printStackTrace();
            }
        }
    }

    //反写中间库邮箱状态
    public static void UpdateMALLstateinU8CRm(String mail) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs=0;

        try {
            conn = JDBCGetNeedToDisableEmail.getConn();
            String sql = "update U8CRM.dbo.person set MAILstate='0' where tans_type='D' and cPsnEmail=\'" + mail + "\'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeUpdate();
            if (rs != 1) {
                System.out.println("wrong!");//在测试系统加到日志对象里
            }

        } catch (SQLException e) {
            e.printStackTrace();//日志中加mail 及错误原因
        }
    }

    //获取U8CRM所有人员信息
    public static List<String> getAllLiZhiEmailFromU8CRm() {
        List<String> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCGetNeedToDisableEmail.getConn();
            String sql = "select cPsnEmail from U8CRM.dbo.person inner join (SELECT max(ID) as maxid  FROM U8CRM.dbo.person where ( MAILstate is null or MAILstate <> '0' ) and cPsnEmail <>'' and (tans_type='D') group by hr_code) M on ID = M.maxid";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int size = md.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= size; i++) {
                    lists.add(rs.getString("cPsnEmail"));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return lists;
    }
}
