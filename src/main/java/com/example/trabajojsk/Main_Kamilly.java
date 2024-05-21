package com.example.trabajojsk;

import com.example.trabajojsk.POO.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main_Kamilly {
   public  static String rutaFichero = "src/main/java/com/example/trabajojsk/Ficheros/Usuarios.txt";
    public  static void main (String[] args){
        //ArrayList<Usuario> usuarios = comprobarUsuarioKami();
        System.out.println(getUsuario_Actual());
        String nomeUsuarioAtual = getUsuario_Actual();
        System.out.println(nomeUsuarioAtual);
    }

    public static ArrayList<Usuario> comprobarUsuarioKami () {
        File fileLector = new File(rutaFichero);

        Scanner lector = null;

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String usuario = null;
        String contraseña = null;

        try{
            lector = new Scanner(fileLector);
            while (lector.hasNext()){
                String linea = lector.nextLine();
                String [] campos = linea.split(";");

                usuario = campos[1];
                contraseña = campos[0];
                listaUsuarios.add(new Usuario(usuario,contraseña));
            }

            for (Usuario cada : listaUsuarios){
                System.out.println(cada);
            }

        }catch (FileNotFoundException e){
            System.out.println("Ha salido error de exception en ese codigo, o sea, no encuentra el fichero"+ e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Outras exceptiones.." +e.getMessage());
            e.printStackTrace();
        }finally {

        }

        return listaUsuarios;
    }
    private static boolean crearYComprobarFichero(String rutaFichero) {
        // Implementar la lógica para crear y comprobar el fichero
        // Retornar true si el fichero existe y es válido, de lo contrario, false.
        return new File(rutaFichero).exists();
    }

    public static String getUsuario_Actual (){
        try{
            File usuarioActual = new File("src/main/java/com/example/trabajojsk/Ficheros/Usuario_Actual.txt");
            Scanner leerUsuario = new Scanner(usuarioActual);

            while (leerUsuario.hasNext()) {
                String linea = leerUsuario.nextLine();

                return linea;
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}
