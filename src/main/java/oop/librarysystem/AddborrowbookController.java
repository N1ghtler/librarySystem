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

    public Connection con;
    public PreparedStatement pst;
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    private void SubmitButton(ActionEvent event) throws SQLException {
        Book[] books = new Book[50];

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


        String MemberIDText = BookISBN.getText();
        String BookISBNText = Member_Name.getText();
        String  TodayDateText = TodayDate.getText();
        String ReturnDatetext = ReturnDate.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
            pst = con.prepareStatement("insert into Book(BookISBN, Mamber_Name,Date Taken, DateReturn)values(?,?,?,?)");

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
}

