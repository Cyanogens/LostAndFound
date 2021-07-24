package com.cya.servlet;

import com.cya.pojo.User;
import com.cya.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //登录界面user_Xh属性
        String user_Xh = req.getParameter("user_Xh");
        //登录界面 password属性
        String password = req.getParameter("password");
        //登录界面验证码name
        String verifyCode = req.getParameter("verifyCode");

        req.getSession().setAttribute("user_Xh",user_Xh);
        req.getSession().setAttribute("password",password);

        String svc =(String) req.getSession().getAttribute("sessionVerify");
        HttpSession session = req.getSession();
        if(!svc.equalsIgnoreCase(verifyCode)){
            out.print("<script language='javascript' " +
                    "charset='utf-8'>alert('wrong VerifyCode,please try it again!!');" +
                    "window.location.href='http://localhost:8080/web/';</script>");
            return;
        }
        User user = null;
        UserService userService = new UserService();
        try {
            user = userService.login(user_Xh,password);
            System.out.println(user);
            System.out.println("test try");
        } catch (SQLException e) {
            System.out.println("test catch");
            e.printStackTrace();
        }
        if(user != null){
            String user_Id = user.getUser_Id();
            session.setAttribute("user_Id",user_Id);
            session.setAttribute("user",user);
            session.setAttribute("username",user.getUser_Name());
            session.setAttribute("telephone",user.getTelephone());
            session.setAttribute("address",user.getAddress());
            req.getSession().setAttribute("user",user);
            System.out.println(user_Id);
            System.out.println("login success");
            resp.sendRedirect("http://localhost:8080/web/LostAndFound/toPerson");//主页面
        }else if (user == null) {
            System.out.println(user);
            System.out.println("login failed");
            out.print("<script language='javascript' " +
                    "charset='utf-8'>alert('wrong account or password,please try it again!!');" +
                    "window.location.href='http://localhost:8080/web/';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
