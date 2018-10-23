package com.example.vorper.midibujo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
        }

        protected void onDraw(Canvas canvas) {
            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(100);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(700, 700, 200, pincel);
            canvas.drawLine(250,400,450,400,pincel);
            canvas.drawLine(950,400,1150,400,pincel);
            canvas.drawLine(250,1000,450,1000,pincel);
            canvas.drawLine(950,1000,1150,1000,pincel);

        }
    }
}
