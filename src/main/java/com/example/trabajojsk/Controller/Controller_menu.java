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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.trabajojsk.Controller.Controller.*;
import static com.example.trabajojsk.Metodos_johan.octener_el_usuario_actual;
import static com.example.trabajojsk.Controller.Controller_pestaña.Crear_y_comprobar_fichero;
import static com.example.trabajojsk.Main_Kamilly.getUsuario_Actual;

public class Controller_menu {
    @FXML
    public Controller registroController;

    private Usuario usuarioAtual;

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
        String nomeUsuarioAtual = getUsuario_Actual();
        if (nomeUsuarioAtual == null) {
            System.out.println("Não foi possível obter o nome do usuário atual.");
            return;
        }
        nomeUsuarioAtual = nomeUsuarioAtual.trim();
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(nomeUsuarioAtual)) {
                usuario = u;
                break;
            }
        }
        if (usuario == null) {
            System.out.println("O usuário atual não foi encontrado na lista de usuários.");
            return;
        }
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
