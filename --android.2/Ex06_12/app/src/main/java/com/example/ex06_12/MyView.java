package com.example.ex06_12;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    Paint mPaint=new Paint (Paint.ANTI_ALIAS_FLAG);
    Bitmap mBitmap;
    float[] array=new float[20];
    public MyView ( Context context, AttributeSet attrs ) {
        super(context,attrs);
        mBitmap= BitmapFactory.decodeResource ( context.getResources (), R.drawable.like );
    }
    public void setValues(float []a){
//        for ( int i=0;i<20;i++ ){
//            array[i]=a[i];
//        }
        System.arraycopy ( a , 0 , array , 0 , 20 );
    }
    protected void onDraw( Canvas canvas ){
        super.onDraw ( canvas );
        Paint paint=mPaint;
        paint.setColorFilter ( null );
        canvas.drawBitmap ( mBitmap,0,0,paint );
        ColorMatrix colorMatrix=new ColorMatrix ();
        colorMatrix.set ( array );
        paint.setColorFilter ( new ColorMatrixColorFilter ( colorMatrix ) );
        canvas.drawBitmap ( mBitmap,0,0,paint );
    }
}
