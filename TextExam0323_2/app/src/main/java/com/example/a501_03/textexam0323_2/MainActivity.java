package com.example.a501_03.textexam0323_2;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button button_start, button_stop, button_next, button_prev;
    TextView textView;
    ListView listView_music;
    ProgressBar progressBar;
    MediaPlayer player;
    String[] musicList;
    ArrayList<String> file_paths;
    ArrayAdapter<String> arrayAdapter;
    int music_index = 0;
    int musicProgressVal;
    int valMax = 0;
    MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start = (Button) findViewById(R.id.button_start);
        button_stop = (Button) findViewById(R.id.button_stop);
        button_next = (Button) findViewById(R.id.button_next);
        button_prev = (Button) findViewById(R.id.button_prev);
        textView = (TextView) findViewById(R.id.textView);
        listView_music = (ListView) findViewById(R.id.listview_music);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        player = new MediaPlayer();
        file_paths = findFileByExtend(".mp3");

        try {
            player.setDataSource(file_paths.get(0));
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try{
//            if(file_paths == null){  //음악 파일의 경로를 읽어올 때 에러가 난 경우
//                Log.d("MediaPlayer","music path list is null");
//                throw new Exception();
//            }else if(file_paths.size()==0){  // mp3 파일이 없는 경우
//                Log.d("MediaPlayer","music path list is empty");
//                throw new Exception();
//            }else{  // 찾은 mp3 파일에서 첫번째 파일을 재생할 준비
//                player.setDataSource(file_paths.get(music_index));
//                player.prepare();
//            }
//        }catch (Exception e){
//            Log.d("Mediaplayer",e.getMessage());
//        }
//        player.prepareAsync();
        progressBar.setMax(player.getDuration() / 1000);
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_single_choice, musicList);
        listView_music.setAdapter(arrayAdapter);
        listView_music.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                music_index = position;
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                if (player.isPlaying()) {
                    player.stop();
                    player.reset();
                    try {
                        player.setDataSource(file_paths.get(music_index));
                        player.prepare();
                        player.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    button_start.setText("pause");
                    textView.setText(musicList[music_index]);
                } else {
                    player.reset();
                    try {
                        player.setDataSource(file_paths.get(music_index));
                        player.prepare();
                        player.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    textView.setText(musicList[music_index]);
                    button_start.setText("pause");
                }
                progressBar.setMax(player.getDuration() / 1000);
                progressBar.setProgress(player.getCurrentPosition() / 1000);
            }
        });

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!player.isPlaying()) {
                    myAsyncTask = new MyAsyncTask();
                    myAsyncTask.execute();
                    textView.setText(musicList[music_index]);
                    player.start();
                    button_start.setText("pause");
                    progressBar.setMax(player.getDuration() / 1000);
                    progressBar.setProgress(player.getCurrentPosition() / 1000);
                } else {
                    myAsyncTask.cancel(true);
                    myAsyncTask = null;
                    player.pause();
                    button_start.setText("start");
                }
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask.cancel(true);
                myAsyncTask = null;
                if (player.isPlaying()) {
                    player.stop();
                    button_start.setText("start");
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                music_index = music_index < (file_paths.size() - 1) ? ++music_index : 0;
                try {
                    if (player.isPlaying()) {
                        player.stop();
                        player.prepare();
                    }
                    textView.setText(musicList[music_index]);
                    button_start.setText("pause");
                    player.reset();
                    player.setDataSource(file_paths.get(music_index));
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                progressBar.setMax(player.getDuration() / 1000);
                progressBar.setProgress(player.getCurrentPosition() / 1000);

            }
        });
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                music_index = music_index > 0 ? --music_index : (file_paths.size() - 1);
                try {
                    if (player.isPlaying()) {
                        player.stop();
                        player.prepare();
                    }
                    textView.setText(musicList[music_index]);
                    button_start.setText("pause");
                    player.reset();
                    player.setDataSource(file_paths.get(music_index));
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                progressBar.setMax(player.getDuration() / 1000);
                progressBar.setProgress(player.getCurrentPosition() / 1000);
            }
        });


    }

    private ArrayList<String> findFileByExtend(String ext) {
        final String file_ext = ext;
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            String sd_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music";
            File musicFiles = new File(sd_path);
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(file_ext);
                }
            };
            musicList = musicFiles.list(filter);
            Arrays.sort(musicList);
            ArrayList<String> temparr = new ArrayList<String>();
            for (int i = 0; i < musicList.length; i++) {
                temparr.add(sd_path + "/" + musicList[i]);
            }
            return temparr;
        } else {
            Toast.makeText(MainActivity.this, "저장소가 없습니다", Toast.LENGTH_LONG).show();
            return null;
        }

    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            musicProgressVal = 0;
            progressBar.setProgress(0);
            valMax = player.getDuration() / 1000;
            progressBar.setMax(valMax);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            music_index = music_index < (file_paths.size() - 1) ? ++music_index : 0;
            try {
                textView.setText(musicList[music_index]);
                player.reset();
                player.setDataSource(file_paths.get(music_index));
                player.prepare();
                player.start();
                myAsyncTask = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            musicProgressVal = player.getCurrentPosition() / 1000;
            progressBar.setProgress(musicProgressVal);
        }

        @Override
        protected void onCancelled() {
            myAsyncTask = null;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                if (musicProgressVal == valMax) {
                    publishProgress();
                    break;
                }
                try {
                    publishProgress();
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            return null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myAsyncTask != null) {
            myAsyncTask.cancel(true);
            myAsyncTask = null;
        }
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
