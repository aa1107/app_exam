package com.example.a501_03.app_class_portfolio_leejanghee0330;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by 501-03 on 2018-04-03.
 */

public class MyListAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<MyTripListItems> arrayList;
    LayoutInflater layoutInflater;

    public MyListAdapter(Context context, int layout, ArrayList<MyTripListItems> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
//            convertView=layoutInflater.inflate(R.layout.)
        }
        return convertView;
    }
}
