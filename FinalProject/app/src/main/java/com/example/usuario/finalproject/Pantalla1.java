package com.example.usuario.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    public Modelos[] modelos = new Modelos[]{
            new Modelos("Megane", "Seat", 20, false, false, false, 1, R.drawable.megan1),
            new Modelos("X-11", "Ferrari", 100, false, false, false, 1, R.drawable.ferrari1),
            new Modelos("Leon", "Seat", 30, false, false, false, 1, R.drawable.leon1),
            new Modelos("Fiesta", "Ford", 40, false, false, false, 1, R.drawable.fiesta1)
    };
    Bundle bundle;
    public int indice = 0;
    Spinner spinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        bundle = getIntent().getExtras();
        TextView bienvenida = (TextView) findViewById(R.id.bienvenida);
        bienvenida.setText("Bienvenid@ " + bundle.getString("usuario"));
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setSelection(-1);
        AdaptadorSpinner miAdaptador = new AdaptadorSpinner(this);
        spinner.setAdapter(miAdaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indice = position;
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final RadioButton botonSinSeguro = (RadioButton) findViewById(R.id.sinSeguro);
        final RadioButton botonTodoRiesgo = (RadioButton) findViewById(R.id.seguroTodoRiesgo);
        final CheckBox checkBoxAire = (CheckBox) findViewById(R.id.aire);
        final CheckBox checkBoxGPS = (CheckBox) findViewById(R.id.gps);
        final CheckBox checkBoxRadio = (CheckBox) findViewById(R.id.radio);
        Button factura = (Button) findViewById(R.id.factura);

        final EditText horas = (EditText) findViewById(R.id.horas);
        final Object Texto = spinner.getSelectedItem();

        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flagSeguro = false;
                boolean flagHoras = false;
                float precioFinal = 0;
                if (checkBoxAire.isChecked()) {
                    modelos[indice].setAire(true);
                    precioFinal += 50;
                }
                if (checkBoxGPS.isChecked()) {
                    modelos[indice].setGPS(true);
                    precioFinal += 50;
                }
                if (checkBoxRadio.isChecked()) {
                    modelos[indice].setRadioDVD(true);
                    precioFinal += 50;
                }
                String comparador = horas.getText().toString();
                if (comparador.equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Debes indicar las horas", Toast.LENGTH_SHORT).show();
                } else {
                    modelos[indice].setHoras(Float.parseFloat(horas.getText().toString()));
                    flagHoras = true;
                }
                float precioHoras = modelos[indice].getPrecio() * modelos[indice].getHoras();
                precioFinal += precioHoras;
                if (botonSinSeguro.isChecked()) {
                    modelos[indice].setEnviado("Sin Seguro");
                    flagSeguro = true;
                } else if (botonTodoRiesgo.isChecked()) {
                    modelos[indice].setEnviado("Seguro todo riesgo");
                    precioFinal *= 1.2;
                    flagSeguro = true;
                } else {
                    Toast.makeText(getApplicationContext(), "Debes seleccionar un tipo de seguro", Toast.LENGTH_SHORT).show();

                }

                if (flagSeguro == true && flagHoras==true) {
                    Toast.makeText(getApplicationContext(), Float.toString(precioFinal), Toast.LENGTH_SHORT).show();
                    modelos[indice].setPrecioTotal(precioFinal);

                    Intent intent = new Intent(Pantalla1.this, ResumenPedido.class);
                    bundle.putSerializable("Objeto", modelos[indice]);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }

            }

        });

        }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String mensaje="";
        TextView etiqueta = (TextView)findViewById(R.id.Acerca);
        switch (item.getItemId()){
            case R.id.MnuOpc1:
                Intent intent = new Intent(Pantalla1.this,Perfil.class);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            case R.id.MnuOpc2:
                mensaje="Voro Ferrer Peris";
                etiqueta.setText(mensaje);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG);
                return true;
            case R.id.MnuOpc3:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


    class AdaptadorSpinner extends ArrayAdapter {
    public Activity miActividad;

    public AdaptadorSpinner(Activity laActividad) {
        super(laActividad, R.layout.coches, modelos);
        this.miActividad = laActividad;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View vistaDesplegada = getView(position, convertView, parent);
        return vistaDesplegada;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = miActividad.getLayoutInflater();
        View item = inflater.inflate(R.layout.coches, null);

        TextView lblModelo = (TextView) item.findViewById(R.id.campoModelo);
        TextView lblMarca = (TextView) item.findViewById(R.id.campoMarca);
        TextView lblPrecio = (TextView) item.findViewById(R.id.campoPrecio);
        ImageView image = (ImageView) item.findViewById(R.id.imagen);

        lblMarca.setText(modelos[position].getMarca());
        lblModelo.setText(modelos[position].getModelo());
        lblPrecio.setText(Float.toString(modelos[position].getPrecio()));
        image.setBackground(getDrawable(modelos[position].getView()));

        return item;
    }
}}