package com.softuvo.frp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.softuvo.frp.R;

import butterknife.ButterKnife;

public class AddRemarksActivity extends BaseActivity {
    private AppCompatActivity mContext;
  /*  private TimePickerDialog timepickerdialog;
    private String format, newstartTime;
    private GPSTracker gpsTracker;

    @BindView(R.id.et_location)
    EditText etLocation;
    @BindView(R.id.tv_start_time_edt)
    TextView tvStartTime;
    @BindView(R.id.et_notes)
    EditText etNotes;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remarks);
        ButterKnife.bind(this);
        mContext = AddRemarksActivity.this;
     //   setInitialData();
    }
/*
    // set data While screen appeared
    private void setInitialData() {
        gpsTracker = new GPSTracker(mContext);
        getCurrentLocationOnClick();
    }

    @OnClick({R.id.tv_start_time_edt, R.id.tv_save, R.id.tv_cancel})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_start_time_edt:
                newTimePicker();
                break;

            case R.id.tv_cancel:
                finish();
                break;

            case R.id.tv_save:
                if (newstartTime == null) {
                    newstartTime = "00:00:00";
                }
                Map<String, String> addRemarkMap = new HashMap<>();
                addRemarkMap.put("driverId", getIntent().getStringExtra("driverId"));
                addRemarkMap.put("time", newstartTime);
                addRemarkMap.put("start_date", getIntent().getStringExtra("selectedDateForSever"));
                addRemarkMap.put("location", etLocation.getText().toString());
                addRemarkMap.put("notes", etNotes.getText().toString());
                addRemarkMap.put("lat_long", gpsTracker.getLatitude() + ", " + gpsTracker.getLongitude());

                updateRemark(addRemarkMap);
                break;
        }
    }
 // time Picker
    private void newTimePicker() {
        timepickerdialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String minutes;
                        String hoursOfDay;
                        if (hourOfDay == 0) {
                            hourOfDay += 12;
                            format = "AM";
                        } else if (hourOfDay == 12) {
                            format = "PM";
                        } else if (hourOfDay > 12) {
                            hourOfDay -= 12;
                            format = "PM";
                        } else {
                            format = "AM";
                        }
                        if (String.valueOf(minute).length() == 1)
                            minutes = "0" + String.valueOf(minute);
                        else
                            minutes = String.valueOf(minute);
                        if (String.valueOf(hourOfDay).length() == 1)
                            hoursOfDay = "0" + String.valueOf(hourOfDay);
                        else
                            hoursOfDay = String.valueOf(hourOfDay);

                        newstartTime = BasicEldDataManager.getInstance().convertTo24Format(new StringBuilder().append(hoursOfDay).append(":").append(minutes).append(":").append("00").append(" ").append(format).toString());
                        tvStartTime.setText(new StringBuilder().append(hoursOfDay).append(":").append(minutes).append(" ").append(format));

                    }
                },0,0,false);
        timepickerdialog.show();
    }

    private void getCurrentLocationOnClick() {
        etLocation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (etLocation.getRight() - etLocation.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        GPSTracker gpsTracker = new GPSTracker(mContext);
                        etLocation.setText(BasicEldDataManager.getInstance().getLocationFormLatLong(mContext, gpsTracker.getLatitude(), gpsTracker.getLongitude()));
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void updateRemark(Map addRemarkMap) {
        if (ConnectivityReceivers.isConnected()) {
            App.getApiHelper().updateRemark(addRemarkMap, new ApiCallBack<Map>() {
                @Override
                public void onSuccess(Map userLogsResponse) {
                    if (userLogsResponse != null) {
                        SnackbarUtil.showSuccessLongSnackbar(mContext, getResources().getString(R.string.success_message));
                        enableUserIntraction();
                    }
                }

                @Override
                public void onFailure(String message) {
                    enableUserIntraction();
                    SnackbarUtil.showErrorLongSnackbar(mContext, message);
                }
            });
        } else {
            enableUserIntraction();
            SnackbarUtil.showErrorLongSnackbar(mContext, getResources().getString(R.string.internet_not_connected_text));
        }
    }*/
}