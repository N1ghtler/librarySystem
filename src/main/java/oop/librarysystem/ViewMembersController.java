package oop.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import oop.librarysystem.DataClass.Member;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewMembersController implements Initializable {

    @FXML
    public TableView<Member>  memberTable;
    public TableColumn<Member,String> memberName;
    public TableColumn<Member,String> memberGender;
    public TableColumn<Member,String> memberID;
    public TableColumn<Member,String> memberAge;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Member> data = FXCollections.observableArrayList(
            new Member("DDAs","20","sa234ds","A221"),
            new Member("DDAs","32","sad53s","A2e1"),
            new Member("DDAs","32","sa23ds","A2d1"),
            new Member("DDAs","41","sa5235ds","A2as21"),
            new Member("DDAs","54","sss252ads","A2xa1")
        );

        memberName.setCellFactory(new PropertyValueFactory("Name"));
        memberAge.setCellFactory(new PropertyValueFactory("Age"));
        memberGender.setCellFactory(new PropertyValueFactory("Gender"));
        memberID.setCellFactory(new PropertyValueFactory("ID"));

        //memberTable.getItems(data);
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
