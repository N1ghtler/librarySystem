package oop.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.librarysystem.DataClass.AddborrowBook;
import oop.librarysystem.DataClass.Book;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddborrowbookController implements Initializable {
    @FXML
    public TextField BookISBN;
    @FXML
    public TextField Member_Name;
    @FXML
    public TextField TodayDate;
    @FXML
    public TextField ReturnDate;
    @FXML
    private Label welcome;
    @FXML
    public Button Submit_B;
    @FXML
    public TextArea information;
    public Parent Addborrowbook;

    public Connection con;
    public PreparedStatement pst;
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void Submit(ActionEvent event) throws SQLException {
        AddborrowBook[] addborrowBooksbooks = new AddborrowBook[50];

        if(BookISBN.getText().isEmpty()){
            information.appendText("Field please input BookISBN !!!");
        }
        if(Member_Name.getText().isEmpty()){
            information.appendText("Field please input MemmberName !!!");
        }
        if(TodayDate.getText().isEmpty()){
            information.appendText("Field please input TodayDate !!!");
        }
        if(ReturnDate.getText().isEmpty())
        {
            information.appendText("ERROR!! please input ReturnDate !!");
        }


        String BookISBNText = BookISBN.getText();
        String MemberIDText = Member_Name.getText();
        String  TodayDateText = TodayDate.getText();
        String ReturnDatetext = ReturnDate.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","root");
            pst = con.prepareStatement("insert into borrowbooks(BookISBN, Mamber_Name,DateTaken, DateReturn) values (?,?,?,?)");

            pst.setString(2,MemberIDText);
            pst.setString(1,BookISBNText);
            pst.setString(3,TodayDateText);
            pst.setString(4,ReturnDatetext);

            int status = pst.executeUpdate();
            if(status==1){
                    AddborrowbookController.JOptionPane.showMessageDialog(null,"Record add");
                    Member_Name.setText("");
                    BookISBN.setText("");
                    TodayDate.setText("");
                    ReturnDate.setText("");

            }else {
                AddBookController.JOptionPane.showMessageDialog(null,"Record Filed");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }



    private static class JOptionPane {

        public static void showMessageDialog(Object o, String record_add) {

        }
    }
    //SET SCENE
    @FXML
    public void viewBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-Book.fxml"));
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addMember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-member.fxml"));
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void viewBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBook.fxml"));
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addBorrowBooks.fxml"));
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void Member(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMembers.fxml"));
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void librarian(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void quitExit(ActionEvent event) throws IOException {
        Stage window = (Stage) Addborrowbook.getScene().getWindow();
        window.close();
    }
    //END SET SCENE
}

