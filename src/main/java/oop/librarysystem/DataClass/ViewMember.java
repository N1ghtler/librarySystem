package oop.librarysystem.DataClass;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewMember {
    private StringProperty Name;
    private StringProperty Age;
    private StringProperty Gender;
    private StringProperty ID;

    public ViewMember(){}
    public ViewMember(String Name,String Age,String Gender,String ID){
        this.Name = new SimpleStringProperty(Name);
        this.Age = new SimpleStringProperty(Age);
        this.Gender = new SimpleStringProperty(Gender);
        this.ID = new SimpleStringProperty(ID);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public StringProperty NameProperty() {
        return Name;
    }

    public String getAge() {
        return Age.get();
    }

    public void setAge(String Age) {
        this.Age.set(Age);
    }

    public StringProperty AgeProperty() {
        return Age;
    }

    public String getGender() {
        return Gender.get();
    }

    public void setGender(String Gender) {
        this.Gender.set(Gender);
    }

    public StringProperty GenderProperty() {
        return Gender;
    }

    public String getID() {
        return ID.get();
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public StringProperty IDProperty() {
        return ID;
    }
}
