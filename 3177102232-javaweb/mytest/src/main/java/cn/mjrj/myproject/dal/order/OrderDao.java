package cn.mjrj.myproject.dal.order;

import cn.mjrj.myproject.dal.impl.DbHelper;
import cn.mjrj.myproject.entity.order.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public List findMainClass() {
        List<Order> st = new ArrayList<>();
        try {
            String sql = "SELECT class_number,course_type,course_name,name,teach_situation,title,sys_lesson_plan.`time`,course_hour\n" +
                    " FROM  sys_teacher_plan\n" +
                    "INNER JOIN sys_classes ON class_number=tp_cnum \n" +
                    "INNER JOIN sys_course ON course_code = tp_code\n" +
                    "INNER JOIN sys_restrictive_condition_1 ON restrictive_code = course_code\n" +
                    "INNER JOIN sys_lesson_plan ON course_tname = course_name\n" +
                    "INNER JOIN sys_teachers ON id_tid = course_tid\n" +
                    "WHERE course_type = '主课'  ";
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            try {
                while (rs.next()) {
                    if (!rs.getString("title").equals("助教")) {
                        if (!rs.getString("teach_situation").equals("严重事故")){
                            if (checkList(st,rs.getString("class_number"),rs.getString("course_type")
                            ,rs.getString("course_name"),rs.getString("name"),rs.getString("time"))) {
                                st.add(rsToBean(rs));
                            }
                        }
                    }
                }
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DbHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public List findFMainClass() {
        List<Order> st = new ArrayList<>();
        try {
            String sql = "SELECT class_number,course_type,course_name,name,title,teach_situation,sys_lesson_plan.`time`,course_hour\n" +
                    " FROM  sys_teacher_plan\n" +
                    "INNER JOIN sys_classes ON class_number=tp_cnum \n" +
                    "INNER JOIN sys_course ON course_code = tp_code\n" +
                    "INNER JOIN sys_restrictive_condition_1 ON restrictive_code = course_code\n" +
                    "INNER JOIN sys_lesson_plan ON course_tname = course_name\n" +
                    "INNER JOIN sys_teachers ON id_tid = course_tid\n" +
                    "WHERE course_type = '非主课'";
            Connection conn = DbHelper.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            try {
                while (rs.next()) {
                        if (!rs.getString("teach_situation").equals("严重事故")){
                            if (checkList(st,rs.getString("class_number"),rs.getString("course_type")
                                    ,rs.getString("course_name"),rs.getString("name"),rs.getString("time"))) {
                                st.add(rsToBean(rs));
                            }
                        }
                    }
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DbHelper.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    private Order rsToBean(ResultSet rs){
        Order order = new Order();
        try {
            order.setClassNumber(rs.getString("class_number"));
            order.setCourseType(rs.getString("course_type"));
            order.setCourseName(rs.getString("course_name"));
            order.setTeacherName(rs.getString("name"));
            order.setTime(rs.getString("time"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }
    private boolean checkList(List<Order> st,String classNumber,String courseType,String courseName,
                              String name,String time) {
        for (int i = 0; i < st.size(); i++) {
            if (st.get(i).getClassNumber().equals(classNumber)) {
                if (st.get(i).getCourseType().equals(courseType)) {
                    if (st.get(i).getCourseName().equals(courseName)) {
                        if (st.get(i).getTeacherName().equals(name)) {
                            if (st.get(i).getTime().equals(time)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
