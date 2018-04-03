package com.example.a501_03.activityexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_first, btn_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_first = (Button)findViewById(R.id.btn_first);
        btn_second = (Button)findViewById(R.id.btn_second);

        CallListener callListener = new CallListener();

        btn_first.setOnClickListener(callListener);
        btn_second.setOnClickListener(callListener);
    }

    class CallListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_first:
                    // 1. 데이터를 송신할 액티비티에서 인텐트를 전달할 인텐트를 만듬
                    intent = new Intent(MainActivity.this,FirstActivity.class);
                    // 2. 전달할 인텐트에 데이터를 추가하고 화면전환하기
                    intent.putExtra("MainToFirst","메인에서 퍼스트로"); // 이름,값 쌍
                    intent.putExtra("MainToFirst_number",1000);
                    setResult(RESULT_OK, intent);
                    startActivityForResult(intent,1); // 아이디
                    break;
                case R.id.btn_second:
                    intent = new Intent(getApplicationContext(),SecondActivity.class);
                    startActivityForResult(intent,1);
                    break;
            }

//            startActivity(intent);
        }
    }
    //6. 인텐트에 포함된 데이터를 읽어오는 함수
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    Toast.makeText(MainActivity.this,
                            data.getStringExtra("FirstToMain"),Toast.LENGTH_LONG).show();

                }
        }
    }
}
