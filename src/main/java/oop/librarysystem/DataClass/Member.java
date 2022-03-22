package oop.librarysystem.DataClass;

public class Member {
    private  String Name,Age,Gender,ID;
    public Member(String name, String age, String gender, String iD) {
        Name = name;
        Age = age;
        Gender = gender;
        ID = iD;
    }
    public Member(){}
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        Age = age;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    
    @Override
    public String toString() {
        return "Member [Age=" + Age + ", Gender=" + Gender + ", ID=" + ID + ", Name=" + Name + "]";
    }

}
