package cn.mjrj.myproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String url = request.getRequestURI();
        if (url.indexOf("/Login")>=0){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            Object obj = request.getSession().getAttribute("user");
            if (obj!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                ((HttpServletResponse) servletResponse).sendRedirect("/Login");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
