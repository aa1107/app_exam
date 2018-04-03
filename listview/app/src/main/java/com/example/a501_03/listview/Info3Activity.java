package com.example.a501_03.listview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 501-03 on 2018-03-07.
 */

public class Info3Activity extends AppCompatActivity {
    Button btn_call,btn_map,btn_move,btn_admit;

    Intent intent,Intent2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info3);

        Intent2=getIntent();

        btn_call=(Button)findViewById(R.id.btn_call);
        btn_admit=(Button)findViewById(R.id.btn_info3_admit);
        btn_move=(Button)findViewById(R.id.btn_move);
        btn_map=(Button)findViewById(R.id.btn_map);

        MyBtnListener myBtnListener = new MyBtnListener();

        btn_call.setOnClickListener(myBtnListener);
        btn_admit.setOnClickListener(myBtnListener);
        btn_move.setOnClickListener(myBtnListener);
        btn_map.setOnClickListener(myBtnListener);
    }

    class MyBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_call:
                    intent=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:01012345678"));
                    startActivity(intent);
                    break;
                case R.id.btn_info3_admit:

                    break;
                case R.id.btn_move:
                    intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.naver.com"));
                    startActivity(intent);
                    break;
                case R.id.btn_map:
                    intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:36.6420470,127.4888220"));
                    startActivity(intent);
                    break;

            }
        }
    }
}
