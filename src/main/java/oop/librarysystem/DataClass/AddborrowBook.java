package oop.librarysystem.DataClass;

public class AddborrowBook {
    private String Member_name,BookISBN,TodayDate,ReturnDate;
    public AddborrowBook (){

    }
    public AddborrowBook(String Member_name,String BookISBN,String TodayDate,String ReturnDate)
    {
        this.Member_name =Member_name;
        this.BookISBN =BookISBN;
        this.TodayDate=TodayDate;
        this.ReturnDate=ReturnDate;

    }
    public String getMember_name() {
        return Member_name;
    }

    public void setMember_name(String Member_name) {
        this.Member_name = Member_name;
    }

    public String getBookISBN() {
        return BookISBN;
    }

    public void setBookISBN(String BookISBN) {
        this.BookISBN = BookISBN;
    }

    public String getTodayDate() {
        return TodayDate;
    }

    public void setTodayDate(String author) {
        this.TodayDate = TodayDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    @Override
    public String toString() {
        return "AddBorrowBook [Member_name=" + getMember_name() +
                ", BookISBN=" + getBookISBN() +
                ", TodayDate=" + getTodayDate() +
                ", ReturnDate=" + getReturnDate() + "]";
    }
}
