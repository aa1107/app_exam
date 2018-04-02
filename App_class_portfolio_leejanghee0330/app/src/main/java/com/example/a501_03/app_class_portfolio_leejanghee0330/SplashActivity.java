package com.example.a501_03.app_class_portfolio_leejanghee0330;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by 501-03 on 2018-03-30.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 앱을 동작하기 위한 준비를 함
        try{
            Thread.sleep(1000);
            Toast.makeText(this,"5초가 지났습니다.",Toast.LENGTH_LONG).show();
        }catch (Exception e){}

        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
