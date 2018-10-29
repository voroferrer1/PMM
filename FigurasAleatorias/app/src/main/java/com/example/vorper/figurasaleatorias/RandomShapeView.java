package com.example.vorper.figurasaleatorias;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RandomShapeView extends View {
    private Integer[] mBackgrounds =
            {Color.CYAN,Color.GRAY, Color.LTGRAY, Color.MAGENTA, Color.YELLOW, Color.WHITE};
    private Paint[] mForegrounds =
            {makePaint(Color.BLACK),makePaint(Color.BLUE),makePaint(Color.GREEN),makePaint(Color.RED)};
    private Bitmap[] mPics = {

    };
    private String mMessage = "Android";
    public RandomShapeView(Context context){
        super(context);
    }
    public RandomShapeView(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(RandomUtils.randomElement(mBackgrounds));
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        int avgShapwWidth = viewWidth/5;
        for (int i=0;i<20;i++){

        }
    }
    private Paint makePaint(int color){
        Paint p = new Paint();
        p.setColor(color);
        return(p);
    }
    private Bitmap makeBitmap(int bitmapId){
        return(BitmapFactory.decodeResource(getResources(),bitmapId));
    }
    private void drawRandomCircle(Canvas canvas, int viewWidth, int viewHeight,int avgShapeWidth){
        float x = RandomUtils.randomFloat(viewWidth);
        float y = RandomUtils.randomFloat(viewHeight);
        float radius = RandomUtils.randomFloat(avgShapeWidth/2);
        Paint circleColor = RandomUtils.randomElement(mForegrounds);
        canvas.drawCircle(x,y,radius,circleColor);
    }
    private void drawRandomRect(Canvas canvas, int viewWidth, int viewHeight,int avgShapeWidth){
        float left=RandomUtils.randomFloat(viewWidth);

    }
    private void drawRandomBitMap(Canvas canvas, int viewWidth, int viewHeight){

    }
    private void drawRandomText(Canvas canvas, int viewWidth, int viewHeight,int avgShapeWidth){

    }
}
