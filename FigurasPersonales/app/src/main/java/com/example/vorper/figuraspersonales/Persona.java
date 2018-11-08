package com.example.vorper.figuraspersonales;

public class Persona {
    String nombre;
    String apellido;
    int edad;
    public Persona(String eNombre,String eApellido,int eEdad){
        this.nombre = eNombre;
        this.apellido = eApellido;
        this.edad = eEdad;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }
}
