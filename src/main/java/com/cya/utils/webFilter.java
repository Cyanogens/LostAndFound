package com.cya.utils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/*拦截器
防止用户不登录直接访问webPages文件夹下的网页
* */
@WebFilter(filterName = "webFilter",urlPatterns = "/webPages/*")
public class webFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        String user = (String) session.getAttribute("user_Xh");
        if (user == null || "".equals(user)) {
            out.print("<script language='javascript' charset='utf-8'>alert('err filter!');window.location.href = '/login.jsp';</script>");
        }else{
            chain.doFilter(request,response);
        }

    }
}
