package com.xiaoa.util.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JdbcUtil
 * @Description Jdbc
 * @Author wanmeng
 * @Date 2019/3/13 20:58
 * @Version 1.0
 **/
public class JdbcUtil {
    /**
     * oracle数据库驱动
     */
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    /**
     * mysql数据库驱动
     */
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    /**
     * sqlserver数据库驱动
     */
    public static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static List<String> getTableNameFromDataBase(Connection connection) {
        List<String> tableNames = new ArrayList<String>();
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (resultSet.next()) {
                tableNames.add(resultSet.getString(3));
            }
            JdbcUtil.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableNames;
    }

    /**
     * 获取Connection
     *
     * @param driver
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static Connection getConnection(String driver, String url, String username, String password) {
        if (driver == null || url == null || username == null || password == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭Connection
     *
     * @param conn
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
