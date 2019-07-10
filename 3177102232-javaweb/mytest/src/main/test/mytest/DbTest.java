package mytest;

import cn.mjrj.myproject.dal.impl.DbHelper;
import org.junit.Test;

import java.sql.Connection;

public class DbTest {
    @Test
    public void testConnection(){
        try {
            Connection conn = DbHelper.getConnection();
            DbHelper.close(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
