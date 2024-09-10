package com.example;

import java.io.Serializable;

public class JavaBeans {
    public static void main(String[] args) {
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        System.out.println(persona);
        System.out.println(persona.getNombre());
        System.out.println(persona.getApellido());
    }
}

class Persona implements Serializable{
    private String nombre;
    private String apellido;
    
    public Persona(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
}
