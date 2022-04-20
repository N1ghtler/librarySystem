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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddmemberController implements Initializable {

    @FXML
    public TextField Mname;
    @FXML
    public TextField Mid;
    @FXML
    public TextField Mage;
    @FXML
    public TextField Mgender;
    @FXML
    private Label welcome;
    @FXML
    public Button Cancel_B;
    @FXML
    public Button Save_B;
    @FXML
    public TextArea information;
    @FXML
    private Parent addmember;
    //private Executor = exec;

    public Connection con;
    public PreparedStatement pst;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void Savebutton(ActionEvent event) throws SQLException {

        if(Mname.getText().isEmpty()){
            information.appendText("Field please input Name !!!");
        }
        if(Mid.getText().isEmpty()){
            information.appendText("Field please input ID !!!");
        }
        if(Mage.getText().isEmpty()){
            information.appendText("Field please input Age !!!");
        }
        if(Mgender.getText().isEmpty())
        {
            information.appendText("ERROR!! please input Gender !!");
        }

        String empname = Mname.getText();
        String empid = Mid.getText();
        String  empage = Mage.getText();
        String empgender = Mgender.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","root");
            pst = con.prepareStatement("insert into member(MemberID, MemberName, MemberAge, MemberGender)values(?,?,?,?)");

            pst.setString(2,empname);
            pst.setString(1,empid);
            pst.setString(3,empage);
            pst.setString(4,empgender);

            int status = pst.executeUpdate();
            if(status==1){
                if(((Mgender.getText().equals("F")|| Mgender.getText().equals("f")||Mgender.getText().equals("M")||Mgender.getText().equals("m")))){

                    JOptionPane.showMessageDialog(null,"Record add");
                    Mname.setText("");
                    Mid.setText("");
                    Mage.setText("");
                    Mgender.setText("");
                    Mname.requestFocus();
                }
                else {
                    information.appendText("Wrong input please input gender as( m or M and f or F)");
                }

            }else {
                JOptionPane.showMessageDialog(null,"Record Filed");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @FXML
    private void Cancelbutton(ActionEvent event){
        Mname.setText("");
        Mage.setText(null);
        Mid.setText(null);
        Mgender.setText(null);
    }


    static class JOptionPane {

        public static void showMessageDialog(Object o, String record_add) {

        }
    }

    private class FXMLDocumentController {
    }
    //SET SCENE
    @FXML
    public void viewBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        Stage window = (Stage) addmember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-Book.fxml"));
        Stage window = (Stage) addmember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addMember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-member.fxml"));
        Stage window = (Stage) addmember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void viewBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBook.fxml"));
        Stage window = (Stage) addmember.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addBorrowBooks.fxml"));
        Stage window = (Stage) addmember.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void Member(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMembers.fxml"));
        Stage window = (Stage) addmember.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void librarian(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
        Stage window = (Stage) addmember.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void quitExit(ActionEvent event) throws IOException {
        Stage window = (Stage) addmember.getScene().getWindow();
        window.close();
    }
    //END SET SCENE
}

