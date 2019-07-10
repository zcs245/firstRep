package cn.mjrj.myproject.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("Login")
public class LoginService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String passWord = request.getParameter("password");
        String userType = request.getParameter("user");
        Service service = new Service();
        if (service.login(id, passWord, userType) == null) {
            request.setAttribute("errorMsg", "您的输入或者选择有误");
            request.getRequestDispatcher("./WEB-INF/views/_login.jsp").forward(request,response);
        } else {
            request.getSession().setAttribute("user",id+passWord);
            if ("校教务".equals(userType)) {
                response.sendRedirect("UList");
            } else if ("院教务".equals(userType)) {
                response.sendRedirect("CList");
            } else if ("老师".equals(userType)) {
                userType= java.net.URLEncoder.encode(userType,"UTF-8");
                response.sendRedirect("TList?id="+id+"&userType="+userType);
            } else if ("学生".equals(userType)) {
                userType= java.net.URLEncoder.encode(userType,"UTF-8");
                response.sendRedirect("SList?id="+id+"&userType="+userType);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./WEB-INF/views/_login.jsp").forward(request,response);
    }
}
