package oop.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import oop.librarysystem.DataClass.Book;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddborrowbookController implements Initializable {
    public TextField MemberID;
    @FXML
    public TextField BookISBN;
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

    public Connection con;
    public PreparedStatement pst;
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    private void SubmitButton(ActionEvent event) throws SQLException {
        Book[] books = new Book[50];

        if(MemberID.getText().isEmpty()){
            information.appendText("Field please input MemberID !!!");
        }
        if(BookISBN.getText().isEmpty()){
            information.appendText("Field please input BookISBN !!!");
        }
        if(TodayDate.getText().isEmpty()){
            information.appendText("Field please input TodayDate !!!");
        }
        if(ReturnDate.getText().isEmpty())
        {
            information.appendText("ERROR!! please input ReturnDate !!");
        }


        String MemberIDText = MemberID.getText();
        String BookISBNText = BookISBN.getText();
        String  TodayDateText = TodayDate.getText();
        String ReturnDatetext = ReturnDate.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
            pst = con.prepareStatement("insert into Book(MemberID, BookISBN, TodayDate, ReturnDate)values(?,?,?,?)");

            pst.setString(1,MemberIDText);
            pst.setString(3,BookISBNText);
            pst.setString(2,TodayDateText);
            pst.setString(4,ReturnDatetext);

            int status = pst.executeUpdate();
            if(status==1){
                if(MemberID.getText() .equals("123") || MemberID.getText().equals("456")){
                    AddborrowbookController.JOptionPane.showMessageDialog(null,"Record add");
                    MemberID.setText("");
                    BookISBN.setText("");
                    TodayDate.setText("");
                    ReturnDate.setText("");
                }
                else {
                    information.appendText("Wrong input please input MemberID  again:");
                }

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
}

