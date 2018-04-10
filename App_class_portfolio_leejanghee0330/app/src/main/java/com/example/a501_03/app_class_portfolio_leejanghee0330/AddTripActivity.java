package com.example.a501_03.app_class_portfolio_leejanghee0330;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.a501_03.app_class_portfolio_leejanghee0330.db.DaoSession;
import com.example.a501_03.app_class_portfolio_leejanghee0330.db.PortfolioQuery;
import com.example.a501_03.app_class_portfolio_leejanghee0330.db.travel;

import java.util.Date;
import java.util.List;

/**
 * Created by 501-03 on 2018-04-03.
 */

public class AddTripActivity extends AppCompatActivity {
    Toolbar toolbar_addTrip;
    EditText editText_addTrip_title,editText_addTrip_startDay,editText_addTrip_endDay,editText_addTrip_money,editText_addTrip_member;
    Button button_addTrip_minus,button_addTrip_plus;
    int start_year,start_month,start_day,end_year,end_month,end_day;
    int number_of_member=1;
    DaoSession daoSession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        daoSession = ((AppController)getApplication()).getDaoSession();
        setToolbar();

        setComponents();
    }

    private void setComponents(){
        editText_addTrip_title=(EditText)findViewById(R.id.editText_title_addTrip);
        editText_addTrip_startDay=(EditText)findViewById(R.id.editText_startDay_addTrip);
        editText_addTrip_endDay=(EditText)findViewById(R.id.editText_endDay_addTrip);
        editText_addTrip_money=(EditText)findViewById(R.id.editText_money_addTrip);
        editText_addTrip_member=(EditText)findViewById(R.id.editText_personNum_addTrip);
        button_addTrip_minus=(Button)findViewById(R.id.button_minus_addTrip);
        button_addTrip_plus=(Button)findViewById(R.id.button_plus_addTrip);

        // 키보드 안나타나는 설정
        editText_addTrip_startDay.setInputType(InputType.TYPE_NULL);
        editText_addTrip_startDay.setFocusable(false);
        editText_addTrip_endDay.setInputType(InputType.TYPE_NULL);
        editText_addTrip_endDay.setFocusable(false);

        editText_addTrip_startDay.setOnClickListener(new AddTripListener());
        editText_addTrip_endDay.setOnClickListener(new AddTripListener());

        button_addTrip_minus.setOnClickListener(new AddTripListener());
        button_addTrip_plus.setOnClickListener(new AddTripListener());
    }

    class AddTripListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.editText_startDay_addTrip:
                    new DatePickerDialog(AddTripActivity.this,dateSetListener,2018,4,10).show();
                    break;
                case R.id.editText_endDay_addTrip:
                    new DatePickerDialog(AddTripActivity.this,dateSetListener2,2018,4,10).show();
                    break;
                case R.id.button_plus_addTrip:
                    number_of_member++;
                    editText_addTrip_member.setText(number_of_member+"명");
                    break;
                case R.id.button_minus_addTrip:
                    number_of_member--;
                    if(number_of_member==0){
                        number_of_member=1;
                    }
                    editText_addTrip_member.setText(number_of_member+"명");
                    break;
            }
        }
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    start_year=year;
                    start_month=month+1;
                    start_day=dayOfMonth;
                    Log.d("my_select_date",year+"년"+month+"월"+dayOfMonth+"일");
                }
            };

    private DatePickerDialog.OnDateSetListener dateSetListener2 =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    end_year=year;
                    end_month=month+1;
                    end_day=dayOfMonth;
                    Log.d("my_select_date",year+"년"+month+"월"+dayOfMonth+"일");
                }
            };

    private void setToolbar(){
        toolbar_addTrip=(Toolbar)findViewById(R.id.toolbar_addTrip);
        toolbar_addTrip.setTitle("");
        toolbar_addTrip.setNavigationIcon(R.mipmap.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar_addTrip);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_trip,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_item_add_trip:
                PortfolioQuery.insertTrip(daoSession,editText_addTrip_title.getText().toString(),
                        new Date(start_year,start_month,start_day),new Date(end_year,end_month,end_day),
                        number_of_member,Long.valueOf(editText_addTrip_money.getText().toString()));

                List<travel> test=daoSession.getTravelDao().queryBuilder().list();
                for(int i=0;i<test.size();i++){
                    String msg="trip - "+
                            "id : "+test.get(i).getId()+" / "+
                            "title : "+test.get(i).getTitle()+" / "+
                            "start_date : "+test.get(i).getStart_day()+" / "+
                            "end_date : "+test.get(i).getEnd_day()+" / "+
                            "number_of_member : "+test.get(i).getNumber_of_member()+" / "+
                            "total_money : "+test.get(i).getTotal_money()+" / "+
                            "created_at : "+test.get(i).getCreated_at()+" / "+
                            "updated_at : "+test.get(i).getUpdated_at()+" / ";
                    Log.d("DB_input Test", msg);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
