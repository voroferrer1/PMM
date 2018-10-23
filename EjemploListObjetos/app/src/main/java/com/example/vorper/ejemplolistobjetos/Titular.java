package com.example.vorper.ejemplolistobjetos;



public class Titular {
    private String titulo;
    private String subtitulo;
    private int imagen;
    public Titular(String tit,String sub, int image){
        titulo=tit;
        subtitulo=sub;
        imagen = image;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
    public int getImage(){
        return imagen;
    }
}
