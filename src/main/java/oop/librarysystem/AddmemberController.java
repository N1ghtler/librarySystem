package oop.librarysystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    protected void Savebutton() {
        welcome.setText(" The information of this member are save !");
    }
    @FXML
    protected void Cancelbutton(){
        Stage stage =  new Stage();
        stage.close();
    }

}

