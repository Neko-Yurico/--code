package com.example.ex06_13;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private Paint mPaint=new Paint (Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;
    private float[] array=new float[9] ;
    public MyView ( Context context , AttributeSet attrs ) {
        super ( context ,attrs);
        mBitmap= BitmapFactory.decodeResource ( context.getResources (),R.drawable.img);
        invalidate ();
    }
    public void setValues(float []a){
        for ( int i = 0 ; i < 9 ; i++ ) {
            array[i]=a[i];
        }
    }
    protected void onDraw( Canvas canvas ){
        super.onDraw ( canvas );
        Paint paint=mPaint;
        canvas.drawBitmap ( mBitmap,0,0,paint );
        Matrix matrix=new Matrix ();
        matrix.setValues ( array );
        canvas.drawBitmap ( mBitmap,matrix,paint );
    }
}
