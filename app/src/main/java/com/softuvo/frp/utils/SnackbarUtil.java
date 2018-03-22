package com.softuvo.frp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.softuvo.frp.R;
import com.softuvo.frp.config.App;

public class SnackbarUtil {
    public static void showSuccessLongSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.green));
        snackbar.show();
    }

    public static void showSuccessShortSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.green));
        snackbar.show();
    }

    public static void showErrorLongSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.red));
        snackbar.show();
    }

    public static void showErrorShortSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.red));
        snackbar.show();
    }

    public static void showWarningLongSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.orange));
        snackbar.show();
    }

    public static void showWarningShortSnackbar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, 800);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.orange));
        snackbar.show();
    }

    public static void showWarningShortSnackbarTop(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
        view.setLayoutParams(params);
        view.setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.orange));
        snackbar.show();
    }

    public static void showWarningShortSnackbarTopDialog(Dialog activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
        view.setLayoutParams(params);
        view.setBackgroundColor(ContextCompat.getColor(App.getAppContext(), R.color.orange));
        snackbar.show();
    }
}