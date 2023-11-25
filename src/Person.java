public class Person {
    
    // variables
    private String name;
    private String address;
    private int phoneNumber;
    private String email;

    // constructors
    Person(String name,String address){
        this.name = name;
        this.address = address;
    }

    // getter and setter methods
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public String getAddress(){return this.address;}
    public void setAddress(String address){this.address = address;}
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}
    public int getPhoneNumber(){return this.phoneNumber;}
    public void setPhoneNumber(int phoneNumber){this.phoneNumber = phoneNumber;}
    
    // other methods
    public String toString(){
        return name+"("+address+")";
    }

    public int login(){
        return 0;
    }

}