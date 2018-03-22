package com.softuvo.frp.utils;

import android.widget.Toast;

import com.softuvo.frp.config.App;

public class ToastUtil {
    public static void showLongToast(String message) {
        Toast.makeText(App.getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    public static void showSmallToast(String message) {
        Toast.makeText(App.getAppContext(), message, Toast.LENGTH_SHORT).show();
    }
}
