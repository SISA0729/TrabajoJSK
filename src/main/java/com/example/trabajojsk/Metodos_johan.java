package com.example.trabajojsk;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import com.example.trabajojsk.Controller.Controller.*;
import static com.example.trabajojsk.Controller.Controller.Crear_y_comprobar_fichero;

public class Metodos_johan {

    public static void main(String[] args) {



        System.out.println(Arrays.toString(verPuntos("sisa","1234")));
    }


    /**
     *  Este metodo (ComprobarUsuarios) nos ayuda ah verificar si los usuarios estan en nuestra base de datos (fichero);
     *  Recive paremetos nombre, contraseña;
     *  y este metodo devuelve un booolean
     *
     */
    public static int ComprobarUsuario (String nombre , String contraseña) {
        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt";
        ArrayList<String> usuario_Contraseña = new ArrayList<>();
        File fichero = new File(rutaFichero.trim());
        String[] pepe = new String[0];
        if (Crear_y_comprobar_fichero(rutaFichero)) {
            Scanner lector = null;
            try {
                lector = new Scanner(fichero);
                while (lector.hasNext()) {
                    String linea = lector.nextLine();
                    String[] partes = linea.split(";");
                    if (partes.length == 2) {
                        String clave = partes[0].trim();
                        String valor = partes[1].trim();
                        pepe = new String[]{clave, valor};
                        if (pepe[1].equals(nombre)) {
                            if (pepe[0].equals(contraseña)) {
                                return 2; // usuário registrado, con la contraseña y el usuario correctos.
                            } else {
                                return 1; // usuário registrado,sin embargo la contraseña está incorrecta.
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("No encuentro el fichero " + e.getMessage());
            }
        } else {
            System.out.println("no entro");
        }
        return 0; // usuario no registrado
    }

        /*
        * cearYComprobarfichero nos ayuda a crear y ver si la ruta esta bien formulada
        * */
         public static File crearYComprobarFichero(String rutaFichero) {
            // Implementar la lógica para crear y comprobar el fichero
            // Retornar true si el fichero existe y es válido, de lo contrario, false.
             File fichero = new File(rutaFichero.trim());
             fichero.exists();
            return fichero;
        }
        /* este metodo subirpuntosGrafica nos muestra los puntos que tiene en entos momentos los usuarios */
        public static void MostrarpuntosGrafica (LineChart<?, ?> lista_puntos,String nombre,String contraseña){
            int comprobarResultado = ComprobarUsuario(nombre,contraseña);
            if (comprobarResultado == 2){

                Object[] puntos = verPuntos(nombre,contraseña);


                XYChart.Series series = new XYChart.Series<>();
                series.getData().add(new XYChart.Data("1",puntos[1]));
                series.getData().add(new XYChart.Data("2",puntos[2]));
                series.getData().add(new XYChart.Data("4",puntos[3]));
                series.getData().add(new XYChart.Data("4",puntos[4]));



                lista_puntos.getData().add(series);
                series.setName((String) puntos[0]);
            }


        }


    public static Object[] verPuntos (String nombre , String contraseña) {

        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Puntos.txt";
        Scanner johan = new Scanner(System.in);
        ArrayList<String> usuario_Contraseña = new ArrayList<>();
        File fichero = new File(rutaFichero.trim());

        int [] puntos = new int[0];
        if (Crear_y_comprobar_fichero(rutaFichero)) {
            Scanner lector = null;
            try {
                lector = new Scanner(fichero);
                while (lector.hasNext()) {
                    String linea = lector.nextLine();
                    String[] partes = linea.split(",");
                    if (partes.length == 5) {
                        String usuario = partes[0].trim();
                        int punto1 = Integer.parseInt(partes[1]);
                        int punto2 = Integer.parseInt(partes[2]);
                        int punto3 = Integer.parseInt(partes[3]);
                        int punto4 = Integer.parseInt(partes[4]);


                        Object[] pepe = new Object[]{usuario,punto1,punto2,punto3,punto4};

                      ;


                        if (contains(pepe,nombre)) {

                                return pepe;

                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("No encuentro el fichero " + e.getMessage());
            }
        } else {
            System.out.println("no entro");
        }
        return null;
    }

    // Método para verificar si un nombre está en el arreglo de objetos
    public static boolean contains(Object[] array, String nombre) {
        for (Object obj : array) {
            if (obj instanceof String && ((String) obj).equals(nombre)) {
                return true;
            }
        }
        return false;
    }




}
