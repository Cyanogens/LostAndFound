package com.cya.service;

import com.cya.dao.UserDaoLog;
import com.cya.dao.UserDaoReg;
import com.cya.dao.UserInfoUpdate;
import com.cya.dao.UserSame;
import com.cya.pojo.User;
import com.cya.utils.Uuid;

import java.sql.SQLException;

public class UserService {

    public User login(String user_Xh, String password) throws SQLException {
        UserDaoLog userDao = new UserDaoLog();
        User user = userDao.login(user_Xh,password);
        System.out.println("userserviceLog done");
        return user;
    }
    public User register(String username,String password,String telephone,String user_Xh) throws SQLException {
        UserDaoReg userDaoReg = new UserDaoReg();
        String uuid = Uuid.uuid();
        User user = userDaoReg.register(uuid,username,password,telephone,user_Xh);
        System.out.println("userserviceReg done");
        return user;
    }
    public User updataUsers(int user_Id, String username, String sex, String telephone, String user_Xh, String address) throws SQLException {
        UserInfoUpdate userInfoUpdata = new UserInfoUpdate();
        User user = userInfoUpdata.UserInfoUpdate(user_Id,username,sex,telephone,user_Xh,address);
        System.out.println("updateUser done");
        return user;
    }
    public int userSame(String user_Xh) throws SQLException {
        UserSame userSame = new UserSame();
        int result = userSame.userSame(user_Xh);
        return result;
    }

}
