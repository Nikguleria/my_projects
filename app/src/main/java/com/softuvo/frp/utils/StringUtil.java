package com.softuvo.frp.utils;

public class StringUtil {
    public static boolean isEmpty(String data) {
        if (data.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
