package com.example.trabajojsk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static com.example.trabajojsk.Controller.Controller.Crear_y_comprobar_fichero;

public class Metodos_johan {

    public static void main(String[] args) {

        Scanner johan = new Scanner(System.in);
        System.out.println(ComprobarUsuario(johan.nextLine(), johan.nextLine()));
    }


    /**
     *  Este metodo (ComprobarUsuarios) nos ayuda ah verificar si los usuarios estan en nuestra base de datos (fichero);
     *  Recive paremetos nombre, contraseña;
     *  y este metodo devuelve un booolean
     *
     */
    public static boolean ComprobarUsuario (String nombre , String contraseña) {

        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt";
        Scanner johan = new Scanner(System.in);
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
                                return true;
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
        return false;
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

}
