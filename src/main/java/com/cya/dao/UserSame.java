package com.cya.dao;


import com.cya.utils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSame {
    public int userSame(String user_Xh) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        String sql2 = "select * from lostandfound.user where user_Xh = '" + user_Xh + "'";
        ResultSet rs;
        rs = stmt.executeQuery(sql2);
        int result;
        if (rs.next()) {
            result = 1;
            System.out.println(result);
            return result;
        }else{
            result = 0;
            System.out.println(result);
            return result;
        }

    }
}
