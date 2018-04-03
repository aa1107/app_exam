package com.example.a501_03.fileexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    EditText editTextContents_main;
    Button btnInput,btnOutput,btnDelete;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInput=(Button)findViewById(R.id.buttonInput_main);
        btnOutput=(Button)findViewById(R.id.buttonOutput_main);
        btnDelete=(Button)findViewById(R.id.buttonDelete_main);
        editTextContents_main=(EditText)findViewById(R.id.editTextContents_main);

        btnInput.setOnClickListener(new BtnListener());
        btnOutput.setOnClickListener(new BtnListener());
        btnDelete.setOnClickListener(new BtnListener());
    }

    class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.buttonOutput_main:
                    FileOutputStream fos=null;
                    try{
                        fos=openFileOutput("test.txt", Context.MODE_PRIVATE);

                        String str_temp=editTextContents_main.getText().toString().equals("")?"default":editTextContents_main.getText().toString();
                        fos.write(str_temp.getBytes());

                        fos.close();
                    }catch (Exception e){

                    }
                    break;
                case R.id.buttonInput_main:
                    FileInputStream fis=null;
                    byte[] data=null;

                    try{
                        fis=openFileInput("test.txt");
                        data=new byte[fis.available()];
                        while(fis.read(data)!=-1){}
                        fis.close();
                        String temp = new String(data);
                        editTextContents_main.setText(temp);
                    }catch (Exception e){
                        Log.d("file stream","input stream error");
                    }
                    break;
                case R.id.buttonDelete_main:
                    try{
                        deleteFile("test.txt");
                        Toast.makeText(getApplicationContext(),"파일이 삭제되었습니다.",Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Log.d("file stream",e.getStackTrace().toString());
                    }
                    break;
            }
        }
    }
}
