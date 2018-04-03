package com.example.a501_03.scrollviewexample0316;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView_main;
    LinearLayout linearLayout_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //컴포넌트 객체 만들기
        scrollView_main=(ScrollView)findViewById(R.id.scrollView_main);
        linearLayout_main=(LinearLayout)findViewById(R.id.linearlayout_main);

        //스크롤뷰 안의 라이너 레이아웃에 추가할 자료 준비하기
        int[] imgId={R.drawable.black,R.drawable.goonghap,R.drawable.little,R.drawable.meetnow,R.drawable.monday};

        // Display객체는 앱 실행시 자동으로 만들어짐 디바이스 화면 정보를 가져옴
        // 화면 사이즈 구하는 함수
        Display display = getWindowManager().getDefaultDisplay();
        // 화면의 좌표를 가져오기 위한 Point 변수를 만듬
        Point point = new Point();
        // 화면의 좌표 정보를 가져오는 getSize()함수, point 객체에 정보가 저장됨
        display.getSize(point);
        int width=point.x;
        int height=point.y;

        // 동적으로 뷰를 생성
        for(int cnt=0;cnt<imgId.length;cnt++){
            ImageView temp = new ImageView(MainActivity.this);
            temp.setImageResource(imgId[cnt]);
            temp.setLayoutParams(new LinearLayout.LayoutParams(width,height));
            temp.setScaleType(ImageView.ScaleType.FIT_XY);


            // 라이너 레이아웃 안에 동적으로 만든 이미지 뷰를 추가가
           linearLayout_main.addView(temp);
        }
    }
}
