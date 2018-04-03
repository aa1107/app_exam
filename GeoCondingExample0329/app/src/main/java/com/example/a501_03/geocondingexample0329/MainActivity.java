package com.example.a501_03.geocondingexample0329;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText_lat,editText_lng,editText_pos;
    Button button_addr,button_pos;
    TextView textView_result;
    Geocoder geocoder;
    List<Address> addresses=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_lat=(EditText)findViewById(R.id.editText_lat);
        editText_lng=(EditText)findViewById(R.id.editText_lng);
        editText_pos=(EditText)findViewById(R.id.editText_pos);
        button_addr=(Button)findViewById(R.id.button_find_addr);
        button_pos=(Button)findViewById(R.id.button_find_pos);
        textView_result=(TextView)findViewById(R.id.textView_result);

        geocoder=new Geocoder(MainActivity.this);

        button_addr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lat = editText_lat.getText().toString();
                String lng = editText_lng.getText().toString();

                try{
                    // 위도 경도로 대략적인 주소를 검색하는 함수 getFromLocation() 함수
                    // 검색한 결과를 List<Address> 변수에 저장
                    addresses= geocoder.getFromLocation(Double.parseDouble(lat),Double.parseDouble(lng),5);
                }catch (Exception e){
                    Log.d("Geo",e.getMessage());
                }

                if(addresses.size()==0||addresses==null){
                    textView_result.setText("검색결과가 없습니다.");
                }else{
                    textView_result.setText(addresses.get(0).getCountryName());
                    // 검색 결과에서 특정 정보만 가져오는 함수
                    // getCountryName() 국가번호
                    // getPhone() 전화번호
                    // getPostalCode() 우편번호
                    // getFeatureName() 명칭
                    // getLatitude() 위도
                    // getLongitude() 경도
                }
            }
        });
        button_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr=editText_pos.getText().toString();

                try{
                    //주소로 위도 경도를 얻어올 수 있는 getFromLocationName() 함수
                    // 검색한 결과를 List<address> 변수에 저장
                    addresses=geocoder.getFromLocationName(addr,1);
                }catch (Exception e){}
                if(addresses.size()==0||addresses==null){
                    textView_result.setText("검색결과가 없습니다.");
                }else{
                    textView_result.setText(addresses.get(0).getCountryName());
                    // getPhone() 전화번호
                    // getPostalCode() 우편번호
                    // getFeatureName() 명칭
                    // getLatitude() 위도
                    // getLongitude() 경도
                }
                Toast.makeText(getApplicationContext(),addresses.size()+".",Toast.LENGTH_LONG).show();
            }
        });
    }
}
