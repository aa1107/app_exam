package com.example.a501_03.listview;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by 501-03 on 2018-03-05.
 */

public class Info2Activity extends AppCompatActivity {
    Intent intent;
    Button btn_date,btn_time,btn_admit,btn_cancel,btn_seat_reset;
    TextView tv_day,tv_time,tv_tit,tv_drt,tv_act,tv_type,tv_seatcount;
    EditText tf_seat;
    GregorianCalendar calendar;
    int year,month,day,hour,min,movie_idx;
    MyCal myCal;
    MyTimer myTimer;
    String[] movie_title,movie_drc,movie_act,movie_type;
    SeekBar sb_Seatcount;
    boolean isSeekBarstarted;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        intent=getIntent();
        movie_idx=intent.getIntExtra("movie_index",-1);

        calendar=new GregorianCalendar();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR_OF_DAY);
        min=calendar.get(Calendar.MINUTE);

        btn_date=(Button)findViewById(R.id.input_day);
        btn_time=(Button)findViewById(R.id.input_time);
        btn_admit=(Button)findViewById(R.id.info2_admit);
        btn_cancel=(Button)findViewById(R.id.info2_cancel);
        btn_seat_reset=(Button)findViewById(R.id.btn_seatreset);
        tv_day=(TextView)findViewById(R.id.tv_day);
        tv_time=(TextView)findViewById(R.id.tv_time);
        tv_tit=(TextView)findViewById(R.id.movie_title);
        tv_drt=(TextView)findViewById(R.id.movie_drt);
        tv_act=(TextView)findViewById(R.id.movie_act);
        tv_type=(TextView)findViewById(R.id.movie_type);
        tv_seatcount=(TextView)findViewById(R.id.tv_seatcount);
        sb_Seatcount=(SeekBar)findViewById(R.id.seekBar_seatcount);

        movie_title=getResources().getStringArray(R.array.movie_tit);
        movie_drc=getResources().getStringArray(R.array.movie_director);
        movie_act=getResources().getStringArray(R.array.movie_actor);
        movie_type=getResources().getStringArray(R.array.movie_type);

        myCal = new MyCal();
        myTimer=new MyTimer();

        MyBtnListener myBtnListener= new MyBtnListener();
        MySeekBar mySeekBar = new MySeekBar();

        btn_date.setOnClickListener(myBtnListener);
        btn_time.setOnClickListener(myBtnListener);
        btn_cancel.setOnClickListener(myBtnListener);
        btn_admit.setOnClickListener(myBtnListener);
        btn_seat_reset.setOnClickListener(myBtnListener);
        sb_Seatcount.setOnSeekBarChangeListener(mySeekBar);

        if(movie_idx!=-1){
            tv_tit.setText("제목 : "+movie_title[movie_idx]);
            tv_drt.setText("감독 : "+movie_drc[movie_idx]);
            tv_act.setText("출연 : "+movie_act[movie_idx]);
            tv_type.setText("장르 : "+movie_type[movie_idx]);
        }
    }

    class MySeekBar implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            if(!isSeekBarstarted){
                isSeekBarstarted=true;
            }else{
                tv_seatcount.setText("선택 좌석 : "+(i+1)+"석");
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    class MyBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.input_day:
                    new DatePickerDialog(Info2Activity.this, myCal,year,month,day).show();
                    break;
                case R.id.input_time:
                    new TimePickerDialog(Info2Activity.this,myTimer,hour,min,true).show();
                    break;
                case R.id.info2_cancel:
                    intent = new Intent();
                    intent.putExtra("취소","취소되었습니다.");
                    setResult(RESULT_CANCELED,intent);
                    finish();
                    break;
                case R.id.info2_admit:
                    intent = new Intent(Info2Activity.this,Info3Activity.class);
                    intent.putExtra("예매","예매 완료되었습니다.");
                    startActivityForResult(intent,3);
                    break;
                case R.id.btn_seatreset:
                    sb_Seatcount.setProgress(0);
                    break;
            }
        }
    }

    class MyCal implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            tv_day.setText("날짜 : "+i+"년:"+(i1+1)+" 월:"+i2+"일");
        }
    }

    class MyTimer implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            tv_time.setText("시간 : "+i+"시 "+i1+"분");
        }
    }
}
