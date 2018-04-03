package com.example.a501_03.baseadapterexample2_0314;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView_main;
    ArrayList<MyItemFormat> arItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //항목의 객체를 모아놓은 arrayList를 생성
        arItem = new ArrayList<MyItemFormat>();
        //arrayList에 자료 객체를 만들어서 넣음
        arItem.add(new MyItemFormat(R.drawable.img1,R.drawable.img2,"국화","사막"
        ,"50,000","86,690,470,000",4.3,3.2));
        arItem.add(new MyItemFormat(R.drawable.img3,R.drawable.img4,"수국","해파리"
                ,"120,000","4,000",3.8,4.7));
        arItem.add(new MyItemFormat(R.drawable.img5,R.drawable.img6,"코알라","등대"
                ,"17,180,000","233,040,000",1.8,3.0));

        listView_main=(ListView)findViewById(R.id.listview_main);
        listView_main.setAdapter(new MyAdapter(MainActivity.this,arItem,R.layout.listview_my_item));
    }
}
