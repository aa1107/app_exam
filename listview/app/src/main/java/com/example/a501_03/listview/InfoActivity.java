package com.example.a501_03.listview;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by 501-03 on 2018-02-28.
 */

public class InfoActivity extends AppCompatActivity {

    LinearLayout linearLayout_main;
    int[] img_id;
    TypedArray photo_little,photo_monday,photo_goong,photo_black;
    String[] movie_tit, movie_actor, movie_type, movie_director, photo_package;
    TypedArray movie_img;
    TextView textView_title,textView_director_actor,textView_type;
    ImageView imgView_poster;
    Button btn_admit;
    Intent itt;
    VideoView videoView;
    int movie_index;
    Uri uri;
    String uriPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        linearLayout_main=(LinearLayout)findViewById(R.id.linearlayout_info);
        photo_black=getResources().obtainTypedArray(R.array.photo_black);
        photo_goong=getResources().obtainTypedArray(R.array.photo_goong);
        photo_monday=getResources().obtainTypedArray(R.array.photo_monday);
        photo_little=getResources().obtainTypedArray(R.array.photo_little);

        photo_package=getResources().getStringArray(R.array.photo_packge);

        Intent intent = getIntent();
        Display display=getWindowManager().getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        int width=point.x;
        int height=point.y;

        movie_index = intent.getIntExtra("movie_index",-1);
        switch (movie_index){
            case 0:
                uriPath = "android.resource://"+getPackageName()+"/"+R.raw.black;
                uri= Uri.parse(uriPath);
                String temp_str=photo_package[movie_index];
                String[] split_str;
                split_str = temp_str.split("/");

                for(int i=0;i<split_str.length;i++){
                    String file_name="@drawable/"+split_str[i];
                    int img_id=getResources().getIdentifier(file_name,"drawable",this.getPackageName());
                    ImageView temp=new ImageView(getApplicationContext());
                    temp.setImageResource(img_id);
                    temp.setLayoutParams(new LinearLayout.LayoutParams(width,720));
                    temp.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout_main.addView(temp);
                }

                /*for(int i=0;i<photo_black.length();i++){+
                    ImageView temp=new ImageView(getApplicationContext());
                    temp.setImageResource(photo_black.getResourceId(i,-1));
                    temp.setLayoutParams(new LinearLayout.LayoutParams(width,720));
                    temp.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout_main.addView(temp);
                }*/
                break;
            case 1:
                uriPath = "android.resource://"+getPackageName()+"/"+R.raw.goonghap;
                uri= Uri.parse(uriPath);
                for(int i=0;i<photo_goong.length();i++){
                    ImageView temp=new ImageView(getApplicationContext());
                    temp.setImageResource(photo_goong.getResourceId(i,-1));
                    temp.setLayoutParams(new LinearLayout.LayoutParams(width,720));
                    temp.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout_main.addView(temp);
                }
                break;
            case 2:
                uriPath = "android.resource://"+getPackageName()+"/"+R.raw.little;
                uri= Uri.parse(uriPath);
                for(int i=0;i<photo_monday.length();i++){
                    ImageView temp=new ImageView(getApplicationContext());
                    temp.setImageResource(photo_monday.getResourceId(i,-1));
                    temp.setLayoutParams(new LinearLayout.LayoutParams(width,720));
                    temp.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout_main.addView(temp);
                }
                break;
            case 3:
                uriPath = "android.resource://"+getPackageName()+"/"+R.raw.mon;
                uri= Uri.parse(uriPath);
                for(int i=0;i<photo_little.length();i++){
                    ImageView temp=new ImageView(getApplicationContext());
                    temp.setImageResource(photo_little.getResourceId(i,-1));
                    temp.setLayoutParams(new LinearLayout.LayoutParams(width,720));
                    temp.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout_main.addView(temp);
                }
                break;
        }

//        Display display=getWindowManager().getDefaultDisplay();
//        Point point=new Point();
//        display.getSize(point);
//        int width=point.x;
//        int height=point.y;
//
//        linearLayout_main=(LinearLayout)findViewById(R.id.linearlayout_info);
//        img_id= new int[]{R.drawable.owl, R.drawable.rose, R.drawable.bitcoin};
//        for(int i=0;i<img_id.length;i++){
//            ImageView temp=new ImageView(getApplicationContext());
//            temp.setImageResource(img_id[i]);
//            temp.setLayoutParams(new LinearLayout.LayoutParams(width,240));
//            temp.setScaleType(ImageView.ScaleType.FIT_XY);
//            linearLayout_main.addView(temp);
//        }

        movie_tit = getResources().getStringArray(R.array.movie_tit);
        movie_actor = getResources().getStringArray(R.array.movie_actor);
        movie_type = getResources().getStringArray(R.array.movie_type);
        movie_director = getResources().getStringArray(R.array.movie_director);
        movie_img= getResources().obtainTypedArray(R.array.movie_img);

        if(movie_index != -1){
            Toast.makeText(InfoActivity.this,movie_tit[movie_index]+"/"+movie_actor[movie_index]
                    +"/"+movie_type[movie_index]+"/"+movie_director[movie_index],Toast.LENGTH_LONG).show();
        }

        // 2. 컴포넌트의 객체 만들기
        textView_title=(TextView)findViewById(R.id.textView_title);
        textView_director_actor=(TextView)findViewById(R.id.textView_director_actor);
        textView_type=(TextView)findViewById(R.id.textView_type);
        imgView_poster=(ImageView)findViewById(R.id.imageView_poster_myitem);
        btn_admit=(Button)findViewById(R.id.btn_admit);
        videoView=(VideoView)findViewById(R.id.info_videoView);
        final MediaController mediaController=new MediaController(this);

        // 3. 데이터를 컴포넌트에 적용
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);

        btn_admit.setOnClickListener(new MyAdmitBtnListener());
        if(movie_index !=-1){
            textView_title.setText(movie_tit[movie_index]);
            textView_director_actor.setText("배우:"+movie_actor[movie_index]+"/감독:"+movie_director[movie_index]);
            textView_type.setText(movie_type[movie_index]);
//            imgView_poster.setImageResource(R.drawable.ic_launcher_background);
            imgView_poster.setImageResource(movie_img.getResourceId(movie_index,-1));
            /*switch(movie_index){
                case 0:
                    imgView_poster.setImageResource(R.drawable.bitcoin);
                    break;
                case 1:
                    imgView_poster.setImageResource(R.drawable.composing);
                    break;
                case 2:
                    imgView_poster.setImageResource(R.drawable.owl);
                    break;
                case 3:
                    imgView_poster.setImageResource(R.drawable.rose);
                    break;
            }*/
        }
    }

    class MyAdmitBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            itt=new Intent(InfoActivity.this,Info2Activity.class);
            itt.putExtra("movie_index",movie_index);
            startActivityForResult(itt,2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 2:
                if(resultCode==RESULT_OK){
                    Toast.makeText(InfoActivity.this,data.getStringExtra("예매"),Toast.LENGTH_LONG).show();
                }else if(resultCode==RESULT_CANCELED){
                    Toast.makeText(InfoActivity.this,data.getStringExtra("취소"),Toast.LENGTH_LONG).show();
                }
                break;
            }


    }
}
