package com.example.a501_03.intentexample0307;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    Button btn_1,btn_2,btn_3,btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        btn_3=(Button)findViewById(R.id.btn_3);
        btn_4=(Button)findViewById(R.id.btn_4);

        IntentBtnListener intentBtnListener=new IntentBtnListener();

        btn_1.setOnClickListener(intentBtnListener);
        btn_2.setOnClickListener(intentBtnListener);
        btn_3.setOnClickListener(intentBtnListener);
        btn_4.setOnClickListener(intentBtnListener);
    }

    class IntentBtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_1: //web
                    Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                    startActivity(intent1);
                    break;
                case R.id.btn_2: //map
                    Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:36.6420470,127.4888220"));
                    startActivity(intent2);
                    break;
                case R.id.btn_3: //phone
                    Intent intent3=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:01073392235"));
                    startActivity(intent3);
                    break;
                case R.id.btn_4: //contacts
                    Intent intent4=new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
                    startActivity(intent4);
                    break;
            }
        }
    }
}
