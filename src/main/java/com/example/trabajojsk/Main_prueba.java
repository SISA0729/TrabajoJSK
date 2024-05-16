package com.example.trabajojsk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.example.trabajojsk.Controller.Crear_y_comprobar_fichero;

public class Main_prueba {

    public static void main(String[] args) {




        String rutaFichero = "src\\main\\java\\com\\example\\trabajojsk\\Ficheros";
        HashMap<Integer, String> Usuarios_Contraseñas = new HashMap<>();

        if (Crear_y_comprobar_fichero(rutaFichero)){

            Scanner lector = null;

        try {
            File fichero = new File(rutaFichero + "\\Usuarios");
            lector = new Scanner(fichero);
            while (lector.hasNext()){
                String linea = lector.nextLine();
                String[] partes = linea.split(";");
                if (partes.length == 2){
                    System.out.println("entro");
                    int clave = Integer.parseInt(partes[0].trim());
                    String valor = partes[1].trim();
                    Usuarios_Contraseñas.put(clave , valor);
                }

                for (Map.Entry<Integer, String> entrada : Usuarios_Contraseñas.entrySet()) {
                    System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
                }

            }
        }catch (FileNotFoundException e){
            System.out.println("No encuentro el fichero" + e.getMessage());
        }

    } else {
            System.out.println("no entro");
        }

}
}
