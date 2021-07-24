package com.cya.dao;


import com.cya.pojo.User;
import com.cya.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInfoUpdate {
    public User UserInfoUpdate(int user_Id, String username, String sex, String telephone, String user_Xh, String address) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "update lostandfound.user set user_Name = '"+username +"',sex ='"+sex+"',address = '"+address+"',telephone ='"+telephone+"',user_Xh = '"+user_Xh+"' where user_Id = '"+user_Id+"'";
        //String sql = "update users set sex ='"+sex+"' where user_Xh = '"+user_Xh+"'";
        //String sql = "update users set user_Name = ?,sex =?,address = ?,telephone =? where user_Xh = ?";
        int result = stmt.executeUpdate(sql);
        System.out.println(user_Xh);
        System.out.println(result);
        System.out.println("result");
        System.out.println(user_Xh);
        String sql2 ="select * from lostandfound.user where user_Xh = '"+user_Xh+" ' ";
        ResultSet rs = stmt.executeQuery(sql2);
        User user = null;
        while(rs.next()){
            user = new User();
            user.setUser_Name(rs.getString("user_Name"));
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
