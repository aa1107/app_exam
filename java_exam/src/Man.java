class Man {

    private String name;

    public Man(String name) {
        this.name = name;
    }

    public void tellYourName(){
        System.out.println("My name is " + name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
