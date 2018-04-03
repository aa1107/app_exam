package com.example.a501_03.listview;

/**
 * Created by 501-03 on 2018-03-14.
 */

public class MyItemData {
    int img_poster;
    String movie_name,movie_actor,movie_type,movie_date;
    double movie_rating;

    public MyItemData(int img_poster, String movie_name, String movie_actor, String movie_type, String movie_date, double movie_rating) {
        this.img_poster = img_poster;
        this.movie_name = movie_name;
        this.movie_actor = movie_actor;
        this.movie_type = movie_type;
        this.movie_date = movie_date;
        this.movie_rating = movie_rating;
    }
}
