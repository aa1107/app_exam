package ch16;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MovieModel {
    public void addTitle(String title, List movieList){
        movieList.add(title);
    }

    public void delTitle(String title,List movieList){
        movieList.remove(title);
    }

    public void saveTitles(List movieList) throws Exception{
        File file=new File("movieTitle.txt");
        FileWriter fw=new FileWriter(file,true);
        PrintWriter pw=new PrintWriter(fw);
        String items[]=movieList.getItems();

        for(String item:items){
            pw.print(item);
            System.out.println(item);
        }
        fw.close();
        pw.close();
    }
}
