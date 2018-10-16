package com.example.vorper.ejemplolistobjetos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos= new Titular[]{
        new Titular("Titulo 1","Subtitulo largo 1")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
class AdaptadorTitulares extends ArrayAdapter {
    Activity context;

    AdaptadorTitulares(Activity context) {
        super(context, R.layout.listitem_titular, datos);
        this.context = context;

    }
}
class Titular{
    private String titulo;
    private String subtitulo;

    public Titular(String tit,String sub){
        titulo=tit;
        subtitulo=sub;

    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
}


