package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysLessonPlanDao;
import cn.mjrj.myproject.entity.SysLessonPlan;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SysLessonPlanDao implements ISysLessonPlanDao {
    @Override
    public boolean insert(SysLessonPlan instance) {
        if (instance != null&&checkFkey(instance)) {
            String sql = "INSERT INTO sys_lesson_plan(course_tid,course_tname,time)VALUES(?,?,?)";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, instance.getTid().getId().getId());
                pstmt.setString(2, instance.getCourseName());
                pstmt.setString(3, instance.getTime());
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
    public boolean delete(String str) {
        if (str != null) {
            String[] strs = str.split("-");
            String sql = "DELETE FROM sys_lesson_plan WHERE course_tid=? AND course_tname=? AND time =?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(strs[0]));
                pstmt.setString(2,strs[1]);
                pstmt.setString(3,strs[2]);
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
    public boolean update(SysLessonPlan instance, String oldCourseName) {
        if (instance != null && oldCourseName != null && check(instance,oldCourseName)) {
            String sql = "UPDATE sys_lesson_plan SET course_tname=?,time=? WHERE course_tid=? AND course_tname=?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, instance.getCourseName());
                pstmt.setString(2, instance.getTime());
                pstmt.setInt(3,instance.getTid().getId().getId());
                pstmt.setString(4,oldCourseName);
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
    public SysLessonPlan findById(Integer id) {
        return null;
    }

    @Override
    public List<SysLessonPlan> find(SysLessonPlan instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysLessonPlan instance) {
        List<Object> plan = new ArrayList<>();
        long total = 0;
        String sql = "SELECT COUNT(*) FROM sys_lesson_plan WHERE course_tid=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,instance.getTid().getId().getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getLong(1);
            }
            pager.setRows(total);
            sql = "SELECT * FROM sys_lesson_plan WHERE course_tid=? LIMIT ?,?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,instance.getTid().getId().getId());
            pstmt.setInt(2,pager.getBeginRow());
            pstmt.setInt(3,pager.getPageSize());
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

    private SysLessonPlan rsToBean(ResultSet rs){
       SysLessonPlan lp = new SysLessonPlan();
        try {
            lp.setCourseName(rs.getString("course_tname"));
            lp.setTime(rs.getString("time"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return lp;
    }

    private boolean checkFkey(SysLessonPlan instance){
        String sql = "SELECT * FROM sys_lesson_plan WHERE course_tid=? AND time=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, instance.getTid().getId().getId());
            pstmt.setString(2, instance.getTime());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                DbHelper.close(conn);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    private boolean check(SysLessonPlan instance,String old){
        String sql = "SELECT * FROM sys_lesson_plan WHERE course_tid=? AND course_tname=? AND time=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, instance.getTid().getId().getId());
            pstmt.setString(2, old);
            pstmt.setString(3,instance.getTime());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                DbHelper.close(conn);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
