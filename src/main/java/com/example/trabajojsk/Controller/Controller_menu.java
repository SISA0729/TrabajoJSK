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
    public TextField nombre;
    @FXML
    public TextField nombreUsuario2;
    @FXML
    public TextField contraseña;
    @FXML
    public TextField correoElectronico;
    @FXML
    public TextField nombreUsuario1;
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
            nombreUsuario1.setText(usuario.getUsuario());
            nombreUsuario2.setText(usuario.getUsuario());
            contraseña.setText(usuario.getContraseña());
            correoElectronico.setText(usuario.getCorreoElectronico());
        }

    }


}
