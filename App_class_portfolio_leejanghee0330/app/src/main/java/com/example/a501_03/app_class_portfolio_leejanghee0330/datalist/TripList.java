package com.example.a501_03.app_class_portfolio_leejanghee0330.datalist;

import com.example.a501_03.app_class_portfolio_leejanghee0330.db.travel;

import java.util.ArrayList;

/**
 * Created by 501-03 on 2018-04-10.
 */

public class TripList {
    private static ArrayList<travel> tripList=new ArrayList<travel>();

    private TripList(){}

    public static synchronized ArrayList<travel> getInstance(){
        return tripList;
    }
}
