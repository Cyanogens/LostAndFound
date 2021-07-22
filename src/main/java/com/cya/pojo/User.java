package com.cya.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String userId;
    String userName;
    String password;
    String sex;
    String telephone;
    String address;
    String userXh;
}
