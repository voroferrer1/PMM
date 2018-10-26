package com.example.vorper.midibujo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(new EjemploView(this));
        setContentView(R.layout.activity_main);
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
        }
        public EjemploView(Context contexto, AttributeSet atts) {
            super(contexto,atts);

        }
        private ShapeDrawable miDrawable;
        protected void onDraw(Canvas canvas) {
            Paint pincelA = new Paint();
            pincelA.setColor(Color.BLUE);
            pincelA.setStrokeWidth(100);
            pincelA.setStyle(Paint.Style.STROKE);

            Paint pincelC = new Paint();
            pincelC.setColor(Color.CYAN);
            pincelC.setStrokeWidth(10);
            pincelC.setStyle(Paint.Style.STROKE);

            Paint pincelR = new Paint();
            pincelR.setColor(Color.RED);
            pincelR.setStrokeWidth(100);
            pincelR.setStyle(Paint.Style.STROKE);

            Paint pincelG = new Paint();
            pincelG.setColor(Color.GREEN);
            pincelG.setStrokeWidth(100);
            pincelG.setStyle(Paint.Style.STROKE);

            Paint pincelY = new Paint();
            pincelY.setColor(Color.YELLOW);
            pincelY.setStrokeWidth(100);
            pincelY.setStyle(Paint.Style.STROKE);

            Paint pincelV = new Paint();
            pincelV.setColor(Color.MAGENTA);
            pincelV.setStrokeWidth(30);
            pincelV.setStyle(Paint.Style.STROKE);
            setBackgroundColor(Color.BLACK);


            canvas.drawCircle(720, 1154, 400, pincelV);
            canvas.drawRect(250,700,300,750,pincelR);
            canvas.drawRect(715,1150,725,1160,pincelC);
            canvas.drawRect(1100,700,1150,750,pincelA);
            canvas.drawRect(250,1600,300,1650,pincelG);
            canvas.drawRect(1100,1600,1150,1650,pincelY);

            Paint miPincel = new Paint();
            miPincel.setColor(Color.WHITE);
            miPincel.setStyle(Paint.Style.STROKE);
            miPincel.setTextSize(60);
            canvas.drawText("MI CIRCULO", 400,1650,miPincel);
            String mensaje = "Ancho:"+getWidth()+"  Alto:"+getHeight();
            canvas.drawText(mensaje,400,1700, miPincel);

            /* Otra forma de dibujar
            int x=500;int y=1300;
            int ancho = 300 , alto = 500;
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x,y,x+ancho,y+alto);
            miDrawable.draw(canvas);
            */
        }
    }
}
