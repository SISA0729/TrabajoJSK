package com.example.trabajojsk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Hyperlink link;

    @FXML
    private TextField textUsuario;
    private TextField textContrasena;

    @FXML
    private Button botonIniciar;

    @FXML
    private void eventkey(KeyEvent event){

    }
    @FXML
    private void eventLink(ActionEvent event) throws IOException {

        Object s = event.getSource();
        Node node = (Node) s;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/registro.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private void eventAction(ActionEvent event) throws IOException {

        Object o = event.getSource();
        Node node = (Node) o;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/pestaña.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}