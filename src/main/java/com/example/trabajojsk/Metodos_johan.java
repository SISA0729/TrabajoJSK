package com.example.trabajojsk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static com.example.trabajojsk.Controller.Crear_y_comprobar_fichero;

public class Metodos_johan {

    public static void main(String[] args) {

        Scanner johan = new Scanner(System.in);
        System.out.println(ComprobarUsuario(johan.nextLine(), johan.nextLine()));
    }


    /**
     *  Este metodo (ComprobarUsuarios) no ayuda ah verificar si los usuarios estan en nuestra base de datos (fichero);
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
                        if (pepe[1].equalsIgnoreCase(nombre)) {
                            if (pepe[0].equalsIgnoreCase(contraseña)) {
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
        private static boolean crearYComprobarFichero(String rutaFichero) {
            // Implementar la lógica para crear y comprobar el fichero
            // Retornar true si el fichero existe y es válido, de lo contrario, false.
            return new File(rutaFichero).exists();
        }

}
