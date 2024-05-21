package com.example.trabajojsk.Controller;

import com.example.trabajojsk.POO.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Controller_menu {
    @FXML
    public Controller registroController;
    @FXML
    public ListView<String> listaNombre;
    @FXML
    public ListView<String> nombreUsuario2;
    @FXML
    public ListView<String> listaCOntraseña;
    @FXML
    public ListView<String> listaCorreo;
    @FXML
    public ListView<String> nombreUsuario;
    @FXML
    public Button buttonEsc;
    @FXML
    public Button buttonMiCuenta;
    @FXML
    public Button buttonCerrarSesión;
    @FXML
    public Button buttonPerfil;
    @FXML
    private Button inicio;
    @FXML
    private Button salir;

    private ObservableList<String> listaNombreData;
    private ObservableList<String> nombreUsuario2Data;
    private ObservableList<String> listaCOntraseñaData;
    private ObservableList<String> listaCorreoData;
    private ObservableList<String> nombreUsuarioData;



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
        if (registroController != null) {
            Usuario usuario = registroController.getUsuario();
            setUsuario(usuario);
        }
    }

    public void setUsuario(Usuario usuario) {
        listaNombre.setItems(FXCollections.observableArrayList(usuario.getNombre()));
        nombreUsuario2.setItems(FXCollections.observableArrayList(usuario.getApellidos()));
        listaCOntraseña.setItems(FXCollections.observableArrayList(usuario.getContraseña()));
        listaCorreo.setItems(FXCollections.observableArrayList(usuario.getCorreoElectronico()));
        nombreUsuario.setItems(FXCollections.observableArrayList(usuario.getUsuario()));


    }




}
