package com.example.a501_03.listview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 501-03 on 2018-03-12.
 */

public class MembershipActivity extends AppCompatActivity {

    Button btnAdmit;
    Spinner spinnerMonth,spinnerDay;
    CheckBox checkBoxMan,checkBoxGirl;
    Intent intent;
    ArrayAdapter arrayAdapter1,arrayAdapter2;
    EditText editTextid,editTextpw,editTextpwConfirm,editTextName,editTextYear,editTextPhoneNum;
    TextView textView;
    boolean isidFocused,isPwConfirmFocused,isPwFocused,isIdValueTrue,isPwValueTrue,isAdmited;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        setComponent();

        arrayAdapter1=ArrayAdapter.createFromResource(MembershipActivity.this,R.array.date,
                android.R.layout.simple_spinner_item);
        arrayAdapter2=ArrayAdapter.createFromResource(getApplicationContext(),R.array.month,
                android.R.layout.simple_spinner_dropdown_item);
        MyBtnListener myBtnListener = new MyBtnListener();
//        btnAdmit.setOnClickListener(myBtnListener);
        btnAdmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("test2",MODE_PRIVATE);
                SharedPreferences.Editor editor =pref.edit();

                editor.putString("user_id",editTextid.getText().toString());
                editor.putString("user_pw",editTextpw.getText().toString());
                editor.putString("user_name",editTextName.getText().toString());

                editor.commit();


                pref = getSharedPreferences("test2",MODE_PRIVATE);

                String user_id=pref.getString("user_id","user_info");
            }
        });
        IdCheckListener idCheckListener=new IdCheckListener();
        editTextid.setOnFocusChangeListener(idCheckListener);
        editTextpw.setOnFocusChangeListener(idCheckListener);
        editTextpwConfirm.setOnFocusChangeListener(idCheckListener);
    }

    private void setAdapters(){

    }

    private void setComponent(){
        textView=(TextView)findViewById(R.id.textView_mem);
        editTextid=(EditText)findViewById(R.id.editText_id_mem);
        editTextpw=(EditText)findViewById(R.id.editText_pw_mem);
        editTextpwConfirm=(EditText)findViewById(R.id.editText_pwConfirm_mem);
        editTextName=(EditText)findViewById(R.id.editText_Name_mem);
        editTextYear=(EditText)findViewById(R.id.editText_Year_mem);
        editTextPhoneNum=(EditText)findViewById(R.id.editText_PhoneNum_mem);
        btnAdmit=(Button)findViewById(R.id.btn_Admit_mem);
        spinnerMonth=(Spinner)findViewById(R.id.spinnerMonth_mem);
        spinnerDay=(Spinner)findViewById(R.id.spinnerDay_mem);
        checkBoxMan=(CheckBox)findViewById(R.id.checkBox_Man_mem);
        checkBoxGirl=(CheckBox)findViewById(R.id.checkBox_Girl_mem);
    }

    class IdCheckListener implements View.OnFocusChangeListener{

        @Override
        public void onFocusChange(View view, boolean b) {
            switch (view.getId()){
                case R.id.editText_id_mem:
                    String user_input_id = editTextid.getText().toString();
                    int num_of_id=user_input_id.length();
                    if(!isidFocused){
                        isidFocused=true;
                    }else{
                        if(num_of_id>=5){
                            if(num_of_id<=12){
                                textView.setText("정상적인 아이디입니다");
                                isIdValueTrue=true;
                            }else{
                                textView.setText("비 정상적인 아이디 입니다.(글자수가 12보다 작아야합니다.)");
                                isIdValueTrue=false;
                            }
                        }else{
                            textView.setText("비 정상적인 아이디 입니다.(아이디의 글자 수가 5보다 커야합니다.");
                            isIdValueTrue=false;
                        }
                    }

                    break;
                case R.id.editText_pw_mem:
                    if(!isPwFocused){
                        isPwFocused=true;
                    }else{
                        String user_input_pw=editTextpw.getText().toString();
                        String regExp1="^\\w{8,14}$";
                        Pattern p=Pattern.compile(regExp1);
                        Matcher m=p.matcher(user_input_pw);
                        boolean bbb=m.matches();
                        if(bbb){
                            textView.setText("올바른 형식입니다");
                        }else{
                            textView.setText("문자,숫자 조합인 8개이상,14개 이하로 작성해 주십시오.");
                        }
                    }
                    break;
                case R.id.editText_pwConfirm_mem:
                    String user_input_pw=editTextpw.getText().toString();
                    String user_input_pwconfirm=editTextpwConfirm.getText().toString();
                    if(!isPwConfirmFocused){
                        isPwConfirmFocused=true;
                    }else{
                        if((user_input_pw).equals(user_input_pwconfirm)){
                            textView.setText("비밀번호가 일치합니다.");
                            isPwValueTrue=true;
                        }else{
                            textView.setText("비밀번호가 일치하지 않습니다.");
                            isPwValueTrue=false;
                        }
                        break;
                    }

            }

        }
    }

    class MyBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(isIdValueTrue&&isPwValueTrue){
                try{
                    if(true){
                        String idValue="userId:"+editTextid.getText().toString()+";";
                        String pwValue="userPw:"+editTextpw.getText().toString()+";";
                        FileOutputStream fis=openFileOutput("test.txt",Context.MODE_PRIVATE);
                        fis.write(idValue.getBytes());
                        fis.close();
                        Toast.makeText(getApplicationContext(),"계정이 생성되었습니다.",Toast.LENGTH_LONG).show();
                    }


                    /*FileInputStream fis = openFileInput("test.txt");
                    byte[] data=new byte[fis.available()];
                    while(fis.read(data)!=-1){}
                    fis.close();
                    String fisString="aaaa";

                        Toast.makeText(getApplicationContext(),fisString,Toast.LENGTH_LONG).show();*/

//                    Toast.makeText(getApplicationContext(),fisString,Toast.LENGTH_LONG).show();
//                    if(fisString==null){
//                        Toast.makeText(getApplicationContext(),"존재하는 아이디입니다.",Toast.LENGTH_LONG).show();
//                    }else{
//                        FileOutputStream fos = openFileOutput("test.txt", Context.MODE_PRIVATE);
//                        fos.write(idValue.getBytes());
//                        fos.close();
//                        Toast.makeText(getApplicationContext(),"계정이 생성되었습니다.",Toast.LENGTH_LONG).show();
//                    }
                }catch (Exception e){

                }
            }
        }
    }
}
