package cn.gss.lk.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JdbcUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    
    public static DataSource getDataSource() {
        return dataSource;
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        Connection conn = tl.get();
        if(conn != null) {
            return conn;
        }
        return dataSource.getConnection();
    }

    //开启事务
    public static void beginTransaction() throws SQLException {
        Connection conn = tl.get();
        if(conn != null) {
            throw new SQLException("不能重复开启事务");
        }
        conn = getConnection();
        conn.setAutoCommit(false);
        tl.set(conn);
    }

    //提交事务
    public static void commitTransaction() throws SQLException {
        Connection conn = tl.get();
        if(conn == null) {
            throw new SQLException("没有开启事务，不能提交");
        }
        conn.commit();
        conn.close();
        tl.remove();
    }

    //回滚事务
    public static void rollbackTransaction() throws SQLException {
        Connection conn = tl.get();
        if(conn == null) {
            throw new SQLException("没有开启事务，不能回滚");
        }
        conn.rollback();
        conn.close();
        tl.remove();
    }
}
