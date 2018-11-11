package com.example.usuario.mytemplateexamen;

import java.io.Serializable;
import android.widget.ImageView;
public class ClaseObjetos implements Serializable{
    public String primeraVariableString,segundaVariableString,terceraVariableString;
    public float primeraVariableFloat,segundaVariableFloat;
    public boolean primeraVariableBool = false,segundaVariableBool = false;
    public int imagen;
    public ClaseObjetos(String primerString, String segundoString, String tercerString, float primerFloat, float segundoFloat, boolean primerBool, boolean segundoBool, int imagen){
        this.primeraVariableString = primerString;
        this.segundaVariableString = segundoString;
        this.terceraVariableString = tercerString;
        this.primeraVariableFloat = primerFloat;
        this.segundaVariableFloat = segundoFloat;
        this.primeraVariableBool = primerBool;
        this.segundaVariableBool = segundoBool;
        this.imagen = imagen;
    }
    //Setters y getters de Strings
    public void setPrimerString(String primerString){
        this.primeraVariableString = primerString;
    }
    public String getPrimerString(){
        return this.primeraVariableString;
    }
    public void setSegundoString(String segundoString){
        this.segundaVariableString = segundoString;
    }
    public String getSegundoString(){
        return this.segundaVariableString;
    }
    public void setTercerString(String tercerString){
        this.terceraVariableString = tercerString;
    }
    public String getTercerString(){
        return this.terceraVariableString;
    }
    //Setters y getters de Floats
    public void setPrimeraVariableFloat(Float primerFloat){
        this.primeraVariableFloat = primerFloat;
    }
    public float getPrimeraVariableFloat(){
        return  this.primeraVariableFloat;
    }
    public void setSegundaVariableFloat(Float segundoFloat){
        this.segundaVariableFloat = segundoFloat;
    }
    public float getSegundaVariableFloat(){
        return this.segundaVariableFloat;
    }
    //Setters y getters de Boolean
    public void setPrimeraVariableBool(Boolean primerBool){
        this.primeraVariableBool = primerBool;
    }
    public boolean getPrimeraVariableBool() {
        return this.primeraVariableBool;
    }
    public void setSegundaVariableBool(Boolean segundoBool){
        this.segundaVariableBool = segundoBool;
    }
    public Boolean getSegundaVariableBool(){
        return this.segundaVariableBool;
    }
    //Setter y getter del int de la imagen
    public void setImagen(int imagen){
        this.imagen = imagen;
    }
    public int getImagen(){
        return this.imagen;
    }

    public String toString() {
        return "Primera Variable String: "+this.primeraVariableString+" Segunda Variable String: "+this.segundaVariableString+" Tercera variable String: "+this.terceraVariableString+
                "\n Primera Variable float: " +this.primeraVariableFloat+ " Segunda Variabe float: " + this.segundaVariableFloat +
                "\n Primera Variable Booleana :" + this.primeraVariableBool + "Segunda Variable Bool: " +this.segundaVariableBool;
    }
}
