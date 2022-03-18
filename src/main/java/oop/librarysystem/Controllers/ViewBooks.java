package oop.librarysystem.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewBooks {
    @FXML
    public TableView books;
    public TableColumn bookName;
    public TableColumn bookType;
    public TableColumn bookAuthor;
    public TableColumn bookYear;
}
