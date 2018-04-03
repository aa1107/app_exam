package com.example.a501_03.sdcardexample0321;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button button_findImg,button_findMusic;
    TextView textView_main;
    LinearLayout linearLayout_main;
    ArrayList<String> img_array, music_array;
    ImageView imageView_main;
    TypedArray typedArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_findImg=(Button)findViewById(R.id.button_findimg_main);
        button_findMusic=(Button)findViewById(R.id.button_findmusic_main);
        textView_main=(TextView)findViewById(R.id.textview_main);
//        imageView_main=(ImageView)findViewById(R.id.imageView2);
        linearLayout_main=(LinearLayout)findViewById(R.id.linearlayout_main);
        typedArray=getResources().obtainTypedArray(R.array.movietitle);

//        typedArray.getResourceId(0,-1);

        button_findImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_array=findFilebyExtend(".jpg");
                String strtemp="";
                for(int i=0,j=0;i<img_array.size();i++,j++){
                    strtemp+=img_array.get(i)+"\n";
                    File img_file=new File(img_array.get(i));
                    BitmapFactory.Options options= new BitmapFactory.Options();
                    // 배수로 정하는게(2,4,8,16) 효율이 좋다고함 줄여준 다음 맞추는게 빠름
                    options.inSampleSize=2;
                    Bitmap bitmap= BitmapFactory.decodeFile(img_file.getAbsolutePath(),options);
//                    Bitmap bitmap2= BitmapFactory.decodeFile(img_file.getAbsolutePath());
                    Bitmap bitmap_resize=Bitmap.createScaledBitmap(bitmap,800,800,true);
                    ImageView imageView1=new ImageView(MainActivity.this);
                    imageView1.setImageResource(typedArray.getResourceId(i,-1));
                    Display display=getWindowManager().getDefaultDisplay();
                    Point point=new Point();
                    display.getSize(point);
//                    imageView1.setImageBitmap(bitmap_resize);
                    imageView1.setLayoutParams(new LinearLayout.LayoutParams(point.x,700));
                    imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearLayout_main.addView(imageView1);
                }
                textView_main.setText(strtemp);

//                BitmapFactory.Options options=new BitmapFactory.Options();
//                // 배수로 정하는게(2,4,8,16) 효율이 좋다고함 줄여준 다음 맞추는게 빠름
//                options.inSampleSize=4;
//
//                // 경로로부터 파일을 읽어옴(그냥 파일)
//                File img_file=new File(img_array.get(0));
//                // Bitmap은 그림파일
//                // 파일을 이미지 파일로 변환 (이미지 파일)
//                Bitmap bitmap2= BitmapFactory.decodeFile(img_file.getAbsolutePath());
//                Bitmap bitmap= BitmapFactory.decodeFile(img_file.getAbsolutePath(),options);
//
//                // 이미지 사이즈를 40*20으로 맞춤
//                Bitmap bitmap_resize=Bitmap.createScaledBitmap(bitmap,800,800,true);
//                // 이미지 뷰에 이미지 파일 적용
//                imageView_main.setImageBitmap(bitmap_resize);

            }
        });
        /*button_findMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state1= Environment.getExternalStorageState();
                if(state1.equals(Environment.MEDIA_MOUNTED)){
                    // sd카드 폴더의 주소를 가져옴
                    String sd_path1=Environment.getExternalStorageDirectory()
                            .getAbsolutePath();

                    // 찾고자 하는 파일의 확장자를 검색해주는 필터 객체를 생성
                    FilenameFilter filter=new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".mp3");
                        }
                    };

                    // 파일 필터 객체를 활용하여 파일을 검색
                    File sdRoot=new File(sd_path1);
                    String[] jpg_list=sdRoot.list(filter);

                    // 검색한 파일 리스트를 출력
                    String temp="";
                    for(int i=0;i<jpg_list.length;i++){
                        temp += jpg_list[i]+"\n";
                    }
                    textView_main.setText(temp);

                }else{
                    Toast.makeText(MainActivity.this,"SD카드 인식이 안됨",Toast.LENGTH_LONG).show();
                }
            }
        });
        button_findImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SD카드를 인식되어 있는지 확인한다
                // 인식이 된 경우에는 getExternalStorageState() 함수가 Environment.MEDIA_MOUNT 값을 리턴턴
                String state= Environment.getExternalStorageState();
                if(state.equals(Environment.MEDIA_MOUNTED)){
                    // sd카드 폴더의 주소를 가져옴
                    String sd_path=Environment.getExternalStorageDirectory()
                            .getAbsolutePath();

                    // 찾고자 하는 파일의 확장자를 검색해주는 필터 객체를 생성
                    FilenameFilter filter=new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".jpg");
                        }
                    };

                    // 파일 필터 객체를 활용하여 파일을 검색
                    File sdRoot=new File(sd_path);sdRoot.listFiles(filter).
                    String[] jpg_list=sdRoot.list(filter);

                    // 검색한 파일 리스트를 출력
                    String temp="";
                    for(int i=0;i<jpg_list.length;i++){
                        temp += jpg_list[i]+"\n";
                        ImageView imageView=new ImageView(MainActivity.this);
                        imageView.setImageResource(jpg_list[i]);
                    }
                    textView_main.setText(temp);

                }else{
                    Toast.makeText(MainActivity.this,"SD카드 인식이 안됨",Toast.LENGTH_LONG).show();
                }
            }
        });*/


    }
    private ArrayList<String> findFilebyExtend(String ext){
        ArrayList<String> temp_array=new ArrayList<String>();
        final String file_ext=ext;

        // SD카드를 인식되어 있는지 확인한다
        // 인식이 된 경우에는 getExternalStorageState() 함수가 Environment.MEDIA_MOUNT 값을 리턴
        String state= Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            // sd카드 폴더의 주소를 가져옴
            String sd_path=Environment.getExternalStorageDirectory()
                    .getAbsolutePath();

            // 찾고자 하는 파일의 확장자를 검색해주는 필터 객체를 생성
            FilenameFilter filter=new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(file_ext);
                }
            };

            // 파일 필터 객체를 활용하여 파일을 검색
            File sdRoot=new File(sd_path);
                    String[] jpg_list=sdRoot.list(filter);
            Arrays.sort(jpg_list);

            // 검색한 파일 리스트를 출력
            String temp="";
            for(int i=0;i<jpg_list.length;i++){
                temp += jpg_list[i]+"\n";
                temp_array.add(sd_path+"/"+jpg_list[i]);
            }
            return temp_array;
        }else{
            Toast.makeText(MainActivity.this,"SD카드 인식이 안됨",Toast.LENGTH_LONG).show();
            return null;
        }
    }

}
