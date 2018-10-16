package com.example.vorper.tresbotones;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context ctx=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx=this;
        setContentView(R.layout.activity_main);
        Button btn=(Button)this.findViewById(R.id.cmdTres);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"Pulsando boton tres",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void cmDos_click(View v){
        Toast.makeText(this,"Pulsado boton 2",Toast.LENGTH_SHORT).show();
    }
}
