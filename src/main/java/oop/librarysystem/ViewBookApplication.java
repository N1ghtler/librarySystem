package oop.librarysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewBookApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello! Team Apple");
        stage.setScene(scene);
        stage.show();
    }
}
