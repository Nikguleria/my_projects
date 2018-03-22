package com.softuvo.frp.activities;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import com.softuvo.frp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_DURATION = 5000;
    private AppCompatActivity mContext;
    GradientDrawable bgShape;
    @BindView(R.id.vv_splash)
    VideoView vvSplash;

    @BindView(R.id.tv_welcome)
    TextView tvWelcomeText;

    @BindView(R.id.tv_app_desc)
    TextView tvDesc;

    @BindView(R.id.btn_members)
    TextView btnMember;

    @BindView(R.id.btn_guest)
    TextView btnGuest;

    @BindView(R.id.btn_live_djs)
    TextView btnLiveDjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mContext = SplashActivity.this;
        bgShape = (GradientDrawable)btnMember.getBackground();
        bgShape.setColor(getResources().getColor(R.color.colorMember));

        bgShape = (GradientDrawable)btnGuest.getBackground();
        bgShape.setColor(getResources().getColor(R.color.colorGuest));

        bgShape = (GradientDrawable)btnLiveDjs.getBackground();
        bgShape.setColor(getResources().getColor(R.color.colorLiveDjs));

        String path = "android.resource://" + getPackageName() + "/" + R.raw.app_vedio_bg;
        vvSplash.setVideoURI(Uri.parse(path));
        vvSplash.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, LoginActivity.class));
                    finish();
            }
        }, SPLASH_TIME_DURATION);
    }
}
