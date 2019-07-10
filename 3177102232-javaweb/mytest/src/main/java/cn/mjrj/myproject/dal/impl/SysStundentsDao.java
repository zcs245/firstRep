package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysStudentsDao;
import cn.mjrj.myproject.entity.SysClasses;
import cn.mjrj.myproject.entity.SysStudents;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SysStundentsDao implements ISysStudentsDao {
    @Override
    public boolean insert(SysStudents instance) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(SysStudents instance, String id) {
        return false;
    }

    @Override
    public SysStudents findById(Integer id) {
        SysClasses sysClasses = new SysClasses();
        String sql = "SELECT * FROM sys_students WHERE id_sid= ?";
        SysStudents sysStudents = new SysStudents();
        try{
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            String name =null;
            String ClassNumber = null;
            if (rs.next()){
                name = rs.getString(3);
                ClassNumber = rs.getString(2);
                rs.close();
            }
            sysStudents.setName(name);
            sysClasses.setClassNumber(ClassNumber);
            sysStudents.setCnum(sysClasses);
            DbHelper.close(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sysStudents;
    }

    @Override
    public List<SysStudents> find(SysStudents instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysStudents instance) {
        return null;
    }
}
