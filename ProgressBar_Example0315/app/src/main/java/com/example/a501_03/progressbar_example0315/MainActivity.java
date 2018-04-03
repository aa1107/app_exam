package com.example.a501_03.progressbar_example0315;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar_circle_main,progressBar_bar_main;
    Switch switch_circle_on_off_main;
    Button btn_plus_main,btn_minus_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar_circle_main=(ProgressBar)findViewById(R.id.progressBar_main);
        switch_circle_on_off_main=(Switch)findViewById(R.id.switch1_main);
        progressBar_bar_main=(ProgressBar)findViewById(R.id.progressBar_bar_main);
        btn_plus_main=(Button)findViewById(R.id.btn_plus_main);
        btn_minus_main=(Button)findViewById(R.id.btn_minus_main);

        progressBar_bar_main.setMax(200);
//        int num=progressBar_bar_main.getMax();
        progressBar_bar_main.setProgress(100);
        progressBar_bar_main.setSecondaryProgress(150);

        switch_circle_on_off_main.setOnCheckedChangeListener(new SwitchListener());

        btn_plus_main.setOnClickListener(new ButtonListener());
        btn_minus_main.setOnClickListener(new ButtonListener());

    }

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_plus_main:
                    progressBar_bar_main.incrementProgressBy(10);
                    break;
                case R.id.btn_minus_main:
                    progressBar_bar_main.incrementProgressBy(-10);
                    break;

            }
        }
    }

    class SwitchListener implements Switch.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                progressBar_circle_main.setVisibility(View.VISIBLE);
            }else{
                progressBar_circle_main.setVisibility(View.INVISIBLE);
            }
        }
    }
}