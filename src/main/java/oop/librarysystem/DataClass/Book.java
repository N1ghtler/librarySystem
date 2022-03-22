package oop.librarysystem.DataClass;

public class Book {
     private String Tile,Type,Author,Year;

     public Book() {
     }

     public Book(String tile, String type, String author, String year) {
          Tile = tile;
          Type = type;
          Author = author;
          Year = year;
     }

     public String getTile() {
          return Tile;
     }

     public void setTile(String tile) {
          Tile = tile;
     }

     public String getType() {
          return Type;
     }

     public void setType(String type) {
          Type = type;
     }

     public String getAuthor() {
          return Author;
     }

     public void setAuthor(String author) {
          Author = author;
     }

     public String getYear() {
          return Year;
     }

     public void setYear(String year) {
          Year = year;
     }

     @Override
     public String toString() {
          return "Book [Author=" + Author + ", Tile=" + Tile + ", Type=" + Type + ", Year=" + Year + "]";
     }
     
}
