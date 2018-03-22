package com.softuvo.frp.interfaces;

import android.app.Dialog;

public interface TimeDialogListener {
    void setDialogContext(Dialog context);

    void onTimeSet(int hour, int minutes);

    void onOkayClick(String twentyFourTime, String TwelveHourTime);
}

