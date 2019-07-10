package cn.mjrj.myproject.service;

import cn.mjrj.myproject.entity.SysClasses;
import cn.mjrj.myproject.entity.SysLessonPlan;
import cn.mjrj.myproject.entity.SysTeachers;
import cn.mjrj.myproject.entity.SysUser;
import cn.mjrj.myproject.utils.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("TList")
public class TListServlet extends HttpServlet {
    Service service = new Service();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        request.setAttribute("id",id);
        String userType = request.getParameter("userType");
       request.setAttribute("userType",userType);
        SysTeachers sysTeachers=service.findByIdTea(id);
        request.setAttribute("name",sysTeachers.getName());
        Pager pager = new Pager();
        try {
            int page = Integer.parseInt(request.getParameter("pager"));
            pager.setPage(page);
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            pager.setPageSize(pageSize);
        } catch (Exception e) {}
        SysLessonPlan sysLessonPlan = new SysLessonPlan();
        SysTeachers t = new SysTeachers();
        SysUser u= new SysUser();
        u.setId(Integer.parseInt(id));
        t.setId(u);
        sysLessonPlan.setTid(t);
        pager = service.findWithPageTEA(pager,sysLessonPlan);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("./WEB-INF/views/_teachers.jsp").forward(request, response);
    }
}
