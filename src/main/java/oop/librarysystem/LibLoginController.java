package oop.librarysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibLoginController implements Initializable {

    @FXML
    private Parent login;
    @FXML
    private Label label_error;
    @FXML
    private Button btn_login;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_username;

    @FXML
    void login(ActionEvent event) throws Exception {
        SecurePassword pw = new SecurePassword();
        DBConnect connect = new DBConnect();
        Connection dbConnect = connect.getConnection();
        String username = "";
        String password = "";
        String verify = "select Lib_name, Lib_password from librarian where Lib_name = ? and Lib_password = ?";
        try {
            PreparedStatement ps = dbConnect.prepareStatement(verify);
            ps.setString(1, tf_username.getText());
            ps.setString(2, pw.encrypt(pf_password.getText()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                username = rs.getString("Lib_name");
                password = rs.getString("Lib_password");
            }
            dbConnect.close();
        } catch (SQLException e) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        if (tf_username.getText().isEmpty() || pf_password.getText().isEmpty()){
            label_error.setText("Username/password is empty!");
        }else if (tf_username.getText().equals(username) && pf_password.getText().equals(pw.decrypt(password))){
            Parent root = FXMLLoader.load(getClass().getResource("LibrarianScene.fxml"));
            Stage window = (Stage) login.getScene().getWindow();
            window.setScene(new Scene(root));
        }else {
            label_error.setText("Invalid username or password!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
