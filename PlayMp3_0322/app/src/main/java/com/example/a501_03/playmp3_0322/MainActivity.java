package com.example.a501_03.playmp3_0322;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button button_play,button_stop,button_prev,button_next;
    TextView textView_title;
    MediaPlayer player;
    ArrayList<String> mp3_paths;
    int play_index=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_play=(Button)findViewById(R.id.button_start_main);
        button_stop=(Button)findViewById(R.id.button_stop_main);
        button_next=(Button)findViewById(R.id.button_next);
        button_prev=(Button)findViewById(R.id.button_prev);
        textView_title=(TextView)findViewById(R.id.textView_title);

        mp3_paths=findFilebyExtend(".mp3");
        textView_title.setText(mp3_paths.get(0));

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // play_index가 3보다 작은 경우(음악파일 4개 있는 상황)
                // play_index가 3보다 클 경우는 0으로 play_index값을 조정
                play_index=play_index<(mp3_paths.size()-1)?(++play_index):0;
                try{
                    if(player.isPlaying()){
                        player.stop();
                        player.prepare();
                    }
                    player.reset();
                    // 음악 파일의 경로를 MediaPlayer 객체를 생성
                    player.setDataSource(mp3_paths.get(play_index));
                    // 음악 재생을 위한 준비작업을 하는 prepare()함수 호출
                    player.prepare();
                    player.start();
                }catch (Exception e){
                    Log.d("PlayMp3","mp3 file error");
                }

                textView_title.setText(mp3_paths.get(play_index));
            }
        });
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_index=play_index>0?--play_index:(mp3_paths.size()-1);
                try{
                    if(player.isPlaying()){
                        player.stop();
                        player.prepare();
                    }
                    // 음악파일 교체
                    player.reset();
                    // 음악 파일의 경로를 MediaPlayer 객체를 생성
                    player.setDataSource(mp3_paths.get(play_index));
                    // 음악 재생을 위한 준비작업을 하는 prepare()함수 호출
                    player.prepare();
                    player.start();
                }catch (Exception e){
                    Log.d("PlayMp3","mp3 file error");
                }

                textView_title.setText(mp3_paths.get(play_index));
            }
        });
        /*
        // 음악 파일이 저장된 경로를 지정
        String mp3_path= Environment.getExternalStorageDirectory().getAbsolutePath()
                +"/newyorkcity.mp3";
        */
        // 음악 재생을 위한 MediaPlayer 객체를 생성
        player=new MediaPlayer();
        try{
            // 음악 파일의 경로를 MediaPlayer 객체를 생성
            player.setDataSource(mp3_paths.get(play_index));
            // 음악 재생을 위한 준비작업을 하는 prepare()함수 호출
            player.prepare();
        }catch (Exception e){
            Log.d("PlayMp3","mp3 file error");
        }

        //준비 prepare() 일지중지 mediaPlayer.pause() 시작 mediaPlayer.start() 중지mediaPlayer.stop()
        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 음악파일이 재생되는지 확인할 수 있는 isPlaying() 함수로 재생여부를 확인
                if(player.isPlaying()){
                    // 음악 재생을 일지중지 하기 위한 pause() 함수 호출
                    player.pause();
                    button_play.setText("play");
                }else{
                    player.start();
                   /*
                    // 음악 재생을 반복할 경우 setLooping()함수를 활용
                    player.setLooping(true);
                    // 재생한 만큼
                    // 음악 파일을 재생한 길이
                    int pos=player.getCurrentPosition();
                    // 전체 값
                    // 음악 파일의 전체 재생 길이
                    int total=player.getDuration();
                   */
                    button_play.setText("pause");
                }
                Toast.makeText(MainActivity.this,player.getCurrentPosition()/1000+"/"+player.getDuration()/1000,Toast.LENGTH_LONG).show();;
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 음악 재생을 중지한 stop() 함수 호출
                player.stop();
                try {
                    player.prepare();
                } catch (IOException e) {
                    Log.d("PlayMp3","mp3 file error");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(player!=null) {
            // 플레이어를 없애주지 않으면 폰에 계속 켜져있음
            // Mediaplayer 객체를 소멸
            player.release();
            player=null;
        }
    }

    private ArrayList<String> findFilebyExtend(String ext){
        ArrayList<String> temp_array=new ArrayList<String>();
        final String file_ext=ext;

        // SD카드를 인식되어 있는지 확인한다
        // 인식이 된 경우에는 getExternalStorageState() 함수가 Environment.MEDIA_MOUNT 값을 리턴턴
        String state= Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            // sd카드 폴더의 주소를 가져옴
            String sd_path=Environment.getExternalStorageDirectory()
                    .getAbsolutePath()+"/Music";

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
            for(int i=0;i<jpg_list.length;i++){
                temp_array.add(sd_path+"/"+jpg_list[i]);
            }
            return temp_array;
        }else{
            Toast.makeText(MainActivity.this,"SD카드 인식이 안됨",Toast.LENGTH_LONG).show();
            return null;
        }
    }
}
