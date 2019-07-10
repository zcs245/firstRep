package cn.mjrj.myproject.dal.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHelper {
    private static ComboPooledDataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    public static void  close(Connection conn)throws SQLException{
        if (conn!=null){
            conn.close();
        }
    }
}
