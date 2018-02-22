public class PersonInfo {
    String name;
    String gender;
    String address;
    String school;
    String company;
    String phone_number;
    boolean phone_number_is_cellphone;
    boolean isStudent;

    PersonInfo(String aName, String aGender, String aAddress, String aSchoolOrCompany, boolean isStudent, String aPhone_number,
               boolean isCellPhone){
        name = aName;
        gender = aGender;
        address = aAddress;
        if(isStudent) {
            school = aSchoolOrCompany;
            company = "";
        }else{
            school = "";
            company = aSchoolOrCompany;
        }
        phone_number = aPhone_number;
        phone_number_is_cellphone = isCellPhone;
    }

    public void printInfo(){
        System.out.println("이름: " + name);
        System.out.println("성: " + gender);
        System.out.println("주소: " + address);
        System.out.println("학교: " + school);
        System.out.println("전화번호: " + phone_number);
    }
}
