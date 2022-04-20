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

public class ViewMembersController implements Initializable {



    @FXML
    public TableView<ViewMember>  memberTable;
    @FXML
    public TableColumn<ViewMember, String> memberName;
    @FXML
    public TableColumn<ViewMember, String> memberGender;
    @FXML
    public TableColumn<ViewMember, String> memberID;
    @FXML
    public TableColumn<ViewMember, String> memberAge;
    @FXML
    public TextField InputIDMember;
    public Button DeleteButton;
    public Label OUTresulfLable;
    public Parent mainFXMember;


    ObservableList<ViewMember> data = FXCollections.observableArrayList();
    ArrayList<ViewMember> list = new ArrayList<>();


    public void addData(){
        try{
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarysystem","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from member");
            while(rs.next())
                list.add(new ViewMember(rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(1)));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        data.addAll(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        memberName.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("Name"));
        memberGender.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("Gender"));
        memberID.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("ID"));
        memberAge.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("Age"));
        addData();
        memberTable.setItems(data);


    }
    //SET SCENE
    @FXML
    public void viewBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-Book.fxml"));
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addMember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-member.fxml"));
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void viewBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBooks.fxml"));
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addBorrowBooks.fxml"));
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void Member(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMembers.fxml"));
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void librarian(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void quitExit(ActionEvent event) throws IOException {
        Stage window = (Stage) mainFXMember.getScene().getWindow();
        window.close();
    }
    //END SET SCENE
    @FXML
    public void deleteData(ActionEvent event){
        String ID = InputIDMember.getText();
        ViewMember re = new ViewMember();
        boolean foundIT = false;
        for (ViewMember tmp : list) {
            if (ID.equalsIgnoreCase(tmp.getID())) {
                System.out.println("Found It");
                re = tmp;
                foundIT = true;
                break;
            }
        }

        if (foundIT){
            list.remove(re);
            data.remove(re);

            try{
                Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/librarySystem","root","");

                String query = "delete from member where MemberID = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, ID);
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