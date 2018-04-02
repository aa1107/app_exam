package com.example.a501_03.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn_time,btn_date;
    DateSetListener dateSetListener;
    TimeSetListener timeSetListener;
    int year, month, day, hour, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //현재 시간과 날짜를 얻음
        GregorianCalendar calendar=new GregorianCalendar(Locale.KOREA);
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR_OF_DAY);
        min=calendar.get(Calendar.MINUTE);

        Toast.makeText(this,calendar.get(Calendar.DAY_OF_WEEK)+"a",Toast.LENGTH_LONG).show();

        //2. 컴포넌트의 객체 만들기
        btn_time=(Button)findViewById(R.id.btn_time);
        btn_date=(Button)findViewById(R.id.btn_date);
        dateSetListener=new DateSetListener();
        timeSetListener=new TimeSetListener();
        btn_date.setOnClickListener(new MyButtonListener());
        btn_time.setOnClickListener(new MyButtonListener());
    }

    class MyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_date:
                    new DatePickerDialog(MainActivity.this,new DateSetListener(), year, month
                    , day).show();
                    break;
                case R.id.btn_time:
                    new TimePickerDialog(MainActivity.this,new TimeSetListener(),hour,min,true).show();
                    break;
            }
        }
    }

    class TimeSetListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Toast.makeText(MainActivity.this,(i)+":"+(i1),Toast.LENGTH_LONG).show();
        }
    }

    class DateSetListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Toast.makeText(MainActivity.this,i+"/"+(i1+1)+"/"+i2,Toast.LENGTH_LONG).show();
        }
    }
}
