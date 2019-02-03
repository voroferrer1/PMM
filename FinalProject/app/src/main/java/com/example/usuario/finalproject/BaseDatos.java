package com.example.usuario.finalproject;


public class BaseDatos {

    public static final String BASE_DATOS_NOMBRE = "ProyectoFinalCoches.db";
    public static final int DASE_DATOS_VERSION = 1;
    //Tabla Coches
    public static final String TABLA_COCHES_NOMBRE = "coches";
    public static final String TABLA_COCHES_ID = "id";
    public static final String TABLA_COCHES_MARCA = "marca";
    public static final String TABLA_COCHES_MODELO = "modelo";
    public static final String TABLA_COCHES_PRECIO = "precio";
    //TODO public static final String TABLA_COCHES_IMAGEN = "imagen";
    //Tabla Pedido
    public static final String TABLA_PEDIDO_NOMBRE = "pedido";
    public static final String TABLA_PEDIDO_ID = "pedido_id";
    public static final String TABLA_PEDIDO_COCHE_ID= "coche_id";
    public static final String TABLA_PEDIDO_PRECIO_TOTAL = "precio_total";
    public static final String TABLA_PEDIDO_HORAS = "horas";
    public static final String TABLA_PEDIDO_RADIO = "radio";
    public static final String TABLA_PEDIDO_GPS="gps";
    public static final String TABLA_PEDIDO_AIRE = "aire";

    //CREACIÓN DE LAS TABLAS
    public static final String CREATE_TABLE_COCHES = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "%s TEXT NOT NULL ," +
                    "%s TEXT NOT NULL ," +
                    "%s CHAR NOT NULL)",
                    //TODO"%s TEXT NOT NULL)",
                    TABLA_COCHES_NOMBRE,
            TABLA_COCHES_ID,
            TABLA_COCHES_MARCA,
            TABLA_COCHES_MODELO,
            TABLA_COCHES_PRECIO
            //TODO TABLA_COCHES_IMAGEN
    );



    //LLENADO DE TABLA COCHES
    public static final String LLENAR_TABLA_COCHES= String.format(
            "INSERT INTO %s(%s,%s,%s) VALUES"+
                    "('Renault','Megane',20)," +
                    "('Seat','Leon',30),"+
                    "('Ford','Fiesta',40),"+
                    "('Ferrari','X-11',100)",
                    TABLA_COCHES_NOMBRE,
            TABLA_COCHES_MARCA,
            TABLA_COCHES_MODELO,
            TABLA_COCHES_PRECIO
    );
}
