package com.example.vorper.mylista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lview;
    final static String semana[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;
        lview=(ListView) findViewById(R.id.listView);
        ArrayAdapter<String> miAdaptador= new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,semana);
        lview.setAdapter(miAdaptador);

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje="";
                mensaje="Item clicked => " + semana[position];
                showToast(mensaje);
            }

            public void onNothingSelected(AdapterView<?> adapterView){

            }


        });
    }
    public void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
