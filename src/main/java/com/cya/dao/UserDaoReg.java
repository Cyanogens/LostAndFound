package com.cya.dao;

import com.cya.pojo.User;
import com.cya.utils.DBUtil;
import com.cya.utils.Uuid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoReg {
    public User register(String uuid, String username, String password, String telephone, String user_Xh) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "insert lostandfound.user (user_Id,user_Name,password,telephone,user_Xh) values ('" + uuid + "','" + username + "','" + password + "','" + telephone + "','" + user_Xh + "')";
        String sql2 = "select * from lostandfound.user where user_Xh = '" + user_Xh + "'";
        ResultSet rs;
        stmt.executeUpdate(sql);
        rs = stmt.executeQuery(sql2);
        User user = new User();
        user.setUser_Name(username);
        while (rs.next()) {
            user.setUser_Xh(rs.getString("user_Xh"));
            user.setUser_Id(rs.getString("user_Id"));
            user.setPassword(rs.getString("password"));
            user.setAddress(rs.getString("address"));
            user.setSex(rs.getString("sex"));
            user.setTelephone(rs.getString("telephone"));
        }
        return user;

    }
}
