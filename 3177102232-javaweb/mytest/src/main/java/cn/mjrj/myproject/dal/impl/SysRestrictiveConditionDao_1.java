package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysRestrictiveConditionDao_1;
import cn.mjrj.myproject.entity.SysCourse;
import cn.mjrj.myproject.entity.SysRestrictiveCondition_1;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SysRestrictiveConditionDao_1 implements ISysRestrictiveConditionDao_1 {
    @Override
    public boolean insert(SysRestrictiveCondition_1 instance) {
        if (instance != null) {
            if (checkPkey(instance) == false) {
                return false;
            }
            String sql = "INSERT INTO sys_restrictive_condition_1(restrictive_code)VALUES(?)";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, instance.getRestrictiveCode().getCourseCode());
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
    public boolean delete(String restrictiveCode) {
        if (restrictiveCode != null) {
            if (checkFkey(restrictiveCode) == false) {
                return false;
            }
            String sql = "DELETE FROM sys_restrictive_condition_1 WHERE restrictive_code=?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, restrictiveCode);
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
    public boolean update(SysRestrictiveCondition_1 instance, String old) {
        if (instance!= null) {
                String sql = "UPDATE sys_restrictive_condition_1 SET course_type=?,r_title=? WHERE restrictive_code=?";
                try {
                    Connection conn = DbHelper.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, instance.getCourseType());
                    pstmt.setString(2, instance.getTitle());
                    pstmt.setInt(3, instance.getRestrictiveCode().getCourseCode());
                    pstmt.execute();
                    DbHelper.close(conn);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        } else {
            String sql = "UPDATE sys_restrictive_condition_1 SET course_type=null ,r_title=null WHERE restrictive_code=?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,Integer.parseInt(old));
                pstmt.execute();
                DbHelper.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public SysRestrictiveCondition_1 findById(Integer id) {
        return null;
    }

    @Override
    public List<SysRestrictiveCondition_1> find(SysRestrictiveCondition_1 instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysRestrictiveCondition_1 instance) {
        List<Object> plan = new ArrayList<>();
        long total = 0;
        String sql = "SELECT COUNT(*) FROM sys_restrictive_condition_1";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                total = rs.getLong(1);
            }
            pager.setRows(total);
            sql = "SELECT course_code,course_name,course_type,r_title FROM sys_restrictive_condition_1 INNER " +
                    "JOIN sys_course ON course_code=restrictive_code LIMIT ?,?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,pager.getBeginRow());
            pstmt.setInt(2,pager.getPageSize());
            rs = pstmt.executeQuery();
            try {
                while (rs.next()) {
                    plan.add(rsToBean(rs));
                }
                pager.setDates(plan);
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DbHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pager;
    }

    private SysRestrictiveCondition_1 rsToBean(ResultSet rs){
        SysRestrictiveCondition_1 p = new SysRestrictiveCondition_1();
        SysCourse co = new SysCourse();
        try {
            co.setCourseCode(rs.getInt("course_code"));
            co.setCourseName(rs.getString("course_name"));
            p.setRestrictiveCode(co);
            p.setCourseType(rs.getString("course_type"));
            p.setTitle(rs.getString("r_title"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public boolean checkPkey(SysRestrictiveCondition_1 instance){
        String sql ="SELECT * FROM sys_restrictive_condition_1 WHERE restrictive_code=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,instance.getRestrictiveCode().getCourseCode());
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