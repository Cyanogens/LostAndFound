package com.cya.utils;

import java.util.UUID;

public class Uuid {
    public static String uuid(){
        return UUID.randomUUID() + "";
    }
}
