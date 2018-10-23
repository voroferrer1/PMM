package com.example.vorper.ejemplolistobjetos;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos= new Titular[]{
            new Titular("Titulo 1","Subtitulo largo 1",R.drawable.img3),
            new Titular("Titulo 2","Subtitulo largo 2",R.drawable.img2),
            new Titular("Titulo 3","Subtitulo largo 3",R.drawable.img1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo : " + datos[position].getTitulo() + "\n Subtitulo : " + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();

                Bundle miBundle = new Bundle();
               // miBundle.putString("clave", mensaje);
                miBundle.putString("clave1", datos[position].getTitulo());
                miBundle.putString("clave2", datos[position].getSubtitulo());
                miBundle.putInt("clave3",datos[position].getImage());

                Intent myIntent = new Intent(arg1.getContext(),Pantalla2.class);
                myIntent.putExtras(miBundle);

                startActivityForResult(myIntent,0);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    static class ViewHolder{
        TextView lblTitulo;
        TextView lblSubtitulo;
        ImageView lblImagen;
    }
    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View getView(int i, View convertView,  ViewGroup parent) {
    ViewHolder holder;
    View item = convertView;

    if (item == null) {
        LayoutInflater inflater = context.getLayoutInflater();
        item = inflater.inflate(R.layout.listitem_titular, null);

        holder = new ViewHolder();
        holder.lblTitulo = (TextView) item.findViewById(R.id.Titulo);
        holder.lblSubtitulo = (TextView) item.findViewById(R.id.Subtitulo);
        holder.lblImagen = (ImageView) item.findViewById(R.id.ivImagen);

        item.setTag(holder);

    }
    else
    {
        holder = (ViewHolder)item.getTag();
    }
    holder.lblTitulo.setText(datos[i].getTitulo());
    holder.lblSubtitulo.setText(datos[i].getSubtitulo());
    holder.lblImagen.setBackground(getDrawable(datos[i].getImage()));
    return (item);
    }
}
}
