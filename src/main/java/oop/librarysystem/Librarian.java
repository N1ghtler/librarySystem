package oop.librarysystem;

public class Librarian {
    private String libId, libName, libGender, libEmail, libTel;
    public Librarian(){}

    public Librarian(String libId, String libName, String libGender, String libEmail, String libTel) {
        this.libId = libId;
        this.libName = libName;
        this.libGender = libGender;
        this.libEmail = libEmail;
        this.libTel = libTel;
    }

    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public String getLibGender() {
        return libGender;
    }

    public void setLibGender(String libGender) {
        this.libGender = libGender;
    }

    public String getLibEmail() {
        return libEmail;
    }

    public void setLibEmail(String libEmail) {
        this.libEmail = libEmail;
    }

    public String getLibTel() {
        return libTel;
    }

    public void setLibTel(String libTel) {
        this.libTel = libTel;
    }
}
