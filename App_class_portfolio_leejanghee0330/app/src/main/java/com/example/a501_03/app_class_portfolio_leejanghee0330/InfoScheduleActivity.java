package com.example.a501_03.app_class_portfolio_leejanghee0330;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 501-03 on 2018-04-05.
 */

public class InfoScheduleActivity extends AppCompatActivity implements WeekView.EventClickListener{

    Toolbar toolbar_infoSchedule;
    WeekView weekView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_schedule);

        setToolbar();

        weekView=(WeekView)findViewById(R.id.weekView);

        weekView.setOnEventClickListener(this);
        MonthLoader.MonthChangeListener monthChangeListener=new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                return new ArrayList<WeekViewEvent>();
            }
        };
        weekView.setMonthChangeListener(monthChangeListener);
    }

    public void onEventClick(WeekViewEvent event, RectF eventRect){}

    private void setToolbar(){
        toolbar_infoSchedule=(Toolbar)findViewById(R.id.toolbar_infoSchedule);
        toolbar_infoSchedule.setTitle("");
        toolbar_infoSchedule.setNavigationIcon(R.mipmap.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar_infoSchedule);
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_goto_add_schedule,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_item_goto_add_trip:
                Intent intent=new Intent(getApplicationContext(),AddTripActivity.class);
                startActivity(intent);
                finish();
        }
        return true;
    }
}
