package com.cya.utils;

import java.util.UUID;

public class Uuid {
    public static String uuid(){
        String uuid = UUID.randomUUID() + "";
        String[] arr = uuid.split("-");
        StringBuilder str = new StringBuilder();
        for (String s : arr) {
            str.append(s);
        }
        return str.toString();
    }
}
