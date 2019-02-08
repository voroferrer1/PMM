package com.example.usuario.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ResumenPedido extends AppCompatActivity {
    Bundle bundle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_pedido);
        bundle = getIntent().getExtras();

    }

    public void volver(View view){
        Intent intent = new Intent(ResumenPedido.this,Pantalla1.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
