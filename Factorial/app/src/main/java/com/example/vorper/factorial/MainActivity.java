package com.example.vorper.factorial;

import android.graphics.Color;
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
        final EditText miTxt = (EditText)findViewById(R.id.miTxt);
        final Button miBtn = (Button)findViewById(R.id.miBtn);
        final TextView miLbl = (TextView)findViewById(R.id.miLbl);
        final int red = Color.parseColor("#FF0000");



        miBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comprobante = miTxt.getText().toString();
                    double aux = Integer.parseInt(comprobante);
                    double mig = 1;
                    for (double i = 1; i <= aux; i++) {
                        mig = mig * i;
                    }
                    miLbl.setText(String.valueOf(mig));
            }
        });
    }
}

