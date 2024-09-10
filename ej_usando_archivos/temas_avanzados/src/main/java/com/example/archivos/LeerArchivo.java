package com.example.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo {

    public static void main(String[] args) {
        //Leer archivo
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);

        try {
            System.out.println("Contenido del archivo");
            var entrada = new BufferedReader(new FileReader(archivo));
            //leemos linea a linea
            var linea = entrada.readLine();
            //leemos todas las lineas 
            while (linea != null) {
                System.out.println(linea);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error al leer archivo " + e.getMessage());
        }
    }
}
