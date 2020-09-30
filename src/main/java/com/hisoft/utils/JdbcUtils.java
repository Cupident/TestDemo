package com.hisoft.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public  static DataSource getDataSource(){
        return ds;
    }
    public static  void close(Connection conn, Statement stmt){
        try {
            if (stmt != null) {
                stmt.close();
                stmt=null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn!=null){
                conn.close();
                conn=null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
