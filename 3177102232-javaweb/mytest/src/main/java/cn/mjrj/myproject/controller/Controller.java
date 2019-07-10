package cn.mjrj.myproject.controller;

import cn.mjrj.myproject.entity.*;
import cn.mjrj.myproject.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("Mytest")
public class Controller extends HttpServlet {
    Service service = new Service();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("universityadd".equals(action) || "universityupdate".equals(action)) {
            String typeNumber = request.getParameter("typeNumber");
            String codeName = request.getParameter("codeName");
            String courseHour = request.getParameter("courseHour");
            String[] classes = typeNumber.split("-");
            String[] course = codeName.split("-");
            SysClasses sysClasses = new SysClasses();
            sysClasses.setClassNumber(classes[1]);
            sysClasses.setClassType(classes[0]);
            service.classesAdd(sysClasses);
            SysCourse sysCourse = new SysCourse();
            sysCourse.setCourseCode(Integer.parseInt(course[0]));
            sysCourse.setCourseName(course[1]);
            service.courseAdd(sysCourse);
            SysTeacherPlan tp = new SysTeacherPlan();
            tp.setCnum(sysClasses);
            tp.setCode(sysCourse);
            tp.setCourseHour(Integer.parseInt(courseHour));
            service.teacherPlanAdd(tp);
            SysRestrictiveCondition_1 sysRestrictiveCondition_1 = new SysRestrictiveCondition_1();
            sysRestrictiveCondition_1.setRestrictiveCode(sysCourse);
            service.restrictive_1Add(sysRestrictiveCondition_1);
            response.sendRedirect("UList");
        }

        if ("teacheradd".equals(action) || "teacherupdate".equals(action)) {
            String courseName = request.getParameter("courseName");
            String time = request.getParameter("courseHour");
            String id = request.getParameter("id");
            String oldCourseName = request.getParameter("oldCourseName");
            SysLessonPlan sysLessonPlan = new SysLessonPlan();
            SysTeachers t = new SysTeachers();
            SysUser u = new SysUser();
            u.setId(Integer.parseInt(id));
            t.setId(u);
            sysLessonPlan.setTid(t);
            sysLessonPlan.setCourseName(courseName);
            sysLessonPlan.setTime(time);
            String userType = java.net.URLEncoder.encode("老师", "UTF-8");
            if ("teacheradd".equals(action)) {
                service.lessonPlanAdd(sysLessonPlan);
                response.sendRedirect("TList?id=" + id + "&userType=" + userType);
            } else {
                service.lessonPlanUpdate(sysLessonPlan, oldCourseName);
                response.sendRedirect("TList?id=" + id + "&userType=" + userType);
            }
        }

        if ("collegecupdate".equals(action)) {
            String id = request.getParameter("id");
            String courseType = request.getParameter("courseType");
            String title = request.getParameter("title");
            SysCourse sysCourse = new SysCourse();
            sysCourse.setCourseCode(Integer.parseInt(id));
            SysRestrictiveCondition_1 src = new SysRestrictiveCondition_1();
            src.setRestrictiveCode(sysCourse);
            src.setCourseType(courseType);
            src.setTitle(title);
            service.restrictive_1Update(src, null);
            response.sendRedirect("CList");
        } else if ("collegetupdate".equals(action)) {
            String id = request.getParameter("id");
            String minWeekHour = request.getParameter("minWeekHour");
            String maxWeekHour = request.getParameter("maxWeekHour");
            String maxCourseNumber = request.getParameter("maxCourseNumber");
            SysRestrictiveCondition_2 src = new SysRestrictiveCondition_2();
            src.setMinWeekHour(Integer.parseInt(minWeekHour));
            src.setMaxWeekHour(Integer.parseInt(maxWeekHour));
            src.setMaxCourseNumber(Integer.parseInt(maxCourseNumber));
            service.restrictive_2Update(src, id);
            response.sendRedirect("CList1");
        } else {}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("universityadd".equals(action)) {

            request.setAttribute("action", "universityadd");
            request.getRequestDispatcher("./WEB-INF/views/_universityadd.jsp").forward(request, response);


        } else if ("universitydelete".equals(action)) {

            String str_1 = request.getParameter("classNumber");
            String str_2 = request.getParameter("courseCode");
            String str = str_1 + "-" + str_2;
            service.teacherPlanDelete(str);
            service.restrictive_1Delete(str_2);
            service.courseDelete(str_2);
            service.classDelete(str_1);
            response.sendRedirect("UList");


        } else if ("universityupdate".equals(action)) {

            String str_1 = request.getParameter("classNumber");
            String str_2 = request.getParameter("courseCode");
            String str = str_1 + "-" + str_2;
            service.teacherPlanDelete(str);
            service.restrictive_1Delete(str_2);
            service.courseDelete(str_2);
            service.classDelete(str_1);
            request.setAttribute("action", "universityupdate");
            request.getRequestDispatcher("./WEB-INF/views/_universityadd.jsp").forward(request, response);

        } else if ("teacheradd".equals(action)) {
            request.setAttribute("action", "teacheradd");
            String id = request.getParameter("id");
            request.setAttribute("id",id);
            request.getRequestDispatcher("./WEB-INF/views/_teachersadd.jsp").forward(request, response);

        } else if ("teacherdelete".equals(action)) {
            String id = request.getParameter("id");
            String userType = request.getParameter("userType");
            String courseName = request.getParameter("courseName");
            String time = request.getParameter("time");
            String str = id+"-"+courseName+"-"+time;
            service.lessonPlanDelete(str);
            userType= java.net.URLEncoder.encode(userType,"UTF-8");
            response.sendRedirect("TList?id="+id+"&userType="+userType);

        } else if ("teacherupdate".equals(action)) {

            request.setAttribute("action", "teacherupdate");
            String id =request.getParameter("id");
            request.setAttribute("id",id);
            String oldCourseName = request.getParameter("courseName");
            request.setAttribute("oldCourseName",oldCourseName);
            request.getRequestDispatcher("./WEB-INF/views/_teachersadd.jsp").forward(request, response);

        } else if ("collegecupdate".equals(action)) {

            String id = request.getParameter("id");
            String courseName = request.getParameter("courseName");
            request.setAttribute("action","collegecupdate");
            request.setAttribute("id",id);
            request.setAttribute("courseName",courseName);
            request.getRequestDispatcher("./WEB-INF/views/_collegecadd.jsp").forward(request,response);

        } else if ("collegecdelete".equals(action)) {

            String id = request.getParameter("id");
            service.restrictive_1Update(null,id);
            response.sendRedirect("CList");

        } else if ("collegetupdate".equals(action)){
            request.setAttribute("action","collegetupdate");
            String id =request.getParameter("id");
            String name = request.getParameter("name");
            String title = request.getParameter("title");
            String teachSituation = request.getParameter("teachSituation");
            request.setAttribute("id",id);
            request.setAttribute("name",name);
            request.setAttribute("title",title);
            request.setAttribute("teachSituation",teachSituation);
            request.getRequestDispatcher("./WEB-INF/views/_collegetadd.jsp").forward(request,response);
        }else if ("collegetdelete".equals(action)){
            String id =request.getParameter("id");
            service.restrictive_2Update(null,id);
            response.sendRedirect("CList1");
        }
    }
}