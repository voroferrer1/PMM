package com.example.vorper.myalquiler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class PantallaDibujo extends Activity {
    View vista;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(new EjemploView(this));
        vista = (View) findViewById(R.id.miCanvas);
        setContentView(R.layout.activity_pantalla_dibujo);
    }
}