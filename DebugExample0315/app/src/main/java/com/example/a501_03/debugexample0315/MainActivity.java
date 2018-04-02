package com.example.a501_03.debugexample0315;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int a=10;
        int b=20;
        int c=a+b;

//        TextView textView_main=(TextView)findViewById(R.id.textview_main);
        TextView textView_main=null;
        textView_main.setText("결과 : "+c);
        Log.d("keyword","출력내용");

//        for(int i=0;i<5;i++){
//            a++;
//            if(i==4){
//                TextView textView_main=null;
//                textView_main.setText("결과 : "+c);
//            }
//        }

        int d=10;
        int e=d+10;
    }
}
