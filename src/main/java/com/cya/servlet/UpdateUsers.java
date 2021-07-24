package com.cya.servlet;

import com.cya.pojo.User;
import com.cya.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 * @author WANGZIC
 */
@WebServlet("/updateUsers")
public class UpdateUsers extends LoginServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("user");
        System.out.println(user);
        req.setAttribute("user_Xh",user.getUser_Xh());
        req.setAttribute("username",user.getUser_Name());
        req.setAttribute("sex",user.getSex());
        req.setAttribute("address",user.getAddress());
        req.setAttribute("telephone",user.getTelephone());
        req.getRequestDispatcher("/webPages/ChangeMyMessage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req. setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        UserService userService = new UserService();
        int user_Id = (int) req.getSession().getAttribute("user_Id");
        String user_Xh = req.getParameter("user_Xh");
        String sex = req.getParameter("sex");
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String telephone = req.getParameter("telephone");
        System.out.println(user_Id);
        User user = null;
        try {
            user = userService.updataUsers(user_Id,username,sex,telephone,user_Xh,address);
            req.getSession().setAttribute("user",user);
            System.out.println("userUpdata try success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("userUpdata catch success");
        }
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user_Id",user.getUser_Id());
            session.setAttribute("user_Xh",user_Xh);
            session.setAttribute("username",user.getUser_Name());
            session.setAttribute("telephone",user.getTelephone());
            session.setAttribute("address",user.getAddress());
            System.out.println("updata success");
            out.print("<script language='javascript' charset='utf-8'>alert('updata success!!');</script>");
            resp.sendRedirect("/webPages/myArea.jsp");
        }else{
            System.out.println("updata fail");
            out.print("<script language='javascript' charset='utf-8'>alert('updata fail!!');</script>");
            resp.sendRedirect("updateUsers");

        }
        System.out.println(user_Xh);
    }
}
