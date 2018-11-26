package com.example.vorper.bicididactico;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
    private Drawable drawable;//Imagen a dibujar
    private double posX,posY;//Posicion de la pantalla
    private double incX,incY;//??Velocidad de desplazamiento
    private int angulo,rotacion;//??Angulo y velocidad de rotacion
    private int ancho,alto;//Dimensiones de la pantalla
    private int radioColision;//??Determinar si chocamos
    //Vista donde se dibuja
    private View view;
    //?? Para determinar el espacio a borrar
    public static final int MAX_VELOCIDAD=20;

    //Constructor de la clase
    public Grafico(View view, Drawable drawable){
        this.view = view;
        this.drawable = drawable;
        ancho=drawable.getIntrinsicWidth();
        alto= drawable.getIntrinsicHeight();
        radioColision = (alto+ancho)/4;//??
    }
    //Dibujamos el grafico de su posicion actual
    public void dibujarGrafico(Canvas canvas){
        canvas.save();//??
        int x = (int) (posX+ancho /2);
        int y = (int) (posY+alto /2);
        canvas.rotate((float)angulo,(float)x,(float) y);//??
        drawable.setBounds((int)posX,(int)posY,(int)posX+ancho, (int)posY+alto);
        drawable.draw(canvas);
        canvas.restore();
        //Calculo area donde no podran solaparse/chocar
        int rInval = (int) distanciaE(0,0,ancho,alto)/2+MAX_VELOCIDAD;
        view.invalidate(x-rInval,y-rInval,x+rInval,y+rInval);

    }



    public void incrementaPos(){
        posX += incX;
        if(posX < -ancho/2){
            posX=view.getWidth()-ancho/2;
        }
        if(posX > view.getWidth()-ancho/2){
            posX -= ancho/2;
        }
        posY += incY;
        if(posY < -alto / 2) {
            posY = view.getHeight() - alto / 2;
        }
        if(posY > view.getHeight() - alto / 2) {

            posY = -alto / 2;
        }
        angulo += rotacion;
    }

    public double distancia(Grafico g){
        return distanciaE(posX,posY,g.posX,g.posY);
    }
    public boolean verificaColision(Grafico g){
        return (distancia(g)<(radioColision+g.radioColision));
    }
    public static double distanciaE(double x,double y,double x2,double y2){
        return Math.sqrt((x-x2)*(x-x2)+(y-y2)*(y-y2));
    }
    public void setPosX(double posX){
        this.posX = posX;
    }
    public void setIncX(double incX){
        this.incX = incX;
    }
    public void setIncY(double incY){
        this.incY = incY;
    }
    public void setAngulo(int angulo){
        this.angulo =angulo;
    }
    public void setRotacion(int rotacion) {
        this.rotacion = rotacion;
    }
    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getIncX() {
        return incX;
    }

    public double getIncY() {
        return incY;
    }

    public int getAngulo() {
        return angulo;
    }

    public int getRotacion() {
        return rotacion;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getRadioColision() {
        return radioColision;
    }

    public void setRadioColision(int radioColision) {
        this.radioColision = radioColision;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public static int getMaxVelocidad() {
        return MAX_VELOCIDAD;
    }
}
