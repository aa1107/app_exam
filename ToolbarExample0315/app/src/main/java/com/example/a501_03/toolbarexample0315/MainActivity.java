package com.example.a501_03.toolbarexample0315;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar_main=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_item_select1:
                Toast.makeText(getApplicationContext(),"첫번째 버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
                return true;
            case R.id.toolbar_item_select2:
                Toast.makeText(getApplicationContext(),"두번째 버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu aMenu) {
        getMenuInflater().inflate(R.menu.menu, aMenu);
        return true;
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }*/
}
