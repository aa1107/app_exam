package com.example.a501_03.activityexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

/**
 * Created by 501-03 on 2018-02-27.
 */

public class FirstActivity extends AppCompatActivity {
    VideoView videoView_first;
    Button btn_first_to_main;
    RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // 3. 화면 전환 후 이전 액티비티에서 보낸 인텐트를 수신
        Intent intent = getIntent();

        // 4. 인텐트 안에서 데이터를 읽음
        String text = intent.getStringExtra("MainToFirst");
        int temp_number = intent.getIntExtra("MainToFirst_number", -1);

        /*if(text != null){
            Toast.makeText(FirstActivity.this,Integer.toString(temp_number),Toast.LENGTH_LONG).show();
        }*/

        videoView_first = (VideoView)findViewById(R.id.videoView_first);
        String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.racingbike7251;
        Uri uri = Uri.parse(uriPath);
        videoView_first.setVideoURI(uri);

        final MediaController mediaController = new MediaController(this);
        videoView_first.setMediaController(mediaController);

        btn_first_to_main = (Button)findViewById(R.id.btn_first_to_main);
        FirstToMainListener firstToMainListener = new FirstToMainListener();
        btn_first_to_main.setOnClickListener(firstToMainListener);
//        btn_first_to_main.setOnClickListener();

        ratingBar = (RatingBar)findViewById(R.id.ratingBar_first);
        RatingListener ratingListener = new RatingListener();
        ratingBar.setOnRatingBarChangeListener(ratingListener);
    }

    // 6. 인텐트에 포함된 처리 후 데이터를 처리하는 함수
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    Toast.makeText(FirstActivity.this,
                            data.getStringExtra("MainToFirst"),
                            Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    class RatingListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            Toast.makeText(FirstActivity.this,Float.toString(v),Toast.LENGTH_LONG).show();
        }
    }

    class FirstToMainListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            //5. 수신한 데이터를 처리 후 이전 액티비티에 보내기 위한 인텐트 생성하고 처리 데이터를 보고
            Intent intent2 = new Intent();
            intent2.putExtra("FirstToMain","퍼스트에서 메인에게 전달하는 데이터");
            setResult(RESULT_OK, intent2);

            // 현재 화면을 제거하는 함수
            finish();
        }
    }


}
