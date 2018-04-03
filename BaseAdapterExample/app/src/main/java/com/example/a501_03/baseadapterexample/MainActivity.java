package com.example.a501_03.baseadapterexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item_dataFormat> arrayList;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Item_dataFormat>();
        arrayList.add(new Item_dataFormat(R.drawable.ic_launcher_foreground,"갤럭시","삼성"));
        arrayList.add(new Item_dataFormat(R.drawable.ic_launcher_background,"아이폰","애플"));
        arrayList.add(new Item_dataFormat(R.drawable.ic_launcher_foreground,"픽셀","구글"));

        ListView listView=(ListView)findViewById(R.id.listview_main);
        listView.setAdapter(new MyItemAdapter(arrayList,this,R.layout.listview_item));
    }
    // 항목에 표현할 자료들을 저장하는 객체의 클래스
    class Item_dataFormat{
        int img;
        String title;
        String subTitle;

        public Item_dataFormat(int img, String title, String subTitle) {
            this.img = img;
            this.title = title;
            this.subTitle = subTitle;
        }
    }

}
