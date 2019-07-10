package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysCourseDao;
import cn.mjrj.myproject.entity.SysCourse;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SysCourseDao implements ISysCourseDao {
    @Override
    public boolean insert(SysCourse instance) {
        if (instance!=null) {
            if(checkPkey(instance)==false){
                return false;
            }
            String sql = "INSERT INTO sys_course(course_code,course_name)VALUES(?,?)";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, instance.getCourseCode());
                pstmt.setString(2, instance.getCourseName());
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
    public boolean delete(String courseCode) {
        if (courseCode != null) {
            if (!checkFkey(courseCode)){
                return false;
            }
            String sql = "DELETE FROM sys_course WHERE course_code=?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(courseCode));
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
    public boolean update(SysCourse instance, String oldCourseCode) {
        return false;
    }

    @Override
    public SysCourse findById(Integer id) {
        return null;
    }

    @Override
    public List<SysCourse> find(SysCourse instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysCourse instance) {
        return null;
    }

    public boolean checkPkey(SysCourse instance){
        String sql ="SELECT * FROM sys_course WHERE course_code=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,instance.getCourseCode());
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
    public boolean checkFkey(String courseCode){
        String sql ="SELECT tp_code FROM sys_teacher_plan WHERE tp_code=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,courseCode);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
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
