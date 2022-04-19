package oop.librarysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewBorrowbooks extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BorrowBook.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setTitle("Hello! Team Apple");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    }

