package com.example.a501_03.greendao;


import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {
    public static void main(String[] args){
        Schema schema=new Schema(1,"com.example.a501_03.app_class_portfolio_leejanghee0330.db");
        schema.enableKeepSectionsByDefault();
    }
}