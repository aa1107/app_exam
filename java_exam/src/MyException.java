public class MyException extends Exception {

    String msg = null;

    public MyException(String msg){
        this.msg = msg;
    }

    public String GetMsg(){
        return this.msg;
    }
}
