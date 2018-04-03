package ch14;

import java.util.ArrayList;
import java.util.List;

public class ForTest2 {
    public static void main(String[] args){
        List<MyStudent> list=new ArrayList<MyStudent>();

        list.add(new MyStudent());
        list.add(new MyStudent("홍길동",2));
        list.add(new MyStudent("차범근",2));
        list.add(new MyStudent("차두리",2));

        for(MyStudent st:list){
            System.out.println(st);
        }
    }
}

class MyStudent{
    String name;
    int grade;

    MyStudent(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    MyStudent(){
        this("이순신",2);
    }

    public String toString(){
        return "이름은 >>"+name+",학년은>>"+grade;
    }
}
