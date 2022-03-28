package oop.librarysystem.DataClass;

public class Member{

    private String Name;
    private int Age;
    private String ID;
    private String gender;

    public Member() {

    }

    public Member(String Name, int Age , String ID) {
        this.Name = Name;
        this.Age = Age;
        this.ID = ID;
    }

    public Member(String Name, int Age, String ID, String gender) {
        this.Name = Name;
        this.Age= Age;
        this.ID = ID;
        this.gender= gender;
    }

    public void setMemberName(String name) {
        this.Name = name;
    }

    public void setMemberAge(int Age) {
        this.Age = Age;
    }

    public void setMemberID(String id) {
        this.ID = id;
    }

    public void setMemberGender(String gender) {
        this.gender = gender;
    }

    public String getMemberName() {
        return Name;
    }

    public int getMemberAge() {
        return Age;
    }

    public String getMemberID() {
        return ID;
    }

    public String getMemberGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Member [Age=" + Age + ", Gender=" + gender + ", ID=" + ID + ", Name=" + Name + "]";
    }

}
