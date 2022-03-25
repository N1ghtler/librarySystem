package oop.librarysystem;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

public class AddMember implements Initializable {


    File writer = new File("Add_member.txt");
    @FXML
    public TextField Mname;
    @FXML
    public TextField Mid;
    @FXML
    public TextField Mage;
    @FXML
    public TextField Mgender;
    @FXML
    public TextField save_button;
    @FXML
    public TextField cancel_button;

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void cancel(ActionEvent event)
    {
        Stage stage = (Stage) Mname.getScene().getWindow();
        stage.close();
    }
    private void setMname(String name){
    }
    private void setMid(String id){
    }
    private  void setMage(int age){
    }
    private void setMgender(String gender){}

    @FXML
    private void Addmember(ActionEvent event)
    {
        String name = Mname.getText();
        String id = Mid.getText();
        String age = Mage.getText();
        String gender = Mgender.getText();


    }

}
