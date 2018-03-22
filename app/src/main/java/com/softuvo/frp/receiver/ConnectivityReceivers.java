package com.softuvo.frp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;

import com.softuvo.frp.config.App;

import java.net.InetAddress;

public class ConnectivityReceivers extends BroadcastReceiver {
    public static ConnectivityListener connectivityListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        if (connectivityListener != null) {
            connectivityListener.onNetworkConnectionChanged(isConnected);
        }
    }

    public static boolean isConnected() {
        boolean flag;
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting())
            if (isInternetAvailable())
                flag = true;
            else
                flag = false;
        else
            flag = false;
        return flag;
    }

    public interface ConnectivityListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }

    public static boolean isInternetAvailable() {
        boolean flag = false;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            InetAddress ip = InetAddress.getByName("google.com");
            if (ip.getHostAddress().trim().length() > 0)
                flag = true;

        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
