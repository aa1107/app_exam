public class Person {
    private int perID;
    private int milID;

    public Person(int pID, int mID)
    {
        perID = pID;
        milID = mID;
    }

    public Person(int pID)
    {
        perID = pID;
        milID = -1;
    }

    public void showInfo()
    {
        System.out.println("주민번호"+perID);
        if(milID == -1){
            System.out.println("군번이 없음");
        }else{
            System.out.println("군번 : " + milID);
        }
    }
}
