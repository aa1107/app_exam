package com.example.a501_03.preferenceexample0313;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_content;
    Button button_save,button_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_content=(EditText)findViewById(R.id.editTextContent_main);
        button_save=(Button)findViewById(R.id.buttonSave_main);
        button_load=(Button)findViewById(R.id.buttonLoad_main);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //프레퍼런스 객체 생성
                SharedPreferences pref = getSharedPreferences("file_name",0); //확장자 안써도 됌
                SharedPreferences.Editor editor = pref.edit();

                //저장할 데이터를 준비
                editor.putString("test_string","저장하고 싶은 값");//key, value
                editor.putString("test_string2","또 저장한 값");
                editor.putInt("test_string3",100);
                editor.putString("my_string",editText_content.getText().toString());

                //데이터를 프레퍼런스에 저장
                editor.commit(); //트랜잭션, 배우는데 한달걸림

            }
        });
        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //프레퍼런스 객체 생성
                SharedPreferences pref = getSharedPreferences("file_name",MODE_PRIVATE);
                String temp1 = pref.getString("test_string","default_string");
                String temp2 = pref.getString("test_string2","default_string");
                int temp3 = pref.getInt("test_string3",-1);
                String temp4 = pref.getString("my_string","no_data");

                editText_content.setText(temp4);
            }
        });
    }
}
