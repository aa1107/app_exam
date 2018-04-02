package com.example.a501_03.checkboxradioexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox_red, checkBox_green;
    RadioButton radioButton_blue,radioButton_yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox_red=(CheckBox)findViewById(R.id.checkBox2_red);
        checkBox_green=(CheckBox)findViewById(R.id.checkBox3_green);
        radioButton_blue=(RadioButton)findViewById(R.id.radioButton_blue);
        radioButton_yellow=(RadioButton)findViewById(R.id.radioButton_yellow);

        CheckBoxListener checkBoxListener=new CheckBoxListener();
        RadioBtnListener radioBtnListener=new RadioBtnListener();

        checkBox_red.setOnCheckedChangeListener(checkBoxListener);
        checkBox_green.setOnCheckedChangeListener(checkBoxListener);
        radioButton_blue.setOnCheckedChangeListener(radioBtnListener);
        radioButton_yellow.setOnCheckedChangeListener(radioBtnListener);
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                switch (compoundButton.getId()){
                    case R.id.checkBox2_red:
                        Toast.makeText(getApplicationContext(),"red",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.checkBox3_green:
                        Toast.makeText(getApplicationContext(),"green",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }

    class RadioBtnListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()){
                case R.id.radioButton_blue:
                    if(b){
                        Toast.makeText(getApplicationContext(),"blue",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.radioButton_yellow:
                    if(b){
                        Toast.makeText(getApplicationContext(),"yellow",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }
}
