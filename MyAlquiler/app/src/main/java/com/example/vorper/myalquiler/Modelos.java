package com.example.vorper.myalquiler;

import android.view.View;

import java.io.Serializable;

public class Modelos implements Serializable{
    private String modelo;
    private String marca;
    private String enviado;
    private float precio;
    private float precioTotal;
    private boolean aire;
    private boolean gps;
    private boolean radio;
    private float horas;
    private int imagen;
    public Modelos(String modelo,String marca,float precio,boolean aire,boolean gps, boolean radio,float horas,int imagen){
        this.modelo=modelo;
        this.marca=marca;
        this.precio=precio;
        this.aire=aire;
        this.gps=gps;
        this.radio=radio;
        this.horas=horas;
        this.imagen = imagen;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return this.modelo;
    }
    public void setEnviado(String enviado){
        this.enviado = enviado;
    }
    public String getEnviado(){
        return this.enviado;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return this.precio;
    }
    public void setPrecioTotal(float precioTotal){
        this.precio = precioTotal;
    }
    public float getPrecioTotal(){
        return this.precioTotal;
    }
    public void setAire(boolean aire){
        this.aire=aire;
    }
    public boolean getAire(){
        return this.aire;
    }
    public void setGPS(boolean gps){
        this.gps=gps;
    }
    public boolean getGPS(){
        return this.gps;
    }
    public void setRadioDVD(boolean radio){
        this.radio=radio;
    }
    public boolean getRadioDVD() {
        return this.radio;
    }
    public void setHoras(float horas){
        this.horas=horas;
    }
    public float getHoras(){
        return this.horas;
    }
    public int getView(){
        return this.imagen;
    }
    public String toString(){
        return "Modelo: " + this.modelo + ". Marca: " + this.marca + " Precio: "
                + this.precio+ ". : " + this.precio +
                ". Aire: " + this.aire + ".GPS: " + this.gps+". Radio/DVD "+this.radio;
    }
}




