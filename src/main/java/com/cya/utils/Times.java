package com.cya.utils;

import java.sql.Date;

public class Times {

    public static Date getTime(){
        java.util.Date date = new java.util.Date();
        return new java.sql.Date(date.getTime());
    }
}
