package com.example.trabajojsk.Controller;

import com.example.trabajojsk.POO.Usuario;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

import static com.example.trabajojsk.Controller.Controller.*;

public class Controller_menu {
    @FXML
    public Controller registroController;

    public Controller_menu() {
        this.registroController = new Controller();
    }


    @FXML
    public Button buttonEsc;
    @FXML
    public Button buttonMiCuenta;
    @FXML
    public Button buttonCerrarSesión;
    @FXML
    public Button buttonPerfil;
    @FXML
    public TextFlow nombre;
    @FXML
    public TextFlow nombreUsuario2;
    @FXML
    public TextFlow contraseña;
    @FXML
    public TextFlow correoElectronico;
    @FXML
    public TextFlow nombreUsuario1;
    @FXML
    private Button inicio;
    @FXML
    private Button salir;


    @FXML
    private ObservableList<String> listaNombreData = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> nombreUsuario2Data = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> listaContraseñaData = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> listaCorreoData = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> nombreUsuarioData = FXCollections.observableArrayList();



    @FXML
    public void eventInicio(ActionEvent actionEvent) {
    }

    @FXML
    private void eventSalir(ActionEvent event){
        System.exit(0);
    }


    @FXML
    public void eventListaNombre(ListView.EditEvent editEvent) {
    }

    @FXML
    public void eventNombreUsuario2(ListView.EditEvent editEvent) {
    }

    @FXML
    public void eventListaContraseña(ListView.EditEvent editEvent) {
    }

    @FXML
    public void eventCorreo(ListView.EditEvent editEvent) {
    }

    @FXML
    public void eventNombreUsuario(ListView.EditEvent editEvent) {
    }

    @FXML
    public void eventEsc(ActionEvent actionEvent) {
    }

    @FXML
    public void eventMiCuenta(ActionEvent actionEvent) {
    }

    @FXML
    public void eventCerrarSesión(ActionEvent actionEvent) {
    }

    @FXML
    public void eventPerfil(ActionEvent actionEvent) {
    }

    public void setRegistroController(Controller registroController) {
        this.registroController = registroController;
    }

    @FXML
    public void initialize() {
        ArrayList<Usuario> usuarios = registroController.carregarUsuariosDoRegistro();
        Usuario usuario1 = registroController.carregarUsuariosDoRegistro().get(0);
        if (usuario1 != null) {
            Usuario usuario = usuarios.get(0);

            Text text1 = new Text(usuario.getUsuario());
            nombreUsuario1.getChildren().clear();
            nombreUsuario1.getChildren().add(text1);

            Text text2 = new Text(usuario.getUsuario());
            nombreUsuario2.getChildren().clear();
            nombreUsuario2.getChildren().add(text2);

            Text text3 = new Text(usuario.getContraseña());
            contraseña.getChildren().clear();
            contraseña.getChildren().add(text3);

            Text text4 = new Text(usuario.getCorreoElectronico());
            correoElectronico.getChildren().clear();
            correoElectronico.getChildren().add(text4);

            Text text5 = new Text(usuario.getNombre() +" "+ usuario.getApellidos());
            nombre.getChildren().clear();
            nombre.getChildren().add(text5);

        }

    }


}
