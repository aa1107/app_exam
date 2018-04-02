package com.example.a501_03.myexamapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittext_num1;
    EditText edittext_num2;
    TextView textView_result;
    Button button_add, button_minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext_num1 = (EditText)findViewById(R.id.add1);
        edittext_num2 = (EditText)findViewById(R.id.add2);
        textView_result = (TextView)findViewById(R.id.result);
        button_add = (Button)findViewById(R.id.btn_add);
        button_minus = (Button)findViewById(R.id.btn_minus);
        MyListener adder = new MyListener();
        MyListener2 minus1 = new MyListener2();
        MyUnitedListener3 myUnitedListener3 = new MyUnitedListener3();
        button_add.setOnLongClickListener(myUnitedListener3);
        button_minus.setOnLongClickListener(myUnitedListener3);
        // text컴포넌트2 객체 생성;

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    // 리스너 만들기
    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String input_num1 = edittext_num1.getText().toString();
            String input_num2 = edittext_num2.getText().toString();

            int result = Integer.parseInt(input_num1)+Integer.parseInt(input_num2);
            textView_result.setText("결과 : "+result);
        }
    }

    class MyListener2 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String input_num1 = edittext_num1.getText().toString();
            String input_num2 = edittext_num2.getText().toString();

            int result = Integer.parseInt(input_num1)-Integer.parseInt(input_num2);
            textView_result.setText("결과 : "+result);
        }
    }

    class MyUnitedListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String input_num1 = edittext_num1.getText().toString();
            String input_num2 = edittext_num2.getText().toString();
            int result=0;
            switch (view.getId()){
                case R.id.btn_add:
                    result = Integer.parseInt(input_num1)+Integer.parseInt(input_num2);
                    break;
                case R.id.btn_minus:
                    result = Integer.parseInt(input_num1)-Integer.parseInt(input_num2);
                    break;
            }
            textView_result.setText("결과 : "+result);
        }
    }
    class MyUnitedListener3 implements View.OnLongClickListener{
        @Override
        public boolean onLongClick(View view) {
            String input_num1 = edittext_num1.getText().toString();
            String input_num2 = edittext_num2.getText().toString();
            int result=0;
            switch (view.getId()){
                case R.id.btn_add:
                    result = Integer.parseInt(input_num1)+Integer.parseInt(input_num2);
                    break;
                case R.id.btn_minus:
                    result = Integer.parseInt(input_num1)-Integer.parseInt(input_num2);
                    break;
            }
            textView_result.setText("결과 : "+result);
            return false;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
