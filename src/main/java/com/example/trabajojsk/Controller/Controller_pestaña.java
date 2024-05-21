package com.example.trabajojsk.Controller;

import com.example.trabajojsk.POO.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.trabajojsk.Metodos_johan.*;
import static com.example.trabajojsk.Metodos_johan.colocar_el_usuario_Actual;

public class Controller_pestaña implements Initializable {

    private Usuario usuario;


    @FXML
    private ArrayList<Usuario> usuarios;

    @FXML
    private TextField textLocalidad;



    @FXML
    private LineChart<Number, Number> lista_puntos;

    @FXML
    private void eventSalir(ActionEvent event){
        eliminar_usuario_actual();
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

        //ArrayList<Usuario> usuario = carregarUsuariosDoArquivo();



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
        usuarios = new ArrayList<>();


    }


    public static boolean Crear_y_comprobar_fichero (String ruta){
        File fichero = new File(ruta);
        return fichero.exists();
    }
    @FXML
    private TextField user;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        lista_puntos.getData().clear(); // Limpiar los datos antiguos

        // System.out.println(carregarUsuariosDoArquivo().get(1));


        Object[] puntos = verPuntos(colocar_el_usuario_Actual(),"1234");


        XYChart.Series series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data(1,puntos[1]));
        series.getData().add(new XYChart.Data(2,puntos[2]));
        series.getData().add(new XYChart.Data(3,puntos[3]));
        series.getData().add(new XYChart.Data(4,puntos[4]));




        series.setName(colocar_el_usuario_Actual());


        lista_puntos.getData().add(series);
    }

    @FXML
    public void abrirCancha() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/trabajojsk/cancha.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void eventMenu(ActionEvent event) throws IOException {
        Object menuzinho = event.getSource();
        Node node = (Node) menuzinho;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public Usuario getUsuario() {
        return this.usuario;
    }




}
