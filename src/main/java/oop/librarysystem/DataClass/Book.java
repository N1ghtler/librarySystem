package oop.librarysystem.DataClass;

public class Book {
     private String title, ISBN,author,year;

     public Book() {
     }

     public Book(String title, String ISBN, String author, String year) {
          this.title = title;
          this.ISBN = ISBN;
          this.author = author;
          this.year = year;
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

     public String getYear() {
          return year;
     }

     public void setYear(String year) {
          this.year = year;
     }

     @Override
     public String toString() {
          return "Book [Author=" + getAuthor() +
                  ", Tile=" + getTitle() +
                  ", Type=" + getISBN() +
                  ", Year=" + getYear() + "]";
     }
     
}
