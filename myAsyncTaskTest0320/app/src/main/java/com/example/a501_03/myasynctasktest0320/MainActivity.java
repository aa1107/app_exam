package com.example.a501_03.myasynctasktest0320;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_start,button_stop;
    TextView textView_time;
    EditText editText_minute,editText_second;
    int timeToSecond;
    int minute=0,second=0;
    MyAsyncTask myAsyncTask=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponent();


    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void>{

        /*public String printMin(int min){
            if(min<10){
                return "0"+Integer.toString(min);
            }
            return Integer.toString(min);
        }

        public String printSec(int sec){
            if(sec<10){
                return "0"+Integer.toString(sec);
            }
            return Integer.toString(sec);
        }*/

        @Override
        protected void onPreExecute() {
            minute=editText_minute.getText().toString().equals("")?0:Integer.parseInt(String.valueOf(editText_minute.getText()));
            second=editText_second.getText().toString().equals("")?0:Integer.parseInt(String.valueOf(editText_second.getText()));
            timeToSecond=minute*60+second;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (isCancelled()==false){
                if(timeToSecond>=0){
                    publishProgress();
                }else{
                    break;
                }
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            textView_time.setText(String.format("%02d:%02d",(timeToSecond/60),
                    (timeToSecond%60)));
            timeToSecond--;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getApplicationContext(),"타이머가 끝났습니다",Toast.LENGTH_LONG).show();
            myAsyncTask=null;
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(getApplicationContext(),"타이머를 중지하였습니다",Toast.LENGTH_LONG).show();
        }
    }

    private void setComponent(){
        button_start=(Button)findViewById(R.id.button_start_main);
        button_stop=(Button)findViewById(R.id.button_stop_main);
        textView_time=(TextView)findViewById(R.id.textview_time_main);
        editText_minute=(EditText)findViewById(R.id.editText_min_main);
        editText_second=(EditText)findViewById(R.id.editText_sec_main);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAsyncTask==null){
                    myAsyncTask=new MyAsyncTask();
                    myAsyncTask.execute();
                }
//                Toast.makeText(getApplicationContext(),Integer.parseInt(String.valueOf(editText_minute.getText()))*60
//                        +Integer.parseInt(String.valueOf(editText_second.getText()))+"aa",Toast.LENGTH_LONG).show();
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAsyncTask!=null){
                    myAsyncTask.cancel(true);
                    myAsyncTask=null;
                }
            }
        });
    }
}
