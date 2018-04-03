package ch14;

public class StudentTest {
    public static void main(String[] args){
        Student s1;
        Address addr;

        addr=new Address("수원시",1116);
        s1=new Student("홍길동",3,addr);

        String name=s1.getName();
        int grade=s1.getGrade();

        String city=s1.getAddress().getCity();
        int bungi=s1.getAddress().getBungi();

        System.out.println("학생 정보");
        System.out.println("----------------------");
        System.out.println("이름:"+name+",학년:"+grade+",주소:"+city+" "+bungi+"번지");
    }
}
