package com.example.vorper.myhelloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);



        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String aux = "Te saludo "+ miTexto.getText();

                Intent mio = new Intent(MainActivity.this,Pantalla2.class);
                Bundle miBundle= new Bundle();
                miBundle.putString("paso",aux);
                mio.putExtras(miBundle);
                startActivity(mio);
            }
        });
    }
}
