package com.example.usuario.finalproject;


public class BaseDatos {

    public static final String BASE_DATOS_NOMBRE = "ProyectoFinalCoches.db";
    public static final int DASE_DATOS_VERSION = 8;
    //Tabla Coches
    public static final String TABLA_COCHES_NOMBRE = "Coches";
    public static final String TABLA_COCHES_ID = "coches_id";
    public static final String TABLA_COCHES_MARCA = "marca";
    public static final String TABLA_COCHES_MODELO = "modelo";
    public static final String TABLA_COCHES_PRECIO = "precio";
    //TODO public static final String TABLA_COCHES_IMAGEN = "imagen";
    //Tabla Pedido
    public static final String TABLA_PEDIDO_NOMBRE = "Pedido";
    public static final String TABLA_PEDIDO_ID = "pedido_id";
    public static final String TABLA_PEDIDO_COCHE_ID= "coche_id";
    public static final String TABLA_PEDIDO_PRECIO_TOTAL = "precio_total";
    public static final String TABLA_PEDIDO_HORAS = "horas";
    public static final String TABLA_PEDIDO_RADIO = "radio";
    public static final String TABLA_PEDIDO_GPS="gps";
    public static final String TABLA_PEDIDO_AIRE = "aire";
    //Tabla Usuario
    public static final String TABLA_USUARIO_NOMBRE = "Usuario";
    public static final String TABLA_USUARIO_ID = "usuario_id";
    public static final String TABLA_USUARIO_USER = "user";
    public static final String TABLA_USUARIO_PASS = "password";

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

    public static final String CREATE_TABLE_PEDIDO = String.format(
            "CREATE TABLE IF NOT EXISTS %s("+         //Nombre tabla
            "%s INTEGER PRIMARY KEY AUTOINCREMENT,"+  //ID Pedido
            "%s INTEGER NOT NULL,"+                   //ID Coche
            "%s CHAR NOT NULL,"+                      //Precio total
            "%s CHAR NOT NULL,"+                      //Horas
            "%s BOOLEAN ,"+                           //Radio
            "%s BOOLEAN ,"+                           //GPS
            "%s BOOLEAN ,"+                           //Aire
            "FOREIGN KEY (%s) REFERENCES %s(%s))",     //ID Coche, Tabla coches, ID coches
            TABLA_PEDIDO_NOMBRE,
            TABLA_PEDIDO_ID,
            TABLA_PEDIDO_COCHE_ID,
            TABLA_PEDIDO_PRECIO_TOTAL,
            TABLA_PEDIDO_HORAS,
            TABLA_PEDIDO_RADIO,
            TABLA_PEDIDO_GPS,
            TABLA_PEDIDO_AIRE,
            TABLA_PEDIDO_COCHE_ID,
            TABLA_COCHES_NOMBRE,
            TABLA_COCHES_ID
    );
    public static final String CREATE_TABLE_USUARIO = String.format(
            "CREATE TABLE IF NOT EXISTS %s("+
            "%s INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "%s CHAR NOT NULL,"+
                    "%s CHAR NOT NULL)",
            TABLA_USUARIO_NOMBRE,
            TABLA_USUARIO_ID,
            TABLA_USUARIO_USER,
            TABLA_USUARIO_PASS
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

    public static final String LLENAR_TABLA_USUARIO = String.format(
            "INSERT INTO %s(%s,%s) VALUES"+
                    "('admin','admin')",
            TABLA_USUARIO_NOMBRE,
            TABLA_USUARIO_USER,
            TABLA_USUARIO_PASS
    );

    public static final String DROP_TABLA_COCHES = String.format(
            "DROP TABLE IF EXISTS %s",TABLA_COCHES_NOMBRE
    );
    public static final String DROP_TABLA_PEDIDO = String.format(
            "DROP TABLE IF EXISTS %s",TABLA_PEDIDO_NOMBRE
    );
    public static final String DROP_TABLA_USUARIO = String.format(
            "DROP TABLE IF EXISTS %s",TABLA_USUARIO_NOMBRE
    );
}
