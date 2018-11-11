package com.example.usuario.mytemplateexamen;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.annotation.Target;

public class Pantalla2 extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        Intent intent = getIntent();
        final TextView string1 = (TextView)findViewById(R.id.string21);
        final TextView string2 = (TextView)findViewById(R.id.string22);
        final TextView string3 = (TextView)findViewById(R.id.string23);
        final TextView float1 = (TextView)findViewById(R.id.float21);
        final TextView float2 = (TextView)findViewById(R.id.float22);
        final ImageView imagen2 = (ImageView)findViewById(R.id.imagen2);
        final Button volver = (Button)findViewById(R.id.volver);
        ClaseObjetos objeto = (ClaseObjetos) intent.getSerializableExtra("Objeto");
        float float3 = objeto.getSegundaVariableFloat() +objeto.getPrimeraVariableFloat();
        string1.setText(objeto.getPrimerString());
        string2.setText(objeto.getSegundoString());
        float1.setText(String.valueOf(objeto.getPrimeraVariableFloat()));
        string3.setText(objeto.getTercerString());
        imagen2.setBackground(getDrawable(objeto.getImagen()));
        if(objeto.getPrimeraVariableBool()==true){
            float3 += 5;
        }
        if(objeto.getSegundaVariableBool()==true){
            float3 += 7;
        }
        if(objeto.getTercerString().equalsIgnoreCase("tercero")){
            float3 +=5;
        }else{
            float3 +=20;
        }
        float2.setText(String.valueOf(float3));
        volver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Pantalla2.this,Pantalla1.class);
                startActivity(intent);
            }
        });


    }
}
