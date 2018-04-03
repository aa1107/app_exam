package com.example.a501_03.activitylifecycle0319;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ActivityCycle","MainActivity에서 onCreate() 호출");
        button_main=(Button)findViewById(R.id.button_main);
        button_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);
            }
        });

    }

    class GridListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(),(position+1)+"번 째 그리드 입니다.",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityCycle","MainActivity에서 onStart() 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityCycle","MainActivity에서 onResume() 호출");
    }

    @Override
    // 앱이 강제종료 될 때를 대비해 onPause()에 함수를 넣는게 안전함
    protected void onPause() {
        super.onPause();
        Log.d("ActivityCycle","MainActivity에서 onPause() 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityCycle","MainActivity에서 onStop() 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityCycle","MainActivity에서 onDestroy() 호출");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityCycle","MainActivity에서 onReStart() 호출");
    }


}
