package oop.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.librarysystem.DataClass.ViewMember;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewMembersController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public TableView<ViewMember>  memberTable;
    @FXML
    public TableColumn<ViewMember,String> memberName;
    @FXML
    public TableColumn<ViewMember,String> memberGender;
    @FXML
    public TableColumn<ViewMember,String> memberID;
    @FXML
    public TableColumn<ViewMember,String> memberAge;

    ObservableList<ViewMember> data = FXCollections.observableArrayList(
            new ViewMember("DDAs","20","M","A221"),
            new ViewMember("DDAs","32","M","A2e1"),
            new ViewMember("DDAs","32","F","A2d1"),
            new ViewMember("DDAs","41","F","A2as21"),
            new ViewMember("DDAs","54","F","A2xa1")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        memberName.setCellFactory(new PropertyValueFactory("Name"));
        memberAge.setCellFactory(new PropertyValueFactory("Age"));
        memberGender.setCellFactory(new PropertyValueFactory("Gender"));
        memberID.setCellFactory(new PropertyValueFactory("ID"));

        //memberTable.setItems(data);
    }

    @FXML
    public void Addmember(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("src/main/resources/oop/librarysystem/addmember.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
//        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
//        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
//        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
//        //add your data to the table here.
//        tbData.setItems(studentsModels);
//    }
//
//    // add your data here from any source
//    private ObservableList<StudentsModel> studentsModels = FXCollections.observableArrayList(
//            new StudentsModel(1,"Amos", "Chepchieng"),
//            new StudentsModel(2,"Keep", "Too"),
//            );
}
