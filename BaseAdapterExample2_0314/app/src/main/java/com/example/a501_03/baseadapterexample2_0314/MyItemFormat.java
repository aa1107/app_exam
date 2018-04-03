package com.example.a501_03.baseadapterexample2_0314;

/**
 * Created by 501-03 on 2018-03-14.
 */

public class MyItemFormat {
    int product_img_left, product_img_right;
    String product_name_left, product_name_right, product_price_left, product_price_right;
    double product_score_left, product_score_right;

    public MyItemFormat(int product_img_left, int product_img_right,
                        String product_name_left, String product_name_right,
                        String product_price_left, String product_price_right,
                        double product_score_left, double product_score_right) {
        this.product_img_left = product_img_left;
        this.product_img_right = product_img_right;
        this.product_name_left = product_name_left;
        this.product_name_right = product_name_right;
        this.product_price_left = product_price_left;
        this.product_price_right = product_price_right;
        this.product_score_left = product_score_left;
        this.product_score_right = product_score_right;
    }
}
