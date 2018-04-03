package com.example.a501_03.gridview0319;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView_main=(GridView)findViewById(R.id.gridview_main);
        ImageAdapter imageAdapter=new ImageAdapter(MainActivity.this);
        gridView_main.setAdapter(imageAdapter);
        gridView_main.setOnItemClickListener(new GridListener());
    }

    class GridListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(),(position+1)+"번 째 그리드 입니다.",Toast.LENGTH_LONG).show();
        }
    }
    class ImageAdapter extends BaseAdapter{
        int[] pictures={R.drawable.img1,R.drawable.img2,R.drawable.img3};
        Context context;

        public ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return pictures[position%3];
        }

        @Override
        public long getItemId(int position) {
            return 1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if(convertView==null){
                imageView=new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }else{
                imageView=(ImageView)convertView;
            }
            imageView.setImageResource(pictures[position%3]);
            return imageView;
        }
    }
}
