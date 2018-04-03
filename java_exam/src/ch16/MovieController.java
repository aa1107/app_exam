package ch16;

import java.awt.*;

public class MovieController {
    MovieModel model=new MovieModel();

    public void addTitle(String title,List movieList){
        model.addTitle(title, movieList);
    }

    public void delTitle(String title, List movieList){
        model.delTitle(title,movieList);
    }

    public void saveTitle(List movieList){
        try{
            model.saveTitles(movieList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
