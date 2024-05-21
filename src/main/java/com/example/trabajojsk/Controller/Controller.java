package com.example.trabajojsk.Controller;

import java.io.*;

import java.net.URL;
import java.util.*;



import com.example.trabajojsk.POO.Usuario;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.chart.LineChart;
import javafx.scene.control.*;

import javafx.scene.input.KeyEvent;



import javafx.stage.Stage;
import javafx.stage.Window;




import static com.example.trabajojsk.Controller.Controller_pestaña.Crear_y_comprobar_fichero;
import static com.example.trabajojsk.Metodos_johan.*;

public class Controller implements Initializable {


    @FXML
    public TextField textUsuario;

    @FXML
    private TextField textContrasena;


    @FXML
    private ArrayList<Usuario> usuarios;


    public Controller() {
        this.usuarios = new ArrayList<>();
    }

    //NUEVOS

    @FXML
    public TextField textNombre;
    @FXML
    public TextField teextApellidos;
    @FXML
    public TextField textCorreo;
    @FXML
    public Button botonContinuar;

    @FXML
    private TextField textLocalidad;

    @FXML
    private LineChart<Number, Number> lista_puntos;
    @FXML
    private Button botonIniciar;
    private Usuario usuario;




    /**
     * ===================================== INICIO Y REGISTRO  ======================================================
     */
    @FXML
    private void eventkey(KeyEvent event){

    }


    @FXML
    private void eventContinuar(ActionEvent event) throws IOException {
        //creando el usuario
        String nombre = textNombre.getText();
        String apellidos = teextApellidos.getText();
        String correo = textCorreo.getText();
        String usuarioNombre = textUsuario.getText();
        String contra = textContrasena.getText();
        Usuario usuario = new Usuario(nombre, apellidos, correo, usuarioNombre, contra);

        if (usuarios.contains(usuario)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Usuario ya está registrado");
            alert.setContentText("Por favor, cree otro nombre de usuario para poder acceder");
            alert.show();
        } else {
            usuarios.add(usuario);
            escreverUsuariosNoArquivo(usuario);

            Object s = event.getSource();
            Node node = (Node) s;
            Scene scene1 = node.getScene();
            Window window = scene1.getWindow();
            Stage stage = (Stage) window;

            Parent root = FXMLLoader.load(getClass().getResource("/com/example/trabajojsk/inicio.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
    }


    private void escreverUsuariosNoArquivo(Usuario usuario) {
        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt";
        String rutaPuntos = "src/main/java/com/example/trabajojsk/Ficheros/Puntos.txt";
        String rutaRegistro = "src/main/java/com/example/trabajojsk/Ficheros/Registro.txt";
        try (FileWriter fw = new FileWriter(crearYComprobarFichero(rutaFichero), true)) {
            fw.append(usuario.getContraseña() + ";" + usuario.getUsuario() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter puntos_subir = new FileWriter((rutaPuntos),true)){
            puntos_subir.append(usuario.getUsuario() + ",0,0,0,5" + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fw = new FileWriter(crearYComprobarFichero(rutaRegistro), true)) {
            fw.append("\n"+usuario.getNombre() + ";" + usuario.getApellidos() + ";" +usuario.getCorreoElectronico() + ";" +usuario.getUsuario()+ ";" +usuario.getContraseña());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Usuario> carregarUsuariosDoArquivo() {
        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt";
        try (Scanner lector = new Scanner(crearYComprobarFichero(rutaFichero))) {
            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String contraseña = partes[0].trim();
                    String usuario = partes[1].trim();
                    usuarios.add(new Usuario(usuario, contraseña));
                    return usuarios;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ArrayList<Usuario> carregarUsuariosDoRegistro() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Registro.txt";
        try (Scanner lector = new Scanner(new File(rutaFichero))) {
            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(";");
                if (partes.length >= 5) {
                    String contraseña = partes[4].trim();
                    String usuario = partes[3].trim();
                    String nombre = partes[0].trim();
                    String apellidos = partes[1].trim();
                    String correo = partes[2].trim();
                    usuarios.add(new Usuario(nombre,apellidos,correo,usuario,contraseña));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
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
        String nombre = textUsuario.getText();
        String contraseña = textContrasena.getText();
        String rutaFichero = "src\\main\\java\\com\\example\\trabajojsk\\Ficheros";
        Crear_y_comprobar_fichero(rutaFichero);

        int comprobarResultado = ComprobarUsuario(nombre, contraseña);


        if (comprobarResultado == 2) {

            octener_el_usuario_actual(nombre);





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

            if (comprobarResultado == 0){
                alert.setHeaderText("Usuario no registrado");
                alert.setContentText("Crea un usuario para poder acceder");
            } else if (comprobarResultado == 1) {
                alert.setHeaderText("Contraseña incorrecta");
                alert.setContentText("Digite la contraseña correcta para poder acceder");
            }

            alert.show();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarios = new ArrayList<>();
        carregarUsuariosDoArquivo();
        carregarUsuariosDoArquivo();
    }

    public Usuario getUsuario() {
        return this.usuario;
    }


    /**
     * ===============================================================================================================
     */


    /**
     * ========================================= PESTAÑA PRINCIPAL  =============================================
     */







}