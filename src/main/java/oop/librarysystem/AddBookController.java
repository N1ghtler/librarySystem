package oop.librarysystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import oop.librarysystem.DataClass.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddBookController implements Initializable {
    public TextField Title;
    @FXML
    public TextField ISBN;
    @FXML
    public TextField Author;
    @FXML
    public TextField Publish_year;
    @FXML
    private Label welcome;
    @FXML
    public Button Cancel_B;
    @FXML
    public Button Save_B;
    @FXML
    public TextArea information;
    //private Executor = exec;

    public Connection con;
    public PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void Savebutton(ActionEvent event) throws SQLException {
        Book[] books = new Book[50];

        if(Title.getText().isEmpty()){
            information.appendText("Field please input Title !!!");
        }
        if(ISBN.getText().isEmpty()){
            information.appendText("Field please input ISBN !!!");
        }
        if(Author.getText().isEmpty()){
            information.appendText("Field please input Author !!!");
        }
        if(Publish_year.getText().isEmpty())
        {
            information.appendText("ERROR!! please input Publishyear !!");
        }


        String titleText = Title.getText();
        String isbnText = ISBN.getText();
        String  Authortext = Author.getText();
        int publishyeartext = Integer.parseInt(Publish_year.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library system","root","");
            pst = con.prepareStatement("insert into Book(Title, ISBN, Author, Publish_year)values(?,?,?,?)");

            pst.setString(1,titleText);
            pst.setString(3,isbnText);
            pst.setString(2,Authortext);
            pst.setInt(4,publishyeartext);

            int status = pst.executeUpdate();
            if(status==1){
                if(Title.getText() .equals("123") || Title.getText().equals("456")){
                    AddBookController.JOptionPane.showMessageDialog(null,"Record add");
                    Title.setText("");
                    ISBN.setText("");
                    Author.setText("");
                    Publish_year.setText("");
                }
                else {
                    information.appendText("Wrong input please input Title  again:");
                }

            }else {
                AddBookController.JOptionPane.showMessageDialog(null,"Record Filed");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void Cancelbutton(ActionEvent event){
        Title.setText("");
        ISBN.setText(null);
        Author.setText(null);
        Publish_year.setText(null);
    }


static class JOptionPane {

    public static void showMessageDialog(Object o, String record_add) {

    }
}
}



