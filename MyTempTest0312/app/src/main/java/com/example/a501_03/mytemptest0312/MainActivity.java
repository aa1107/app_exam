package com.example.a501_03.mytemptest0312;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch switch1_main,switch2_main;

//    ToggleButton toggleButton_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switch1_main=(Switch)findViewById(R.id.switch1_main);
        Switch switch2_main=(Switch)findViewById(R.id.switch2_main);

        switch1_main.setOnCheckedChangeListener(new MySwitchListener());
        switch2_main.setOnCheckedChangeListener(new MySwitchListener());

        switch1_main.setChecked(true);
        switch1_main.setThumbResource(R.drawable.ic_launcher_background);

        /*GregorianCalendar cal=new GregorianCalendar();

        toggleButton_main=(ToggleButton)findViewById(R.id.toggleButton_main);
        toggleButton_main.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    toggleButton_main.setTextOff("Trun on");
                    Toast.makeText(getApplicationContext(),toggleButton_main.getTextOn(),Toast.LENGTH_SHORT).show();
                }else{
                    toggleButton_main.setTextOn("Trun off");
                    Toast.makeText(getApplicationContext(),toggleButton_main.getTextOff(),Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    class MySwitchListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()){
                case R.id.switch1_main:
                    if(b){
                        Toast.makeText(getApplicationContext(),"스위치1 활성화 됌",Toast.LENGTH_SHORT).show();
//                        switch1_main.setText("사과");
                    }else{
                        Toast.makeText(getApplicationContext(),"스위치1 비활성화 됌",Toast.LENGTH_SHORT).show();
//                        switch1_main.setTextOff("배");
                    }
                    break;
                case R.id.switch2_main:
                    if(b){
                        Toast.makeText(getApplicationContext(),"스위치2 활성화 됌",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"스위치2 비활성화 됌",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }


        }
    }

    /*class MyToggleButtonListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        }
    }
    class time implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {

        }
    }*/
}
