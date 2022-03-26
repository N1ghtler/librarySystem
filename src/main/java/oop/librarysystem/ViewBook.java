package oop.librarysystem;

public class ViewBook {
    private String title, ISBN, author;
    private int pubYear;

    public ViewBook(){}

    public ViewBook(String title, String ISBN, String author, int pubYear) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.pubYear = pubYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }
}
