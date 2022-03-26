package oop.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewBookController implements Initializable {
    @FXML
    public TableView<ViewBook> tableview;
    //@FXML
    public TableColumn<ViewBook, String> colTitle;
    @FXML
    public TableColumn<ViewBook, String> colAuthor;
    @FXML
    public TableColumn<ViewBook, String> colIsbn;
    @FXML
    public TableColumn<ViewBook, Integer> colYear;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTitle.setCellValueFactory(new PropertyValueFactory<ViewBook, String>("Title"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<ViewBook, String>("ISBN"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<ViewBook, String>("Author"));
        colYear.setCellValueFactory(new PropertyValueFactory<ViewBook, Integer>("PubYear"));
        addBook();
        tableview.setItems(observableList);
    }

    ObservableList<ViewBook> observableList = FXCollections.observableArrayList();
    ArrayList<ViewBook> list = new ArrayList<>();
    public void addBook(){
        list.add(new ViewBook("test1","12345","jack",2000));
        list.add(new ViewBook("test2","12346","jack",2001));
        list.add(new ViewBook("test3","12347","jack",2002));
        list.add(new ViewBook("test4","12348","jack",2003));
        observableList.addAll(list);
    }
}
