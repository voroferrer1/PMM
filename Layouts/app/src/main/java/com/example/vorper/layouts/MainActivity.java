package com.example.vorper.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;
    String mensaje="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUISetup();


       /* chkBoxCycling.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkBoxCycling.isChecked()){
                    mensaje += "Cycling";
                }
                txtHobby.setText(mensaje);
            }
        });
        chkBoxBlogging.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkBoxBlogging.isChecked()){
                    mensaje += " Blogging";
                }
                txtHobby.setText(mensaje);
            }
        });
        chkBoxTeaching.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkBoxTeaching.isChecked()){
                    mensaje += " Teaching";
                }
                txtHobby.setText(mensaje);
            }
        });*/

    }
    public void initialUISetup() {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        txtHobby = (TextView) findViewById(R.id.txtView);
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBox());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBox());
        chkBoxCycling.setOnCheckedChangeListener(new myCheckBox());

    }
    public void getHobbyClick(View v){
        String strMessage ="";
        int comas=0;
        if (chkBoxCycling.isChecked()){
            strMessage+=" Cycling";
            comas=1;
        }
        if (chkBoxBlogging.isChecked()){
            if (comas>0){
                strMessage+= ", ";
            }
            strMessage+=" Blogging";
            comas++;

        }
        if (chkBoxTeaching.isChecked()){
            if (comas>0){
                strMessage+= ", ";
            }
            strMessage+=" Teaching";
            comas++;
        }
        showTextNotification(strMessage);
    }
    public void showTextNotification(String messageToDisplay){
        txtHobby.setText(messageToDisplay);
    }
    class myCheckBox implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String mensaje="";
            if(chkBoxCycling.isChecked()){
                mensaje +="Cycling";
            }
            if(chkBoxBlogging.isChecked()){
                mensaje +=" Blogging";
            }
            if(chkBoxTeaching.isChecked()){
                mensaje +=" Teaching";
            }
            txtHobby.setText(mensaje);
        }
    }
}


