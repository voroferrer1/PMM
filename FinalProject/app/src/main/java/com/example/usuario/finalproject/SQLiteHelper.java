package com.example.usuario.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

public class SQLiteHelper{
    private Context contextB = null;
    private static DataBaseHelperInterno baseDatosHelper = null;
    private SQLiteDatabase baseDatosb = null;

    public SQLiteHelper(Context contexto){
        this.contextB = contexto;
    }
    private static class DataBaseHelperInterno extends SQLiteOpenHelper{
        DataBaseHelperInterno(Context context,String nombre,int version){
            super(context,nombre,null,version);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            creaTablas(db);
            llenaTablas(db);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db,int versionAnterior,int versionNueva){
            borraTablas(db);
            creaTablas(db);
            llenaTablas(db);
        }
        private void creaTablas(SQLiteDatabase db){
            db.execSQL(BaseDatos.CREATE_TABLE_COCHES);
            db.execSQL(BaseDatos.CREATE_TABLE_PEDIDO);
            db.execSQL(BaseDatos.CREATE_TABLE_USUARIO);
        }
        private void borraTablas(SQLiteDatabase db){
            db.execSQL(BaseDatos.DROP_TABLA_COCHES);
            db.execSQL(BaseDatos.DROP_TABLA_PEDIDO);
            db.execSQL(BaseDatos.DROP_TABLA_USUARIO);
        }
        private void llenaTablas(SQLiteDatabase db){
            db.execSQL(BaseDatos.LLENAR_TABLA_COCHES);
            db.execSQL(BaseDatos.LLENAR_TABLA_USUARIO);
        }
    }
    public SQLiteHelper open()
    {
        baseDatosHelper = new DataBaseHelperInterno(contextB, BaseDatos.BASE_DATOS_NOMBRE, BaseDatos.BASE_DATOS_VERSION);
        baseDatosb = baseDatosHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        baseDatosHelper.close();
    }
    public Cursor getDatos(String tabla,String[] columns,String selection,String[] selArgs,String orderBy){
        return baseDatosb.query(tabla,columns,selection,selArgs,null,null,orderBy);
    }
    public long insertarUsuario(String tabla,String[][] datos){

        ContentValues contentValues = new ContentValues();
        for(String[] campo:datos){
            contentValues.put(campo[0],campo[1]);
        }
        return baseDatosb.insert(tabla,null,contentValues);
    }
}
