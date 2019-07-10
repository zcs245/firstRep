package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysClassesDao;
import cn.mjrj.myproject.entity.SysClasses;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SysClassesDao implements ISysClassesDao {
    @Override
    public boolean insert(SysClasses instance) {
        if (instance!=null) {
            if(!checkPkey(instance)){
                return false;
            }
            String sql = "INSERT INTO sys_classes(class_number,class_type)VALUES(?,?)";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, instance.getClassNumber());
                pstmt.setString(2, instance.getClassType());
                pstmt.execute();
                DbHelper.close(conn);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(String classNumber) {
        if (classNumber != null) {
            if (checkFkey(classNumber)==false){
                return false;
            }
            String sql = "DELETE FROM sys_classes WHERE class_number=?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,classNumber);
                pstmt.execute();
                DbHelper.close(conn);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(SysClasses instance, String oldClassNumber) {
        return false;
    }

    @Override
    public SysClasses findById(Integer id) {
        return null;
    }

    @Override
    public List<SysClasses> find(SysClasses instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysClasses instance) {
        return null;
    }

    public boolean checkPkey(SysClasses instance){
        String sql ="SELECT * FROM sys_classes WHERE class_number=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,instance.getClassNumber());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                DbHelper.close(conn);
                return false;
            }
            DbHelper.close(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
    public boolean checkFkey(String classNumber){
        String sql ="SELECT student_cnum FROM sys_students WHERE student_cnum=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,classNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                DbHelper.close(conn);
                return false;
            }
            DbHelper.close(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
