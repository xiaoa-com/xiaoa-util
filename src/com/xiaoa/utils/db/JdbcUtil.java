package com.xiaoa.utils.db;

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

    /**
     * 执行一条sql语句(insert, update, delete)
     *
     * @param conn
     * @param sql  insert into tableName values(?,?)
     * @param obj  [1,2]
     */
    public static void execute(Connection conn, String sql, Object[] obj) {
        PreparedStatement pst = null;
        try {
            if (conn == null || conn.isClosed()) {
                throw new IllegalArgumentException("Connection has bean closed!");
            }
            if (sql == null) {
                throw new IllegalArgumentException("The sql must not be null");
            }

            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            if (obj != null && obj.length > 0) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);
                }
            }
            pst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取数据库中所有的表
     *
     * @param connection
     * @return
     */
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
