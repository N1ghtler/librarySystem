package oop.librarysystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import oop.librarysystem.DataClass.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddBookController implements Initializable {
    public TextField BTittle;
    @FXML
    public TextField BIsbn;
    @FXML
    public TextField BAuthor;
    @FXML
    public TextField BPublishyear;

    @FXML
    public Button Cancel_B;
    @FXML
    public Button Save_B;
    @FXML
    public TextArea information;
    public Parent addmbooks;

    public Connection connect;
    public PreparedStatement pret;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void Savebutton(ActionEvent event) throws SQLException {
        Book[] books = new Book[50];

        if(BTittle.getText().isEmpty()){
            information.appendText("Field please input Title !!!");
        }
        if(BIsbn.getText().isEmpty()){
            information.appendText("Field please input ISBN !!!");
        }
        if(BAuthor.getText().isEmpty()){
            information.appendText("Field please input Author !!!");
        }
        if(BPublishyear.getText().isEmpty())
        {
            information.appendText("Field please input Publishyear !!");
        }

        String titleText = BTittle.getText();
        String isbnText = BIsbn.getText();
        String  Authortext = BAuthor.getText();
        int publishyeartext = Integer.parseInt(BPublishyear.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","root");
            pret = connect.prepareStatement("insert into Book(BookName, BookISBN, BookAuthor, BookYear)values(?,?,?,?)");

            pret.setString(1,titleText);
            pret.setString(2,isbnText);
            pret.setString(3,Authortext);
            pret.setInt(4,publishyeartext);

            int status = pret.executeUpdate();
            if(status==1){
                AddBookController.JOptionPane.showMessageDialog(null,"Record add");
                BTittle.setText("");
                BIsbn.setText("");
                BAuthor.setText("");
                BPublishyear.setText("");
            }else {
                AddBookController.JOptionPane.showMessageDialog(null,"Record Filed");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void Cancelbutton(ActionEvent event){
        BTittle.setText("");
        BIsbn.setText(null);
        BAuthor.setText(null);
        BPublishyear.setText(null);
    }


static class JOptionPane {

    public static void showMessageDialog(Object o, String record_add) {

    }
}
    //SET SCENE
    @FXML
    public void viewBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-Book.fxml"));
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addMember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-member.fxml"));
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void viewBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBook.fxml"));
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addBorrowBooks.fxml"));
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void Member(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMembers.fxml"));
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void librarian(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void quitExit(ActionEvent event) throws IOException {
        Stage window = (Stage) addmbooks.getScene().getWindow();
        window.close();
    }
    //END SET SCENE
}



