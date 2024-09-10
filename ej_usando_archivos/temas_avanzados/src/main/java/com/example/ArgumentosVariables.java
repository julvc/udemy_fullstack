package com.example;
public class ArgumentosVariables {
    public static void main(String[] args) {
        imprimirNumeros(1,2,3,4,5);
        variosParametros("Nombre NULL", 1,2,3,4);
    }

    //ARGUMENTOS VARIABLES
    static void variosParametros(String nombre, int... numeros){
        System.out.println("Hola, "+nombre);
        imprimirNumeros(numeros);
    }


    static void imprimirNumeros(int... numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i] + " ");
        };
    }
}
