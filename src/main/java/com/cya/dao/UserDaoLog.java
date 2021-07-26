package com.cya.dao;

import com.cya.pojo.User;
import com.cya.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoLog {
    public User login(String user_Xh, String password) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs ;
        String sql ="select * from lostandfound.user where user_Xh = '"+user_Xh+"' and password = '"+password+"'";
        /*
         * users 是数据库中存放用户信息的表格名
         * user_Xh password 是用户账号和用户密码字段名
         */
        rs = stmt.executeQuery(sql);
        User user = null;
        if (rs.next()){
            user = new User();
            user.setUser_Name(rs.getString("user_Name"));
            user.setUser_Xh(rs.getString("user_Xh"));
            user.setUser_Id(rs.getString("user_Id"));
            user.setPassword(rs.getString("password"));
            user.setAddress(rs.getString("address"));
            user.setSex(rs.getString("sex"));
            user.setTelephone(rs.getString("telephone"));
        }
        System.out.println("userdao done");
        return user;
    }
}
