package com.example.a501_03.progressbar_example0315_2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        ProgressBar progressBar_circle_main,progressBar_bar_main,progressBar_3sec_main;
        Switch switch_circle_on_off_main;
        Button btn_plus_main,btn_minus_main,btn_3sec_main,btn_wait;
    MyBtnWaitThread myBtnWaitThread;
        int i=0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar_circle_main=(ProgressBar)findViewById(R.id.progressBar_main);
        switch_circle_on_off_main=(Switch)findViewById(R.id.switch1_main);
        progressBar_bar_main=(ProgressBar)findViewById(R.id.progressBar_bar_main);
        progressBar_3sec_main=(ProgressBar)findViewById(R.id.progressBar_3sec_main);
        btn_plus_main=(Button)findViewById(R.id.btn_plus_main);
        btn_minus_main=(Button)findViewById(R.id.btn_minus_main);
        btn_3sec_main=(Button)findViewById(R.id.btn_3sec_main);
        btn_wait=(Button)findViewById(R.id.btn_wait_main);

        progressBar_bar_main.setMax(200);
//        int num=progressBar_bar_main.getMax();
        progressBar_bar_main.setProgress(100);
        progressBar_bar_main.setSecondaryProgress(150);

        switch_circle_on_off_main.setOnCheckedChangeListener(new SwitchListener());

        btn_plus_main.setOnClickListener(new ButtonListener());
        btn_minus_main.setOnClickListener(new ButtonListener());
        btn_3sec_main.setOnClickListener(new ButtonListener());
        btn_wait.setOnClickListener(new ButtonListener());

    }

    class MyBtnWaitThread extends Thread{
            int command;

        public MyBtnWaitThread(int command) {
            this.command = command;
        }

        @Override
        public void run() {
            switch (command){
                case 1:
                    try{
                        Thread.sleep(5000);
                    }catch (Exception e){}
                    handler1.sendEmptyMessage(1);
                    break;
                case 2:
                    break;
                case 3:
                    break;

            }
        }
    }

    // 쓰레드 만들기
    class MyThread extends Thread{

        // 모바일(안드로이드) 환경은 메인스레드에 따로 요청이 필요 화면은 메인스레드가 모두 작동시키기때문
        @Override
        public void run() {
            try{
                Thread.sleep(3000);
            }catch (Exception e){}
            //핸들러에게 일을 마쳤음을 보고
            handler.sendEmptyMessage(0);
        }
    }

    Handler tempHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    Handler handler1=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Toast.makeText(getApplicationContext(),(i++)+"Good Man!",Toast.LENGTH_LONG).show();
                    Log.d("NUMBER",Integer.toString(i));
                    break;
            }
        }
    };

    //핸들러 만들기(UI관련 처리를 위해 스레드에서 메인스레드로 요청하기 위함)
    Handler handler =new Handler(){
            // 스레드에게 일이 종료 되었음을 보고 받음
            public void handleMessage(Message msg){
                //스레드가 여러개라도 핸들러는 하나이기 때문
                switch (msg.what){
                    case 0:
                        //메인 스레드에게 일의 결과와 메인 스레드가 할 수 있는 일을 알려줌
                        progressBar_3sec_main.setVisibility(View.INVISIBLE);
                        break;
                    case 1:

                        break;
                }
            }
    };

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_wait_main:
                    myBtnWaitThread=new MyBtnWaitThread(1);
                    myBtnWaitThread.setDaemon(true);
                    myBtnWaitThread.start();
                    break;
                case R.id.btn_3sec_main:
//                    Toast.makeText(getApplicationContext(),"ㅁㅁㅁ",Toast.LENGTH_LONG).show();
                    progressBar_3sec_main.setVisibility(View.VISIBLE);
                    MyThread myThread=new MyThread();
                    myThread.setDaemon(true); // 메인스레드가 일을 다 마치고 없어지면 해당스레드도 없어짐
                    myThread.start();  //작업이 끝나면 꺼짐, 몇개까지의 정의는 없음 스레드 개수 한계는 잇음
                    break;
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
