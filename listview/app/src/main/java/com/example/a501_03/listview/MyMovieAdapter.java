package com.example.a501_03.listview;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 501-03 on 2018-03-14.
 */

public class MyMovieAdapter extends BaseAdapter {
    ArrayList<MyItemData> arrayList;
    LayoutInflater layoutInflater;
    Context context;

    int item_layout_id;

    public MyMovieAdapter(Context context, ArrayList<MyItemData> arrayList, int item_layout_id) {
        this.arrayList = arrayList;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.item_layout_id = item_layout_id;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view==null){
            view=layoutInflater.inflate(item_layout_id,viewGroup,false);
        }
        ImageView imageView_poster_myitem=(ImageView)view.findViewById(R.id.imageView_poster_myitem);
        TextView textView_name_myitem=(TextView) view.findViewById(R.id.textView_name_myitem);
        TextView textView_actor_myitem=(TextView)view.findViewById(R.id.textView_actor_myitem);
        TextView textView_type_myitem=(TextView)view.findViewById(R.id.textView_type_myitem);
        TextView textView_date_myitem=(TextView)view.findViewById(R.id.textView_date_myitem);
        RatingBar ratingBar_myitem=(RatingBar)view.findViewById(R.id.ratingBar_myitem);
        ConstraintLayout constraintLayout=(ConstraintLayout)view.findViewById(R.id.constraint_myitem);

        imageView_poster_myitem.setImageResource(arrayList.get(i).img_poster);
        textView_name_myitem.setText(arrayList.get(i).movie_name);
        textView_actor_myitem.setText(arrayList.get(i).movie_actor);
        textView_type_myitem.setText(arrayList.get(i).movie_type);
        textView_date_myitem.setText(arrayList.get(i).movie_date);
        ratingBar_myitem.setRating((float)arrayList.get(i).movie_rating);

        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=Intent(this,)
            }
        });*/

        return view;
    }
}
