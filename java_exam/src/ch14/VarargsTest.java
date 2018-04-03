package ch14;

public class VarargsTest {
    public static void main(String[] args){
        Varargs var = new Varargs();

        var.method1(new String[]{"박지성", "차범근", "이순신","김유신"});
        var.method2("박지성",1,2,3,4);
    }
}

class Varargs{
    public void method1(String[] name){
        for(String temp:name){
            System.out.println(temp);
        }
    }

    public void method2(String name, int ... num){
        System.out.println(name);

        for(int i:num){
            System.out.println(i);
        }
    }
}
