package com.example.a501_03.seekbarexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_red,btn_blue,btn_green;
    SeekBar seekbar_red,seekbar_green,seekbar_blue;
    TextView show;
    int red=0,blue=0,green=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. 컴포넌트의 객체 만들기
        seekbar_red = (SeekBar)findViewById(R.id.seekbar_red);
        seekbar_green = (SeekBar)findViewById(R.id.seekbar_green);
        seekbar_blue = (SeekBar)findViewById(R.id.seekbar_blue);
        show = (TextView)findViewById(R.id.textView_show);
        btn_red = (Button)findViewById(R.id.btn_red);
        btn_green = (Button)findViewById(R.id.btn_green);
        btn_blue = (Button)findViewById(R.id.btn_blue);

        SeekbarListener seekbarListener = new SeekbarListener();
        ButtonListener buttonListener = new ButtonListener();

        btn_red.setOnClickListener(buttonListener);
        btn_green.setOnClickListener(buttonListener);
        btn_blue.setOnClickListener(buttonListener);
        seekbar_red.setOnSeekBarChangeListener(seekbarListener);
        seekbar_green.setOnSeekBarChangeListener(seekbarListener);
        seekbar_blue.setOnSeekBarChangeListener(seekbarListener);
    }
    //3. 리스너의 클래스를 만들기

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_red:
                    seekbar_red.setProgress(255);
                    seekbar_green.setProgress(0);
                    seekbar_blue.setProgress(0);
                    break;
                case R.id.btn_green:
                    seekbar_red.setProgress(0);
                    seekbar_green.setProgress(255);
                    seekbar_blue.setProgress(0);
                    break;
                case R.id.btn_blue:
                    seekbar_red.setProgress(0);
                    seekbar_green.setProgress(0);
                    seekbar_blue.setProgress(255);
                    break;
            }
        }
    }

    class SeekbarListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//시크바를 움직일때
            switch (seekBar.getId()){
                case R.id.seekbar_blue:
                    blue=i;
                    break;
                case R.id.seekbar_green:
                    green=i;
                    break;
                case R.id.seekbar_red:
                    red=i;
                    break;
            }
            show.setText("현재 값 : "+i);
            show.setBackgroundColor(Color.rgb(red,green,blue));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {//시크바에 손을 대면
            Toast.makeText(getApplicationContext(),"start",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {//시크바에 손을 때면

        }
    }
}
