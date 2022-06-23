package com.example.work6_6;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private Paint mPaint=new Paint (Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;
    private int[] images = new int[]{R.drawable.image1 , R.drawable.image4 , R.drawable.image3, R.drawable.image2};
    private int currentImage = Integer.MAX_VALUE / 2;
    private float[] array=new float[9] ;
    public MyView ( Context context , AttributeSet attrs ) {
        super ( context ,attrs);
        mBitmap= BitmapFactory.decodeResource ( context.getResources (),images[currentImage % images.length]);
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
    public void upView(){
        mPaint.reset ();
        currentImage--;
}
    public void downView(){
        mPaint.reset ();
        currentImage++;
    }
}
