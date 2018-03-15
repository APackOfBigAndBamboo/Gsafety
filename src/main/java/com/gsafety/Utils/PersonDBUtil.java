package com.gsafety.Utils;

import com.gsafety.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDBUtil {

    private static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String SQLSERVER_URL = "jdbc:sqlserver://:1433;databaseName=U8CRM";

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

    //获取U8CRM所有人员信息
    public static List<Person> getAllpersonFromU8CRm() {
        List<Person> lists = new ArrayList<Person>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = PersonDBUtil.getConn();
//            String sql="select * from U8CRM.dbo.person inner join (SELECT max(ID) as maxid  FROM U8CRM.dbo.person where  cPsnEmail <>'' and (tans_type='A' or tans_type ='M') group by hr_code) M on ID = M.maxid";
            String sql = "select cdepName,cPsnEmail,cPersonName,cPsnMobilePhone from person where cPsnEmail != '' and tans_type != 'D'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int size = md.getColumnCount();
            while (rs.next()) {
                Person person = new Person();
                for (int i = 1; i <= size; i++) {
                    person.setcDepartment(rs.getString("cdepName"));
                    person.setcEmail(rs.getString("cPsnEmail"));
                    person.setcName(rs.getString("cPersonName"));
                    person.setCmobile(rs.getString("cPsnMobilePhone"));
                }
                lists.add(person);
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

    //获取U8CRM人员信息
    public static int getPersonFromU8CRmByEmail(String cPsnEmail) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;
        try {
            conn = PersonDBUtil.getConn();
            String sql = "select cPsnEmail from person where ID in (select max(ID) from person  where cPsnEmail = " + "'" + cPsnEmail + "')";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                i++;
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
        return i;
    }
    public static void main(String[] args) {
        System.out.println(getPersonFromU8CRmByEmail("kuangcuifeng@gsafety.com"));
    }

}
