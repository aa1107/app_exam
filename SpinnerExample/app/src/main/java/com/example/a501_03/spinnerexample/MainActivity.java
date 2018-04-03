package com.example.a501_03.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_fruits;
    ArrayAdapter arrayAdapter;
    boolean isInitSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. 스피너 객체 만들기
        spinner_fruits = (Spinner)findViewById(R.id.spinner_fruits);
        arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.fruits,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner_fruits.setAdapter(arrayAdapter);

        FruitListener fruitListener=new FruitListener();

        spinner_fruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!isInitSpinner){
                    //1
                    isInitSpinner=true;
                }else{
                    Toast.makeText(MainActivity.this,arrayAdapter.getItem(i).toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this,"항목이 선택되지 않았습니다.",Toast.LENGTH_LONG).show();
            }
        });
    }

    class FruitListener implements Spinner.OnItemSelectedListener{


        //스피너에서 항목이 선택되었을 때, 스피너가 생성될 때
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if(!isInitSpinner){
                //1
                isInitSpinner=true;
            }else{
                Toast.makeText(MainActivity.this,arrayAdapter.getItem(i).toString(),Toast.LENGTH_LONG).show();
            }
            //2
        }
        //스피너에서 항목이 선택되지 않았을 때
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
