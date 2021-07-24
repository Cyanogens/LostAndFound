package com.cya.servlet;

import com.cya.pojo.User;
import com.cya.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("utf-8");
        int result = 0;
        String user_Xh= req.getParameter("user_Xh");
        String password = req.getParameter("password");
        String telephone = req.getParameter("telephone");
        String username = req.getParameter("user_Name");
        UserService userService = new UserService();
        User user = null;
        try {
            result = userService.userSame(user_Xh);
            user = userService.register(username,password,telephone,user_Xh);
            req.getSession().setAttribute("user_Id",user.getUser_Id());
            req.getSession().setAttribute("user",user);
            System.out.println("register try");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("register catch");
        }
        if (result == 1) {
            System.out.println("register failed");
            out.print("<script language='javascript' charset='utf-8'>alert('user has already existed!!');window.location.href = 'http://localhost:8080/web/';</script>");

       }else if(user != null){
            req.getSession().setAttribute("user_Xh",user_Xh);
            req.getSession().setAttribute("username",username);
            req.getSession().setAttribute("telephone",telephone);
            System.out.println("register success");
            out.print("<script language='javascript' charset='utf-8'>alert('success and you are in!!');window.location.href= 'http://localhost:8080/web/';</script>");

        }else if(user == null){
            System.out.println("register failed");
            out.print("<script language='javascript' charset='utf-8'>alert('wrong information!!');window.location.href = 'http://localhost:8080/web/';</script>");
        }
    }

}
