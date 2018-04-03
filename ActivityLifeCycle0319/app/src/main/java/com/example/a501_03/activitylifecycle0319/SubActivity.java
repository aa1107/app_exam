package com.example.a501_03.activitylifecycle0319;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by 501-03 on 2018-03-19.
 */

public class SubActivity extends AppCompatActivity {

    Button button_toMain_sub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.d("ActivityCycle","SubActivity에서 onCreate() 호출");

        button_toMain_sub=(Button)findViewById(R.id.button_toMain_sub);
        button_toMain_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityCycle","SubActivity에서 onStart() 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityCycle","SubActivity에서 onResume() 호출");
    }

    @Override
    // 앱이 강제종료 될 때를 대비해 onPause()에 함수를 넣는게 안전함
    protected void onPause() {
        super.onPause();
        Log.d("ActivityCycle","SubActivity에서 onPause() 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityCycle","SubActivity에서 onStop() 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityCycle","SubActivity에서 onDestroy() 호출");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityCycle","SubActivity에서 onReStart() 호출");
    }
}
