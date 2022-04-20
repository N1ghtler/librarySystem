package oop.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewBorrowbookController implements Initializable {
    @FXML
    public TableView<ViewBorrowbook> tableview;
    @FXML
    public TableColumn<ViewBorrowbook, String> colMname;
    @FXML
    public TableColumn<ViewBorrowbook, String> colBIsbn;
    @FXML
    public TableColumn<ViewBorrowbook, String> colDate;
    @FXML
    public TableColumn<ViewBorrowbook, Integer> colReturnDate;
    Connection con;

    public TextField InputBISBN;
    public Button DeleteButton;
    public Label OUTresulfLable;

    @FXML
    private Parent ViewBorrowBook;

    ObservableList<ViewBorrowbook> observableList = FXCollections.observableArrayList();
    ArrayList<ViewBorrowbook> list = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellTable();
        //displayBook();
    }

    private void setCellTable() {
        colMname.setCellValueFactory(new PropertyValueFactory<>("Mname"));
        colBIsbn.setCellValueFactory(new PropertyValueFactory<>("BISBN"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        displayBook();
        tableview.setItems(observableList);
    }


    private void displayBook() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "root");
            String retrieveData = "Select * from borrowbooks";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(retrieveData);
            while (rs.next()) {
                list.add(new ViewBorrowbook(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4)));
                System.out.println(rs.getString("BookISBN")+"\t"+rs.getString("Mamber_Name")+"\t"+rs.getString("DateTaken")+"\t"+rs.getString("DateReturn"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } observableList.addAll(list);

    }
    //SET SCENE
    @FXML
    public void viewBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-Book.fxml"));
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addMember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-member.fxml"));
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void viewBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBook.fxml"));
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addBorrowBooks.fxml"));
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void Member(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMembers.fxml"));
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void librarian(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void quitExit(ActionEvent event) throws IOException {
        Stage window = (Stage) ViewBorrowBook.getScene().getWindow();
        window.close();
    }
    //END SET SCENE


    public class ViewBorrowbook {
        private String Mname, BISBN,Date, ReturnDate;

        public ViewBorrowbook(){}

        public ViewBorrowbook(String Mname, String BISBN, String Date, String ReturnDate) {
            this.Mname = Mname;
            this.BISBN = BISBN;
            this.Date=Date;
            this.ReturnDate= ReturnDate;
        }

        public String getMname() {
            return Mname;
        }

        public void setMname(String Mname) {
            this.Mname= Mname;
        }

        public String getBISBN() {
            return BISBN;
        }

        public void setBISBN(String BISBN) {
            this.BISBN = BISBN;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date= Date;
        }

        public String getReturnDate() {
            return ReturnDate;
        }

        public void setReturnDate(String ReturnDate) {
            this.ReturnDate = ReturnDate;
        }
    }
    public void deleteData(ActionEvent event){
        String BISBN = InputBISBN.getText();
        ViewBorrowbook re = new ViewBorrowbook();
        boolean foundIT = false;
        for (ViewBorrowbook tmp : list) {
            if (BISBN.equalsIgnoreCase(tmp.getBISBN())) {
                System.out.println("Found It");
                re = tmp;
                foundIT = true;
                break;
            }
        }

        if (foundIT){
            list.remove(re);
            observableList.remove(re);

            try{
                Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/librarysystem","root","root");

                String query = "delete from borrowbooks where borrowbook_isbn = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(2, BISBN);
                preparedStmt.execute();
                con.close();
            }catch(Exception e){ System.out.println(e);}
            OUTresulfLable.setText("Done");
        }
        else {
            OUTresulfLable.setText("NOT FOUND!");
        }
    }


}



