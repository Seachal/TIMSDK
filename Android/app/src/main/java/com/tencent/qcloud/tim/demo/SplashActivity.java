package com.tencent.qcloud.tim.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.tencent.qcloud.tim.demo.login.LoginForDevActivity;

public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private static final int SPLASH_TIME = 1500;
    private View mFlashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        System.out.println("-=-=-=>>TAG = " + Thread.currentThread().getId());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        mFlashView = findViewById(R.id.flash_view);
        handleData();
    }

    /**
     * sca：postDelayed新线程？
     */
    private void handleData() {
        mFlashView.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("-=-=-=>>TAG = " + Thread.currentThread().getId());
                startLogin();
            }
        }, SPLASH_TIME);
    }

    private void startLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginForDevActivity.class);
        startActivity(intent);
        finish();
    }

}
