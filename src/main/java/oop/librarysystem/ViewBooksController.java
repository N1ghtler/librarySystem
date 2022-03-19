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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewBooksController implements Initializable {
    @FXML
    public TableView<Member> books;
    @FXML
    public TableColumn<Member,String> bookName;
    @FXML
    public TableColumn<Member,String> bookType;
    @FXML
    public TableColumn<Member,String> bookAuthor;
    @FXML
    public TableColumn<Member,String> bookYear;



    private ObservableList<Member> data = FXCollections.observableArrayList(
            new Member("DDAs","asd1231as","sa234ds","A221"),
            new Member("DDAs","sa2","sad53s","A2e1"),
            new Member("DDAs","a32sqq425das","sa23ds","A2d1"),
            new Member("DDAs","asd235as","sa5235ds","A2as21"),
            new Member("DDAs","as235das","sss252ads","A2xa1")
            );



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bookName.setCellFactory(new PropertyValueFactory("Tile"));
        bookType.setCellFactory(new PropertyValueFactory("Type"));
        bookAuthor.setCellFactory(new PropertyValueFactory("Author"));
        bookYear.setCellFactory(new PropertyValueFactory("Year"));

        //books.setItems(data);
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
