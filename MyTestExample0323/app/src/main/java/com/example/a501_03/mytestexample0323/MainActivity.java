package com.example.a501_03.mytestexample0323;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button_start,button_stop,button_prev,button_next;
    TextView textView_time;
    EditText editText_sec,editText_min;
    ProgressBar progressBar_main;
    MediaPlayer player;
    MyAsyncTask myAsyncTask;
    ArrayList<String> filePaths;
    int play_index=0;
    int progressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_time=(TextView)findViewById(R.id.textView_time_main);
        button_next=(Button)findViewById(R.id.button_next_main);
        button_prev=(Button)findViewById(R.id.button_prev_main);
        button_start=(Button)findViewById(R.id.button_start_main);
        button_stop=(Button)findViewById(R.id.button_stop_main);
        editText_min=(EditText)findViewById(R.id.editText_min_main);
        editText_sec=(EditText)findViewById(R.id.editText_sec_main);

        player=new MediaPlayer();
        filePaths=findFileByExtend(".mp3");

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!player.isPlaying()){
                    try{
                        player.start();
                        button_start.setText("pause");
                    }catch (Exception e){}
                }else{
                    player.pause();
                    button_start.setText("start");
                }
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying()){
                    player.stop();
                }
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_index=play_index<(filePaths.size()-1)?++play_index:0;
                if(player.isPlaying()){
                    player.stop();
                }
                try {
                    player.reset();
                    player.setDataSource(filePaths.get(play_index));
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                button_start.setText("pause");
            }
        });
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_index=play_index>0?--play_index:(filePaths.size()-1);
                if(player.isPlaying()){
                    player.stop();
                }
                try {
                    player.reset();
                    player.setDataSource(filePaths.get(play_index));
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                button_start.setText("pause");
            }
        });

        try {
            player.setDataSource(filePaths.get(0));
            player.prepare();
        } catch (IOException e) {}
    }

    class MyAsyncTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            progressBar_main.setMax(player.getDuration()/1000);
            progressValue=player.getCurrentPosition()/1000;
            progressBar_main.setProgress(0);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressBar_main.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            progressValue=player.getCurrentPosition()/1000;
            progressBar_main.setProgress(progressValue);
        }

        @Override
        protected void onCancelled() {

        }

        @Override
        protected Void doInBackground(Void... voids) {
            while(true){
                try{
                    Thread.sleep(1000);
                    publishProgress();
                }catch (Exception e){}
                if(progressValue==player.getDuration()/1000)break;
            }
            return null;
        }
    }

    private ArrayList<String> findFileByExtend(String ext){
        String state=Environment.getExternalStorageState();
        final String file_ext=ext;
        if(state.equals(Environment.MEDIA_MOUNTED)){
            String sd_path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music";
            FilenameFilter filter=new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(file_ext);
                }
            };
            File root=new File(sd_path);
            String[] fileList=root.list(filter);
            ArrayList<String> temparr=new ArrayList<String>();
            for(int i=0;i<fileList.length;i++){
                temparr.add(sd_path+"/"+fileList[i]);
            }
            return temparr;
        }else{
            Toast.makeText(MainActivity.this,"외부파일이 없습니다",Toast.LENGTH_LONG).show();
            return null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(player!=null){
            player.release();
            player=null;
        }
    }
}
