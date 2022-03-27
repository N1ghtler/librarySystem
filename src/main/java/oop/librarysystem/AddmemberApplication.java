package oop.librarysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddmemberApplication extends Application {

    @Override
    public void start(Stage stage)throws IOException  {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Add-member.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello! Team Apple");
            stage.setScene(scene);
            stage.show();
        }
    public static void main(String[] args) {
        launch(args);
    }

    }

