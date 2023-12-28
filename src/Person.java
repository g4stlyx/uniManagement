import java.io.Serializable;

public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;

    public Person(){}

    Person(int id,String name,String address,String phoneNumber,String email,String username,String password){
        this.id =id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public String getPhoneNumber(){return phoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    
    public String toString(){
        return "person: "+ getId() +","+getName();
    }
}