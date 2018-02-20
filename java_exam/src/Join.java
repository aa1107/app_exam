public class Join {
    String pass="";
    String checkpass="";

    public Join(String pass){
        this.pass = pass;
        checkPassLength();
    }

    public void checkPassLength(){
        if(this.pass.length()<=8){
            System.out.println("8글자 이상 입력해 주세요");
        }else{
            System.out.println("올바른 메시지 입니다");
        }
    }

    public void checkPassCorrect(String checkpass){
        this.checkpass = checkpass;
        if(this.pass.compareTo(this.checkpass)==0){
            System.out.println("입력 내용이 같습니다");
        }else{
            System.out.println("재입력 해주세요");
        }
    }
}
