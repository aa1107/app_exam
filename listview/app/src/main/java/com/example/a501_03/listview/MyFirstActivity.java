package com.example.a501_03.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 501-03 on 2018-02-28.
 */

public class MyFirstActivity extends AppCompatActivity {

    String[] movie_name;
    String[] movie_pop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfirst);

        movie_name = getResources().getStringArray(R.array.movie_title);
        movie_pop = getResources().getStringArray(R.array.movie_title_explain);

        ArrayAdapter arrayAdapter= ArrayAdapter.createFromResource(MyFirstActivity.this,
                R.array.movie_title,android.R.layout.simple_list_item_1);

        ListView listView = (ListView)findViewById(R.id.listview_myfirst);
        listView.setAdapter(arrayAdapter);


    }
}
