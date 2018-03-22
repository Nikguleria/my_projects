package com.softuvo.frp.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;

import com.softuvo.frp.R;
import com.softuvo.frp.interfaces.DateDialogListener;

import java.util.Calendar;

public class CustomDateDialog {
    private int day;
    private int month;
    private int year;
    private DatePicker datepicker;
    /*private Boolean isTimeChanged;*/

    private static final CustomDateDialog ourInstance = new CustomDateDialog();

    public static CustomDateDialog getInstance() {
        return ourInstance;
    }

    private CustomDateDialog() {
    }


    public void DatePicker(Context mContext, final DateDialogListener dateDialogListener) {
        final Dialog dialog = new Dialog(mContext);
        dateDialogListener.setDialogContext(dialog);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_date_picker);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        datepicker = dialog.findViewById(R.id.datepicker);
        datepicker.setMaxDate(System.currentTimeMillis());
        datepicker.setMinDate(System.currentTimeMillis() - 518400000L);
        TextView tv_ok = dialog.findViewById(R.id.tv_ok);
        TextView tv_cancel = dialog.findViewById(R.id.tv_cancel);

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = datepicker.getDayOfMonth();
                int month = datepicker.getMonth();
                int year = datepicker.getYear();
                dateDialogListener.onOkayClick(day, month, year);

            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}

