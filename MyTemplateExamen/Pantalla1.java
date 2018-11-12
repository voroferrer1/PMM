package com.example.usuario.mytemplateexamen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {
    public ClaseObjetos[] objetos = new ClaseObjetos[]{
            new ClaseObjetos("Primer String Objeto 1","Segundo String Objeto 1","Tercer String Objeto 1",10,0,false,false,R.drawable.todobien),
            new ClaseObjetos("Primer String Objeto 2","Segundo String Objeto 2","Tercer String Objeto 2",20,0,false,false,R.drawable.todobien),
            new ClaseObjetos("Primer String Objeto 3","Segundo String Objeto 3","Tercer String Objeto 3",30,0,false,false,R.drawable.todobien)
    };
    public ClaseObjetos[] miObjeto;
    public int indice = 0;
    public Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        spinner =(Spinner)findViewById(R.id.spinner);
        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indice = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final RadioButton botonRadioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton botonRadioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.primeraOpcion);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.segundaOpcion);
        Button boton = (Button) findViewById(R.id.boton);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final TextView salida = (TextView)findViewById(R.id.salida);
        final EditText float2 = (EditText)findViewById(R.id.float1);
        final Object objeto = spinner.getSelectedItem();
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = false;
                if(botonRadioButton1.isChecked()){
                    objetos[indice].setTercerString("Boton 1");
                    flag = true;
                }else if(botonRadioButton2.isChecked()){
                    objetos[indice].setTercerString("Boton 2");
                    flag = true;
                }else{
                    Toast.makeText(getApplicationContext(),"Selecciona un RadioButton",Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if(checkBox1.isChecked()){
                    objetos[indice].setPrimeraVariableBool(true);
                }else if(checkBox2.isChecked()){
                    objetos[indice].setSegundaVariableBool(true);
                }
                String comparador = float2.getText().toString();
                if(comparador.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Debes rellenar con un numero en el EditText",Toast.LENGTH_SHORT).show();
                    flag = false;
                }else{
                    objetos[indice].setSegundaVariableFloat(Float.parseFloat(float2.getText().toString()));
                }
                if (flag == true){
                    Intent intent = new Intent(Pantalla1.this,Pantalla2.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Objeto", objetos[indice]);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                salida.setText(objetos[indice].toString());
            }
        });
    }
    class AdaptadorObjetos extends ArrayAdapter{
        Activity context;
        AdaptadorObjetos(Activity context){
            super(context, R.layout.listaobjetos,objetos);
            this.context=context;
        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView,ViewGroup parent){
            View vista = getView(position,convertView,parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position,View convertView,ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listaobjetos,null);
            TextView string1 = (TextView) item.findViewById(R.id.string21);
            TextView string2 = (TextView) item.findViewById(R.id.string22);
            TextView float1 = (TextView) item.findViewById(R.id.float21);
            ImageView imagen = (ImageView) item.findViewById(R.id.imagenSpinner);
            string1.setText(objetos[position].getPrimerString());
            string2.setText(objetos[position].getSegundoString());
            float1.setText(String.valueOf(objetos[position].getPrimeraVariableFloat()));
            imagen.setBackground(getDrawable(objetos[position].getImagen()));

            return item;
        }
    }

}
