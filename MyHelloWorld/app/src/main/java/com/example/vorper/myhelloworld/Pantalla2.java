package com.example.vorper.myhelloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView elSaludo2 = (TextView) findViewById(R.id.miLbl);
        final ImageButton miImagen = (ImageButton) findViewById(R.id.miImg) ;
        Bundle miBundleRecoger = getIntent().getExtras();

        elSaludo2.setText(miBundleRecoger.getString("paso"));
        miImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver=new Intent(Pantalla2.this,MainActivity.class);
                startActivity(volver);
            }
        });
    }
}
