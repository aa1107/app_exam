package com.example.a501_03.testexam0323;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_add,btn_minus,btn_multi,btn_div;
    TextView textView_result;
    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add=(Button)findViewById(R.id.button_add);
        btn_minus=(Button)findViewById(R.id.button_minus);
        btn_multi=(Button)findViewById(R.id.button_multi);
        btn_div=(Button)findViewById(R.id.button_div);
        textView_result=(TextView)findViewById(R.id.textView_result);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edit1Val=Integer.parseInt(editText1.getText().toString());
                int edit2Val=Integer.parseInt(editText2.getText().toString());

                textView_result.setText("계산결과 : "+Integer.toString(edit1Val+edit2Val));
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edit1Val=Integer.parseInt(editText1.getText().toString());
                int edit2Val=Integer.parseInt(editText2.getText().toString());

                textView_result.setText("계산결과 : "+Integer.toString(edit1Val-edit2Val));
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edit1Val=Integer.parseInt(editText1.getText().toString());
                int edit2Val=Integer.parseInt(editText2.getText().toString());

                textView_result.setText("계산결과 : "+Integer.toString(edit1Val*edit2Val));
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double edit1Val=Integer.parseInt(editText1.getText().toString());
                double edit2Val=Integer.parseInt(editText2.getText().toString());

                textView_result.setText("계산결과 : "+String.format("%.1f",edit1Val/edit2Val));
            }
        });
    }
}
