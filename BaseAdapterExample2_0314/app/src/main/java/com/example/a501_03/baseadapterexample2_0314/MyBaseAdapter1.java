package com.example.a501_03.baseadapterexample2_0314;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by 501-03 on 2018-03-14.
 */

public class MyBaseAdapter1 extends BaseAdapter {

    ArrayList arrayList;
    LayoutInflater inflater;
    int layout_item;
    Context context;

    public MyBaseAdapter1(ArrayList arrayList, int layout_item, Context context) {
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout_item = layout_item;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
