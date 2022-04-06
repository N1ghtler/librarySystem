package oop.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Material;
import javafx.stage.Stage;
import oop.librarysystem.DataClass.Member;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void Savebutton(ActionEvent event)
    {
        Member member = new Member();
        String Name = Mname.getText();

        member.setMemberName(Name);
        member.setMemberAge(Integer.parseInt(Mage.getText()));
        member.setMemberGender(Mgender.getText());
        member.setMemberID(Mid.getText());

        information.appendText(member.toString()+"\n");
    }

    @FXML
    private void Cancelbutton(ActionEvent event){
        Mname.setText("");
        Mage.setText(null);
        Mid.setText(null);
        Mgender.setText(null);
    }


}

