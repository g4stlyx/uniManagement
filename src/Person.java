public class Person {
    
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    Person(String name,String address,String phoneNumber,String email){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // getter and setter methods
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public String getAddress(){return this.address;}
    public void setAddress(String address){this.address = address;}
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
    
    // other methods
    public String toString(){
        return name+"("+address+")";
    }

    public int login(){
        return 0;
    }

}