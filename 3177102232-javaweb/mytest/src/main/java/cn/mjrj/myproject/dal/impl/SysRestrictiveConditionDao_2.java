package cn.mjrj.myproject.dal.impl;

import cn.mjrj.myproject.dal.ISysRestrictiveConditionDao_2;
import cn.mjrj.myproject.entity.SysRestrictiveCondition_2;
import cn.mjrj.myproject.entity.SysTeachers;
import cn.mjrj.myproject.entity.SysUser;
import cn.mjrj.myproject.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SysRestrictiveConditionDao_2 implements ISysRestrictiveConditionDao_2 {

    @Override
    public boolean insert(SysRestrictiveCondition_2 instance) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(SysRestrictiveCondition_2 instance, String id) {
        if (instance!= null&&id!=null) {
            String sql = "UPDATE sys_restrictive_condition_2 SET min_week_hour=?,max_week_hour=?," +
                    "max_course_number=? WHERE restrictive_tid=?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, instance.getMinWeekHour());
                pstmt.setInt(2, instance.getMaxWeekHour());
                pstmt.setInt(3, instance.getMaxCourseNumber());
                pstmt.setInt(4,Integer.parseInt(id));
                pstmt.execute();
                DbHelper.close(conn);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (instance==null&&id!=null){
            String sql = "UPDATE sys_restrictive_condition_2 SET min_week_hour=null,max_week_hour=null," +
                    "max_course_number=null WHERE restrictive_tid=?";
            try {
                Connection conn = DbHelper.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,Integer.parseInt(id));
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
    public SysRestrictiveCondition_2 findById(Integer id) {
        return null;
    }

    @Override
    public List<SysRestrictiveCondition_2> find(SysRestrictiveCondition_2 instance) {
        return null;
    }

    @Override
    public Pager findWithPage(Pager pager, SysRestrictiveCondition_2 instance) {
        List<Object> plan = new ArrayList<>();
        long total = 0;
        String sql = "SELECT COUNT(*) FROM sys_restrictive_condition_2";
        try {
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getLong(1);
            }
            pager.setRows(total);
            sql = "SELECT id_tid,name,title,teach_situation,min_week_hour,max_week_hour,max_course_number " +
                    "FROM sys_restrictive_condition_2 INNER JOIN sys_teachers ON id_tid=restrictive_tid LIMIT ?,?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pager.getBeginRow());
            pstmt.setInt(2, pager.getPageSize());
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

    private SysRestrictiveCondition_2 rsToBean(ResultSet rs) {
        SysRestrictiveCondition_2 p = new SysRestrictiveCondition_2();
        SysTeachers teachers = new SysTeachers();
        try {
            SysUser sysUser = new SysUser();
            sysUser.setId(rs.getInt("id_tid"));
            teachers.setId(sysUser);
            teachers.setName(rs.getString("name"));
            teachers.setTitle(rs.getString("title"));
            teachers.setTeachSituation(rs.getString("teach_situation"));
            p.setTid(teachers);
            p.setMinWeekHour(rs.getInt("min_week_hour"));
            p.setMaxWeekHour(rs.getInt("max_week_hour"));
            p.setMaxCourseNumber(rs.getInt("max_course_number"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
