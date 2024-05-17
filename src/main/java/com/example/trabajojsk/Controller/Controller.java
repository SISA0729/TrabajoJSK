package com.example.trabajojsk.Controller;

import com.example.trabajojsk.POO.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.controlsfx.control.action.Action;
import org.kordamp.bootstrapfx.scene.layout.Panel;


import static com.example.trabajojsk.Metodos_johan.ComprobarUsuario;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private HBox panel1;
    @FXML
    private Hyperlink link;
    @FXML
    private Hyperlink flecha;

    @FXML
    private TextField textUsuario;
    @FXML
    private TextField textContrasena;

    @FXML
    private Button botonIniciar;
    @FXML
    private Button INICIARK;

    @FXML
    private void eventkey(KeyEvent event){

    }

    @FXML
    private void eventContinuar(){
        String nombre = textUsuario.getText();
        String contra = textContrasena.getText();
        Usuario usuario = new Usuario(nombre,contra);

        File fichero = new File("src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(fichero,true);
            fw.append("\n"+contra+";");
            fw.append(nombre+ " ");
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
    private void eventFlecha(ActionEvent event) throws IOException {

        Object f = event.getSource();
        Node node = (Node) f;
        Scene scene1 = node.getScene();
        Window window = scene1.getWindow();
        Stage stage = (Stage) window;

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/inicio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void eventAction(ActionEvent event) throws IOException {
        panel1.getStylesheets().add("src\\main\\java\\com\\example\\trabajojsk\\Estilos\\estilo1.css");

        String nombre = textUsuario.getText();
        String contraseña = textContrasena.getText();
        String rutaFichero = "src\\main\\java\\com\\example\\trabajojsk\\Ficheros";
        Crear_y_comprobar_fichero(rutaFichero);

        

        if (ComprobarUsuario(nombre, contraseña)){
            Object o = event.getSource();
            Node node = (Node) o;
            Scene scene1 = node.getScene();
            Window window = scene1.getWindow();
            Stage stage = (Stage) window;

            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/pestaña.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText("Usuario no registrado");
            alert.setContentText("Crea un usuario para poder acceder");
            alert.show();

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public static boolean Crear_y_comprobar_fichero (String ruta){
        File fichero = new File(ruta);
       return fichero.exists();    
    }


}