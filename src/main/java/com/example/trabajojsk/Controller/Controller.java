package com.example.trabajojsk.Controller;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;


import com.example.trabajojsk.Metodos_johan;
import com.example.trabajojsk.POO.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.controlsfx.control.action.Action;
import org.kordamp.bootstrapfx.scene.layout.Panel;


import static com.example.trabajojsk.Metodos_johan.*;

import static com.example.trabajojsk.Main_Kamilly.comprobarUsuarioKami;


import java.io.*;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {
    @FXML
    private HBox panel1;

    @FXML
    private Hyperlink link;

    @FXML
    private Hyperlink flecha;

    @FXML
    public TextField textUsuario;

    @FXML
    private TextField textContrasena;

    @FXML
    private Button botonIniciar;

    @FXML
    private Button INICIARK;

    @FXML
    private ArrayList<Usuario> usuarios;

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
    private  Button handleButtonAction;

    @FXML
    private LineChart<Number, Number> lista_puntos;


    /**
     * ===================================== INICIO Y REGISTRO  ======================================================
     */
    @FXML
    private void eventkey(KeyEvent event){

    }


    @FXML
    private void eventContinuar(ActionEvent event) throws IOException {
        //creando el usuario
        String nombre = textUsuario.getText();
        String contra = textContrasena.getText();
        Usuario usuario = new Usuario(nombre,contra);

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
        try (FileWriter fw = new FileWriter(crearYComprobarFichero(rutaFichero), true)) {
            fw.append(usuario.getContraseña() + ";" + usuario.getUsuario() + "\n");
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
    /**
     * ===============================================================================================================
     */


    /**
     * ========================================= PESTAÑA PRINCIPAL  =============================================
     */

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
        carregarUsuariosDoArquivo();

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




        series.setName("JOHAN");


        lista_puntos.getData().add(series);
    }






}