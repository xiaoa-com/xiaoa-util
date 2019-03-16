package com.xiaoa.utils.db;

import org.junit.Test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestT
 * @Description TODO
 * @Author wanmeng
 * @Date 2019/3/12 9:29
 * @Version 1.0
 **/
public class TestT {
    @Test
    public void testT() {
        Connection conn = JdbcUtil.getConnection(JdbcUtil.MYSQL_DRIVER, "jdbc:mysql://192.168.137.100:3306/legou", "root", "123456");
        if (null == conn) {
            System.out.println("连接mysql失败");
        } else {
            System.out.println("连接Mysql成功");
        }
    }

    @Test
    public void testTT() {
        Connection conn = JdbcUtil.getConnection(JdbcUtil.MYSQL_DRIVER, "jdbc:mysql://192.168.137.100:3306/legou", "root", "123456");
        List<String> tableNameFromDataBase = JdbcUtil.getTableNameFromDataBase(conn);
        for (String s : tableNameFromDataBase) {
            System.out.println(s);
        }

    }

    @Test
    public void testTTT() {
        Connection conn = JdbcUtil.getConnection(JdbcUtil.MYSQL_DRIVER, "jdbc:mysql://192.168.137.100:3306/legou", "root", "123456");
        String sql = "insert into tb_user values(?,?,?,?,?)";
        Object[] obj = {1, "xiaoa", "123456", "17343202219", new Date()};
        JdbcUtil.execute(conn, sql, obj);
    }

}
