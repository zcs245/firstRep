package cn.mjrj.myproject.service;

import cn.mjrj.myproject.dal.order.OrderDao;
import cn.mjrj.myproject.entity.SysStudents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("SList")
public class SListService extends HttpServlet {
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
        SysStudents sysStudents = service.findByIdStu(id);
        request.setAttribute("name",sysStudents.getName());
        request.setAttribute("ClassNumber",sysStudents.getCnum().getClassNumber());
        request.getRequestDispatcher("./WEB-INF/views/_students.jsp").forward(request, response);
    }
}
