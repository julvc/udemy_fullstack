package com.example;

public class Abstracta {
    public static void main(String[] args) {
        //FiguraGeometrica figuraGeometrica = new FiguraGeometrica(); //no se puede instanciar
        FiguraGeometrica figuraGeometrica = new Rectangulo();
        figuraGeometrica.dibujar();
        figuraGeometrica = new Circulo();
        figuraGeometrica.dibujar();
    }
}

//Clases abstractas
abstract class FiguraGeometrica {
    public abstract void dibujar();
}

class Rectangulo extends FiguraGeometrica{
    public void dibujar(){
        System.out.println("Dibujando un rectángulo");
    }
}

class Circulo extends FiguraGeometrica{
    public void dibujar(){
        System.out.println("Dibujando un circulo");
    }
}