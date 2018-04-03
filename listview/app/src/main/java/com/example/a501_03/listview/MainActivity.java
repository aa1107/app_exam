package com.example.a501_03.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
/*
    String[] list_explain = {
            "조선시대의 장군", "고구려 19대 왕","조선시대 화가이자 문인","조선왕조 4대 왕"
    };
 */
//    String[] file_explain;
//    String[] file_great;
    Toolbar toolbar_main;
    String[] movie;
    Button btnToMain;
    Intent intent;
    String[] myMovieName,myMovieActor,myMovieType,myMovieDate;
    int[] myMoviePosterArr;
    double[] myMovieRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Toast.makeText(MainActivity.this,getPackageName(),Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMoviePosterArr= new int[]{R.drawable.black, R.drawable.goonghap, R.drawable.monday, R.drawable.little};
        myMovieName=getResources().getStringArray(R.array.movie_tit);
        myMovieActor=getResources().getStringArray(R.array.movie_actor);
        myMovieType=getResources().getStringArray(R.array.movie_type);
        myMovieDate=getResources().getStringArray(R.array.mymovie_date);
        myMovieRating=new double[]{4.2,4.0,4.3,3.9};

        toolbar_main=(Toolbar)findViewById(R.id.toolbar_main);
        toolbar_main.setTitle("Creative");
        setSupportActionBar(toolbar_main);

        ArrayList<MyItemData> arrayList = new ArrayList<MyItemData>();
        for(int i=0;i<4;i++){
            arrayList.add(new MyItemData(myMoviePosterArr[i],myMovieName[i],
                    myMovieActor[i],myMovieType[i],myMovieDate[i],myMovieRating[i]));
        }

        ListView listView=(ListView)findViewById(R.id.listView_greatman);
        listView.setAdapter(new MyMovieAdapter(MainActivity.this,arrayList,R.layout.listview_myitem1));
        listView.setOnItemClickListener(new MyItemListener());
        /*Toast.makeText(getApplicationContext(),"안녕",Toast.LENGTH_LONG).show();
        // 1. 컴포넌트 배치 후 ID 부여하기
        // 2. 데이터 생성하기
        movie = getResources().getStringArray(R.array.movie_tit);
        btnToMain=findViewById(R.id.btnToJoin_main);
    *//*    file_explain = getResources().getStringArray(R.array.great_man_explain);
        file_great = getResources().getStringArray(R.array.great_man);*//*
    */    String[] list = {"이순신", "광개토대왕", "신사임당", "세종대왕",
                "이순신", "광개토대왕", "신사임당", "세종대왕",
                "이순신", "광개토대왕", "신사임당", "세종대왕",
                "이순신", "광개토대왕", "신사임당", "세종대왕"};
        // 3. 어답터 만들기
        /*ArrayAdapter adapter = ArrayAdapter.createFromResource(
                MainActivity.this, R.array.movie_tit, android.R.layout.simple_list_item_1
                //액티비티,내가 넣을 자료, 항목의 형태
        );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_single_choice,
                list);*/
     /*   // 4. 리스트 뷰의 객체 만들기
        ListView listView = (ListView)findViewById(R.id.listView_greatman);
        // 5. 리스트 뷰에 어댑터 설정하기
        listView.setAdapter(adapter);
        // 7. 리스너 객체 만들기
        MyItemListener myItemListener = new MyItemListener();
        // 8. 리스트 뷰에 리스너 등록하기
        listView.setOnItemClickListener(myItemListener);

        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(getApplicationContext(),MembershipActivity.class);
                startActivityForResult(intent,5);
            }
        });
        // 부록 6, 7, 8을 통합한 코드
        *//*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i=i%4;
                Toast.makeText(MainActivity.this,list_explain[i],Toast.LENGTH_LONG).show();
            }
        });*/
    }
    // 6. 리스너 만들기
    class MyItemListener implements AdapterView.OnItemClickListener{

        Intent intent;

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            intent =new Intent(MainActivity.this, InfoActivity.class);
            intent.putExtra("movie_index",i);
            startActivityForResult(intent,1);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_account_menu:
                Intent intent2 = new Intent(getApplicationContext(),MembershipActivity.class);
                startActivity(intent2);
                return true;
            case R.id.toolbar_item1_menu:
                return true;
            case R.id.toolbar_item2_menu:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
