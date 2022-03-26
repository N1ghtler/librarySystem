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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewMembersController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public TableView<ViewMember>  memberTable;
    @FXML
    public TableColumn<ViewMember, String> memberName;
    @FXML
    public TableColumn<ViewMember, String> memberGender;
    @FXML
    public TableColumn<ViewMember, String> memberID;
    @FXML
    public TableColumn<ViewMember, String> memberAge;

    ObservableList<ViewMember> data = FXCollections.observableArrayList();
    ArrayList<ViewMember> list = new ArrayList<>();

    public void addData(){
        list.add(new ViewMember("DDAs","20","M","A221"));
        list.add(new ViewMember("DDAds","210","M","A231"));
        list.add(new ViewMember("DDafAs","202","F","A421"));
        list.add(new ViewMember("DDAdfs","201","F","A521"));
        list.add(new ViewMember("DDdfAs","210","M","A621"));
        list.add(new ViewMember("DDadAs","22","M","A71"));
        data.addAll(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        memberName.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("Name"));
        memberGender.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("Gender"));
        memberID.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("ID"));
        memberAge.setCellValueFactory(new PropertyValueFactory<ViewMember,String>("Age"));
        addData();
        memberTable.setItems(data);
    }

    @FXML
    public void Addmember(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(""));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
