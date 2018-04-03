package com.example.a501_03.intentexample0307;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 501-03 on 2018-03-07.
 */

public class InfoActivity1 extends AppCompatActivity {

    Button btn_call,btn_map,btn_move,btn_admit;

    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);

        btn_call=(Button)findViewById(R.id.btn_call);
        btn_admit=(Button)findViewById(R.id.btn_admit);
        btn_move=(Button)findViewById(R.id.btn_move);
        btn_map=(Button)findViewById(R.id.btn_map);


    }

    class MyBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_call:
                    break;
                case R.id.btn_admit:
                    break;
                case R.id.btn_move:
                    break;
                case R.id.btn_map:
                    break;

            }
        }
    }
}
