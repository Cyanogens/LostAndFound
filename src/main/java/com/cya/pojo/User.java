package com.cya.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    String user_Id;
    String user_Name;
    String password;
    String sex;
    String telephone;
    String address;
    String user_Xh;
}
