package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysTeacherPlanDao;
import cn.mjrj.myproject.entity.SysClasses;
import cn.mjrj.myproject.entity.SysCourse;
import cn.mjrj.myproject.entity.SysTeacherPlan;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SysTeacherPlanDao implements ISysTeacherPlanDao {
    @Override
    public boolean insert(SysTeacherPlan instance) {
        if(instance!=null&&checkFkey(instance)){
            String sql = "INSERT INTO sys_teacher_plan(tp_cnum,tp_code,course_hour)VALUES(?,?,?)";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,instance.getCnum().getClassNumber());
                pstmt.setInt(2, instance.getCode().getCourseCode());
                pstmt.setInt(3, instance.getCourseHour());
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
    public boolean delete(String mark) {

        if (mark != null) {
            String[] marks = mark.split("-");
            String sql = "DELETE FROM sys_teacher_plan WHERE tp_cnum=? and tp_code=? ";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,marks[0]);
                pstmt.setString(2,marks[1]);
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
    public boolean update(SysTeacherPlan instance, String oldClassNumber) {
        return false;
    }

    @Override
    public SysTeacherPlan findById(Integer id) {
        return null;
    }

    @Override
    public List<SysTeacherPlan> find(SysTeacherPlan instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysTeacherPlan instance) {
        List<Object> plan = new ArrayList<>();
        long total = 0;
        String sql = "SELECT COUNT(*) FROM sys_teacher_plan";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                total = rs.getLong(1);
            }
            pager.setRows(total);
            sql = "SELECT class_type,class_number,course_code,course_name,course_hour  FROM  sys_teacher_plan" +
                    " INNER JOIN sys_classes ON class_number=tp_cnum " +
                    "INNER JOIN sys_course ON course_code = tp_code LIMIT ?,?";
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

    private SysTeacherPlan rsToBean(ResultSet rs){
        SysTeacherPlan p = new SysTeacherPlan();
        SysClasses cl = new SysClasses();
        SysCourse co = new SysCourse();
        try {
            cl.setClassType(rs.getString("class_type"));
            cl.setClassNumber(rs.getString("class_number"));
            co.setCourseCode(rs.getInt("course_code"));
            co.setCourseName(rs.getString("course_name"));
            p.setCnum(cl);
            p.setCode(co);
            p.setCourseHour(rs.getInt("course_hour"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }
    private boolean checkFkey(SysTeacherPlan instance){
        String sql = "SELECT * FROM sys_teacher_plan WHERE tp_cnum=? AND tp_code=?";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,instance.getCnum().getClassNumber());
            pstmt.setInt(2, instance.getCode().getCourseCode());
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