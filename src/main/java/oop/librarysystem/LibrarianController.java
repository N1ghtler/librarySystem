package oop.librarysystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrarianController implements Initializable {

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_update;

    @FXML
    private TableView<Librarian> tableview;

    @FXML
    private TableColumn<Librarian, String> colEmail;

    @FXML
    private TableColumn<Librarian, String> colGender;

    @FXML
    private TableColumn<Librarian, String> colId;

    @FXML
    private TableColumn<Librarian, String> colName;

    @FXML
    private TableColumn<Librarian, String> colTel;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_gender;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_search;

    @FXML
    private TextField tf_tel;

    @FXML
    private Parent libScene;

    SecurePassword pw = new SecurePassword();
    DBConnect conn = new DBConnect();
    Connection db ;
    PreparedStatement ps;
    int record;
    ObservableList<Librarian> list = FXCollections.observableArrayList();
    FilteredList<Librarian> filterData = new FilteredList<>(list, b -> true);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayLibrarian();
    }
    @FXML
    private void handleButtonOnAction(ActionEvent event) {
        if (event.getSource() == btn_add){
            if (isFieldEmpty()){
                showAlert(Alert.AlertType.WARNING,"Blank Field","Please fill all the empty field!");
            }else {
                addLibrarian();
            }
        }else if (event.getSource() == btn_update){
            if (isFieldEmpty()){
                showAlert(Alert.AlertType.WARNING,"Blank Field","Please fill all the empty field!");
            }else {
                updateLibrarian();
            }
        }else if (event.getSource() == btn_delete){
            if (isFieldEmpty()){
                showAlert(Alert.AlertType.WARNING,"Blank Field","Please fill all the empty field!");
            }else {
                deleteLibrarian();
            }
        }
    }

    @FXML
    private void handleMouseOnAction(MouseEvent event) {
        Librarian librarian = tableview.getSelectionModel().getSelectedItem();
        tf_id.setText(librarian.getLibId());
        tf_name.setText(librarian.getLibName());
        tf_gender.setText(librarian.getLibGender());
        tf_email.setText(librarian.getLibEmail());
        tf_tel.setText(librarian.getLibTel());
        db = conn.getConnection();
        String retrievePassword = "Select Lib_password from librarian where Lib_id = ?";
        String password = "";
        try {
            ps = db.prepareStatement(retrievePassword);
            ps.setString(1,tf_id.getText());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                password = rs.getString("Lib_password");
            }
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pf_password.setText(pw.decrypt(password));
    }
    private void setCellTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("LibId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("LibName"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("LibGender"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("LibEmail"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("LibTel"));
    }
    private void displayLibrarian() {
        list.clear();
        setCellTable();
        db = conn.getConnection();
        String retrieveData = "Select * from librarian";
        try {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(retrieveData);
            while (rs.next()) {
               list.add(new Librarian(rs.getString("Lib_id"),rs.getString("Lib_name"),
                       rs.getString("Lib_gender"),rs.getString("Lib_email"),
                       rs.getString("Lib_tel")));
            }
            db.close();
            tableview.setItems(list);
            searchLibrarian();
        } catch (SQLException e) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
    private void searchLibrarian(){
        tf_search.textProperty().addListener((observable,oldValue, newValue) ->{
            filterData.setPredicate(Librarian -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (Librarian.getLibId().toLowerCase().contains(searchKeyword)){
                    return true;
                }else if (Librarian.getLibName().toLowerCase().contains(searchKeyword)){
                    return  true;
                }else if (Librarian.getLibGender().toLowerCase().contains(searchKeyword)){
                    return  true;
                }else if (Librarian.getLibEmail().toLowerCase().contains(searchKeyword)){
                    return  true;
                }else if (Librarian.getLibTel().toLowerCase().contains(searchKeyword)){
                    return  true;
                }else {
                    return false;
                }
            });
        });
        SortedList<Librarian> sortData = new SortedList<>(filterData);
        sortData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortData);
    }
    private void addLibrarian(){
        db = conn.getConnection();
        String insertData = "Insert into librarian values(?,?,?,?,?,?)";
        try {
            ps = db.prepareStatement(insertData);
            ps.setString(1,tf_id.getText());
            ps.setString(2,tf_name.getText());
            ps.setString(3,tf_gender.getText());
            ps.setString(4,tf_email.getText());
            ps.setString(5,tf_tel.getText());
            ps.setString(6,pw.encrypt(pf_password.getText()));
            record = ps.executeUpdate();
            if (record==1){
                showAlert(Alert.AlertType.INFORMATION,"Record Information",
                        "Record has been added successfully!");
                displayLibrarian();
                clearText();
            }else {
                showAlert(Alert.AlertType.WARNING,"Empty Field","Please fill all the empty field!");
            }
            db.close();
        } catch (Exception e) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
    private void updateLibrarian(){
        db = conn.getConnection();
        String updateData = "Update librarian set Lib_name = ?,Lib_gender = ?,Lib_email = ?," +
                "Lib_tel = ?,Lib_password = ? where Lib_id = ?";
        try {
            ps = db.prepareStatement(updateData);
            ps.setString(1,tf_name.getText());
            ps.setString(2,tf_gender.getText());
            ps.setString(3,tf_email.getText());
            ps.setString(4,tf_tel.getText());
            ps.setString(5,pw.encrypt(pf_password.getText()));
            ps.setString(6,tf_id.getText());
            record = ps.executeUpdate();
            if (record==1){
                showAlert(Alert.AlertType.INFORMATION,"Record Information",
                        "Record has been updated successfully!");
                displayLibrarian();
                clearText();
            }else {
                showAlert(Alert.AlertType.WARNING,"Empty Field","Please fill all the empty field!");
            }
            db.close();
        } catch (Exception e) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
    private void deleteLibrarian(){
        db = conn.getConnection();
        String deleteData = "Delete from librarian where Lib_id = ?";
        try {
            ps = db.prepareStatement(deleteData);
            ps.setString(1, tf_id.getText());
            record = ps.executeUpdate();
            if (record==1){
                showAlert(Alert.AlertType.INFORMATION,"Record Information",
                        "Record has been deleted successfully!");
                displayLibrarian();
                clearText();
            }else {
                showAlert(Alert.AlertType.WARNING,"Empty Field","Please fill all the empty field!");
            }
            db.close();
        } catch (SQLException e) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
    private boolean isFieldEmpty(){
        return  (tf_id.getText().isEmpty() | tf_name.getText().isEmpty() | tf_gender.getText().isEmpty()
        | tf_email.getText().isEmpty() | tf_tel.getText().isEmpty() | pf_password.getText().isEmpty());
    }
    private void showAlert(Alert.AlertType alertType, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    private void clearText(){
        tf_id.clear();
        tf_name.clear();
        tf_gender.clear();
        tf_email.clear();
        tf_tel.clear();
        pf_password.clear();
    }
    //SET SCENE
    @FXML
    public void viewBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewBook.fxml"));
        Stage window = (Stage) libScene.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-Book.fxml"));
        Stage window = (Stage) libScene.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addMember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add-member.fxml"));
        Stage window = (Stage) libScene.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void viewBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BorrowBooks.fxml"));
        Stage window = (Stage) libScene.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void addBorrowBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addBorrowBooks.fxml"));
        Stage window = (Stage) libScene.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void quitExit(ActionEvent event) throws IOException {
        Stage window = (Stage) libScene.getScene().getWindow();
        window.close();
    }
    @FXML
    public void Member(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewMembers.fxml"));
        Stage window = (Stage) libScene.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @FXML
    public void librarian(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
        Stage window = (Stage) libScene.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    //END SET SCENE
}
