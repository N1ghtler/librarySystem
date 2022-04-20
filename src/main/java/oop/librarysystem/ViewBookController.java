package oop.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewBookController implements Initializable {
    @FXML
    private TableView<ViewBook> tableview;
    @FXML
    private TableColumn<ViewBook, String> colTitle;
    @FXML
    private TableColumn<ViewBook, String> colAuthor;
    @FXML
    private TableColumn<ViewBook, String> colIsbn;
    @FXML
    private TableColumn<ViewBook, Integer> colYear;

    @FXML
    private Parent viewBook;

    ObservableList<ViewBook> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellTable();
        displayBook();
    }

    private void setCellTable() {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("PubYear"));
    }

    private void displayBook() {
        DBConnect conn = new DBConnect();
        Connection db = conn.getConnection();
        String retrieveData = "Select * from book";
        try {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(retrieveData);
            while (rs.next()) {
                observableList.add(new ViewBook(rs.getString("BookName"), rs.getString("BookISBN"), rs.getString("BookAuthor"), rs.getInt("BookYear")));
            }
            db.close();
            tableview.setItems(observableList);
        } catch (SQLException e) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
    //SET SCENE
    @FXML
    public void viewBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-Book.fxml"));
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addMember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-member.fxml"));
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void viewBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBook.fxml"));
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addBorrowBooks.fxml"));
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void quitExit(ActionEvent event) throws IOException {
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.close();
    }
    @FXML
    public void Member(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMembers.fxml"));
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void librarian(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
        Stage window = (Stage) viewBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    //END SET SCENE
}
