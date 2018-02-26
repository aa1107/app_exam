package myjavatestpakage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MainTest1 {
    public static void main(String[] args){
        String[] fruit = {"사과", "바나나","귤","수박","사과","사과","귤",
                "수박","수박","바나나","귤","사과","사과","수박","귤",
                "바나나","바나나","사과","귤","귤"};

        boolean isExisted = false;
        String fruitName = null;
        int value = 0;

        HashMap<String, Number> map = new HashMap<String, Number>();
        for(int i=0; i<fruit.length;i++){
            fruitName = fruit[i];

            Set set= map.keySet();
            Iterator ite = set.iterator();

            while(ite.hasNext()){  //HashMap에 저장된 key를 순서대로 가지고 온다.
                String name = (String)ite.next();
                if(fruitName.equals(name)){
                    value = (Integer)map.get(name);
                    map.put(name, ++value);
                    isExisted=true;

                }
            }//end while

            if(isExisted==false){
                map.put(fruitName, ++value);
            }

            value = 0;
            isExisted =false;
        }//end for

        System.out.println("과일 개수 출력하기");
        System.out.println("====================");

        Set set = map.keySet();
        Iterator ite = set.iterator();

        while(ite.hasNext()){
            fruitName=(String)ite.next();
            value = (Integer)map.get(fruitName);

            System.out.println(fruitName+" : "+value+"개");
        }
    }
}
