package com.example.a501_03.asynctaskexample0320;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView_temp;
    Button button_start, button_stop;
    TextView textView_second;
    ProgressBar progressBar_main;
    int count_value;
    int tempnum;
    MyAsyncTask myAsyncTask=null;
    MyAsyncTask2 myAsyncTask2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponent();
    }
    // AsyncTask 객체를 생성하기 위한 클래스
    // AsyncTask<A,B,C>
    // A: doInBackground()함수의 매개변수 자료형태(... 제외)
    // B: onProgressUpdate()함수의 매개변수 자료형태(... 제외)
    // C: onPostExecute()함수의 매개변수 자료형태(... 제외)

    class MyAsyncTask2 extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            tempnum=0;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            textView_temp.setText(Integer.toString(tempnum));
        }

        @Override
        protected void onCancelled() {
        }

        @Override
        protected Void doInBackground(Void... voids) {

            while(true){
                if(tempnum>1000) break;
                publishProgress();
                tempnum++;
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
            return null;
        }
    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void>{
       /* @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }*/
 // void가 대문자, AsyncTask의 특징
        @Override
        protected Void doInBackground(Void... arg) {
            while (isCancelled()==false){  // 이 AsyncTask가 동작하고 있으면 isCancelled()은
                count_value++;

                /*class MyAsyncTask extends AsyncTask<Integer, Void, Void>{

                    // void가 대문자, AsyncTask의 특징
                    @Override
                    protected Void doInBackground(Integer... arg) {
                        while (isCancelled()==false){  // 이 AsyncTask가 동작하고 있으면 isCancelled()은 true
                            count_value++;
                            int a=arg[0];*/
                if(count_value<=1000){
                    publishProgress();
                }else{
                    break;
                }
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
            return null;
        }
        // 작업 시작 전에 계산을 위한 초기화, 컴포넌트 값 초기화(프로그레스바 표시)를 처리하는 함수
        @Override
        protected void onPreExecute() {
            count_value=0;
            progressBar_main.setVisibility(View.INVISIBLE);
        }
        // 작업 진행 사항을 표시하기 위한 함수, publishProgress()함수를 호출하면 동작
        @Override
        protected void onProgressUpdate(Void... arg) {
            progressBar_main.setVisibility(View.VISIBLE);
            textView_second.setText(Integer.toString(count_value));
        }

        // 작업 진행이 끝나면 호출되는 함수, doInBackground()함수의 리턴 값을 매개 변수로 받는다.
        @Override
        protected void onPostExecute(Void result) {
            textView_second.setText("1000번을 카운트 하였습니다.");
            progressBar_main.setVisibility(View.INVISIBLE);
        }
        //작업 진행 중에 작업 취소할 때 호출되는 함수
        @Override
        protected void onCancelled() {
            progressBar_main.setVisibility(View.INVISIBLE);
            textView_second.setText("사용자가 중단하였습니다");
        }
    }

    private void setComponent(){
        button_start=(Button)findViewById(R.id.button_start_main);
        button_stop=(Button)findViewById(R.id.button_stop_main);
        textView_second=(TextView)findViewById(R.id.textView_second_main);
        textView_temp=(TextView)findViewById(R.id.textView_temp);
        progressBar_main=(ProgressBar)findViewById(R.id.progressBar_main);

        /*button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAsyncTask2==null) {
                    myAsyncTask2 = new MyAsyncTask2();
                    myAsyncTask2.execute();
                }
            }
        });*/
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAsyncTask==null){
                    myAsyncTask=new MyAsyncTask();
                    // AsyncTask 객체가 작업을 시작함
                    myAsyncTask.execute();
                }
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAsyncTask!=null){
                    //AsyncTask 객체가 진행하고 있는 작업을 취소함
                    myAsyncTask.cancel(true);
                    myAsyncTask=null;
                }
            }
        });
    }
}
