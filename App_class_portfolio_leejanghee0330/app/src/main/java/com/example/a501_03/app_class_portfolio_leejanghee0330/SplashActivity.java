package com.example.a501_03.app_class_portfolio_leejanghee0330;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.a501_03.app_class_portfolio_leejanghee0330.db.DaoSession;
import com.example.a501_03.app_class_portfolio_leejanghee0330.db.Place;

import java.util.List;

/**
 * Created by 501-03 on 2018-03-30.
 */

public class SplashActivity extends AppCompatActivity {

    DaoSession daoSession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 앱을 동작하기 위한 준비를 함

        daoSession = ((AppController)getApplication()).getDaoSession();
//        daoSession.insert(new Place(1L,new Date(),new Date(),"청남대",
//                "대통령의 별장","img1.jpg","000-0000"));
//        daoSession.insert(new Place(2L,new Date(),new Date(),"청와대",
//                "대통령의 집","img2.jpg","000-0000"));

        //daoSession.getPlaceDao().queryBuilder().buildDelete();

        List<Place> list = daoSession.getPlaceDao().queryBuilder().list();

        for(int i=0;i<list.size();i++){
            Place temp = list.get(i);
            Log.d("portfolio",temp.getName());
        }

        /*try{
            Thread.sleep(1000);
            Toast.makeText(this,"5초가 지났습니다.",Toast.LENGTH_LONG).show();
        }catch (Exception e){}*/

        Intent intent=new Intent(SplashActivity.this,AddTripActivity.class);
        startActivity(intent);
        finish();
    }
}
