package com.example.savanna.controller;

import com.example.savanna.HelloApplication;
import com.example.savanna.model.Student;
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
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Parent root;

    private Stage stage;

    private Scene scene;

    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> matricNo;

    final ObservableList<Student> studentObservableList = FXCollections.observableArrayList(
            new Student("Liu MingShan", "17116756/1"),
            new Student("Nathaniel Ong Yii Tak", "17072712/1"),
            new Student("Tan Jia Qin", "17142247/1"),
            new Student("Tan Jia Yue", "17114152/1"),
            new Student("Yap Jing Hong", "17085918/1")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        matricNo.setCellValueFactory(new PropertyValueFactory<>("matricNo"));
        table.setItems(studentObservableList);
    }

    @FXML
    protected void switchToMainView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("view/main-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void exitApplication() {
        System.exit(0);
    }

}