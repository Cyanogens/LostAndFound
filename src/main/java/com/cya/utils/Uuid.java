package com.cya.utils;

import java.util.UUID;

public class Uuid {
    public static String uuid(){
        String uuid = UUID.randomUUID() + "";
        String[] arr = uuid.split("-");
        StringBuilder str5 = new StringBuilder();
        for (String s : arr) {
            str5.append(s);
        }
        return str5.toString();
    }
}
