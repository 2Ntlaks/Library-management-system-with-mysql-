package librarysystem;

public class MemberInfo 
{
    private String name,surname,email,phone_number;
    private int member_id;
    
    public MemberInfo(){} //non parameterilized constructor
    
     public MemberInfo(String name,String surname,String email, String phone_number, int member_id)
     {
         this.name = name;
         this.surname = surname;
         this.email = email;
         this.phone_number = phone_number;
         this.member_id = member_id;
     }
     //constructor without
     public MemberInfo(String name,String surname,String email, String phone_number)
     {
         this.name = name;
         this.surname = surname;
         this.email = email;
         this.phone_number = phone_number;
         this.member_id = member_id;
     }
     
     //getter and setter methods
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }
    public void setsurname(String surname) {
        this.surname = surname;
    }
    public String getsurname() {
        return surname;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getemail() {
        return email;
    }
    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getphone_number() {
        return phone_number;
    }
    public void setmember_id(int member_id)
    {
        this.member_id = member_id;
    }
    //we can only get not set id, because Database will set it for us
    public int getmember_id() {
        return member_id;
    }
    //function to display
    @Override
    public String toString() 
    {
        return "Name        : " +name +       "\n" +
               "Surname     : " +surname +    "\n" +
               "Member ID   : " + member_id + "\n"+
               "Member email: " + email +     "\n" +
               "Phone number: " + phone_number+"\n";
    }

     
    
    
}
