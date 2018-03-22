package com.softuvo.frp.interfaces;

import android.app.Dialog;

public interface DateDialogListener {
    void setDialogContext(Dialog context);

    void onOkayClick(int date, int month,int year);
}

