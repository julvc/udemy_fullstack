package com.example.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AgregarContenido {
    public static void main(String[] args) {
        boolean anexar = false;
        var nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);

        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            var nuevoContenido = "Nuevo\nContenido";
            salida.println(nuevoContenido);
            salida.close();
            System.err.println("Se agregaron nuevos");
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
