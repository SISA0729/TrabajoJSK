package com.example.trabajojsk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static com.example.trabajojsk.Controller.Crear_y_comprobar_fichero;

public class Main_prueba {

    public static void main(String[] args) {
        Scanner johan = new Scanner(System.in);
        ComprobarUsuario(johan.nextLine(), johan.nextLine());



    }

    public static boolean ComprobarUsuario (String nombre , String contraseña){
        Scanner johan = new Scanner(System.in);

        String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt";
        ArrayList<String> usuario_Contraseña = new ArrayList<>();
        File fichero = new File(rutaFichero);
        String[] pepe = new String[0];

        if (Crear_y_comprobar_fichero(rutaFichero)){

            Scanner lector = null;


            try {
                lector = new Scanner(fichero);

                while (lector.hasNext()){
                    String linea = lector.nextLine();
                    String[] partes = linea.split(";");

                    if (partes.length == 2){

                        String clave = partes[0].trim();
                        String valor = partes[1].trim();
                        pepe = new String[]{clave, valor};
                        if (pepe[1].equalsIgnoreCase(nombre)){
                            if (pepe[0].equalsIgnoreCase(contraseña)){
                                System.out.println("coronamos");
                                return true;
                            }

                        }

                    }



                }
            }catch (FileNotFoundException e){
                System.out.println("No encuentro el fichero " + e.getMessage());
            }

        } else {
            System.out.println("no entro");
        }

        return false;
    }
}
