package com.example.trabajojsk.Controller;

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
    private TextField textUsuario;
    @FXML
    private TextField textContrasena;

    @FXML
    private Button botonIniciar;
    @FXML
    private Button INICIARK;

    @FXML
    private ArrayList<Usuario> usuarios;

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

    private void carregarUsuariosDoArquivo() {
        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt";
        try (Scanner lector = new Scanner(crearYComprobarFichero(rutaFichero))) {
            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String contraseña = partes[0].trim();
                    String usuario = partes[1].trim();
                    usuarios.add(new Usuario(usuario, contraseña));
                }
            }
        } catch (FileNotFoundException e) {
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
        String nombre = textUsuario.getText();
        String contraseña = textContrasena.getText();
        String rutaFichero = "src\\main\\java\\com\\example\\trabajojsk\\Ficheros";
        Crear_y_comprobar_fichero(rutaFichero);

        int comprobarResultado = ComprobarUsuario(nombre,contraseña);



        if (comprobarResultado == 2){
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
        Metodos_johan.MostrarpuntosGrafica(lista_puntos,textUsuario.getText(),textContrasena.getText());

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




}