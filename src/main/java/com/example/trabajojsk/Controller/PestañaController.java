package com.example.trabajojsk.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class PestañaController implements Initializable {
    @FXML
    private TextField textLocalidad;
    @FXML
    private Button botonFutbol;
    @FXML
    private Button botonBaloncesto;
    @FXML
    private Button inicio;
    @FXML
    private Button salir;

    @FXML
    private void eventSalir(ActionEvent event){
        System.exit(0);
    }
    @FXML
    private void eventInicio(ActionEvent event) throws IOException {


        Object f = event.getSource();
        Node node = (Node) f;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/pestaña.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private void eventBaloncesto(ActionEvent event) throws IOException {
        Object f = event.getSource();
        Node node = (Node) f;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/baloncesto.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private void eventFutbol(ActionEvent event) throws IOException {
        Object f = event.getSource();
        Node node = (Node) f;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/futbol.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private void eventLocalidad(KeyEvent event){
        String buscar = textLocalidad.getText().trim();
        if (!buscar.equals("")){
            System.out.println(buscar);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
