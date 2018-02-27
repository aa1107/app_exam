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
    Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext_num1 = (EditText)findViewById(R.id.add1);
        edittext_num2 = (EditText)findViewById(R.id.add2);
        textView_result = (TextView)findViewById(R.id.result);
        button_add = (Button)findViewById(R.id.btn_add);
        MyListener adder = new MyListener();
        button_add.setOnClickListener(adder);
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
