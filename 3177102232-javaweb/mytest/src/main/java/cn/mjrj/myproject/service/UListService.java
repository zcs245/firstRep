package cn.mjrj.myproject.service;


import cn.mjrj.myproject.entity.SysTeacherPlan;
import cn.mjrj.myproject.utils.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("UList")
public class UListService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        Pager pager = new Pager();
        try {
            int page = Integer.parseInt(request.getParameter("pager"));
            pager.setPage(page);
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            pager.setPageSize(pageSize);
        } catch (Exception e) {}
            pager = service.findWithPageUNI(pager,new SysTeacherPlan());
            request.setAttribute("pager", pager);
            request.getRequestDispatcher("./WEB-INF/views/_university.jsp").forward(request, response);
    }
}
