package com.example.a501_03.activityexam;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by 501-03 on 2018-02-27.
 */

public class SecondActivity extends AppCompatActivity {
    VideoView videoView_second;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        videoView_second = (VideoView)findViewById(R.id.videoView_second);
        String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.keyboard10822;
        Uri uri = Uri.parse(uriPath);
        videoView_second.setVideoURI(uri);

        final MediaController mediaController = new MediaController(this);
        videoView_second.setMediaController(mediaController);
    }
}
