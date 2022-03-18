package oop.librarysystem;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewBooksController {
    @FXML
    public TableView books;
    public TableColumn bookName;
    public TableColumn bookType;
    public TableColumn bookAuthor;
    public TableColumn bookYear;
}
