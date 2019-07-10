package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysTeachersDao;
import cn.mjrj.myproject.entity.SysTeachers;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SysTeachersDao implements ISysTeachersDao {
    @Override
    public boolean insert(SysTeachers instance) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(SysTeachers instance, String id) {
        return false;
    }

    @Override
    public SysTeachers findById(Integer id) {
        String sql = "SELECT * FROM sys_teachers WHERE id_tid = ?";
        SysTeachers sysTeachers = new SysTeachers();
        try{
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            String name =null;
            if (rs.next()){
                name = rs.getString(2);
                rs.close();
            }
            sysTeachers.setName(name);
            DbHelper.close(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sysTeachers;
    }

    @Override
    public List<SysTeachers> find(SysTeachers instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysTeachers instance) {
        return null;
    }
}
