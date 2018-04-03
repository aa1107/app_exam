package com.example.a501_03.viewexample0316;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 스크롤 뷰 안에 배치된 라이너레이아웃의 객체를 만듬
    LinearLayout linearLayout_main;
    ArrayList<DataFormat> arrayList;
    final int DATA_TYPE_IS_STRING=0;
    final int DATA_TYPE_IS_IMG_ID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linearLayout_main=(LinearLayout)findViewById(R.id.linearlayout_main);
        arrayList = new ArrayList<DataFormat>();
        arrayList.add(new DataFormat("My String1"));
        arrayList.add(new DataFormat(R.drawable.black));
        arrayList.add(new DataFormat("My String2"));
        arrayList.add(new DataFormat(R.drawable.goonghap));
        arrayList.add(new DataFormat("My String3"));
        arrayList.add(new DataFormat(R.drawable.little));

        Display display=getWindowManager().getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        for(int i=0;i<arrayList.size();i++){
            DataFormat temp = arrayList.get(i);
            switch (temp.type){
                case DATA_TYPE_IS_STRING:
                    TextView textView=new TextView(MainActivity.this);
                    textView.setText(temp.text);
                    textView.setTextSize(20);
                    linearLayout_main.addView(textView);
                    break;
                case DATA_TYPE_IS_IMG_ID:
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setImageResource(temp.img_id);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(600,600));
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout_main.addView(imageView);
                    break;
            }
        }
    }

    // 자바는 접근지정자를 두지않으면 자동적으로 private
    class DataFormat{
        int img_id;
        String text;
        int type;

        public DataFormat(int img_id) {
            type=DATA_TYPE_IS_IMG_ID;
            this.img_id = img_id;
            this.text = null;
        }

        public DataFormat(String text) {
            type=DATA_TYPE_IS_STRING;
            this.img_id=-1;
            this.text = text;
        }

        public DataFormat(int img_id, String text) {
            type=2;
            this.img_id = img_id;
            this.text = text;
        }

        public int showType(){
            return type;
        }
    }
}
