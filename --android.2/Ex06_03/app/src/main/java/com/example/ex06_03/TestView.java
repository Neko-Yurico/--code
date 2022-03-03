package com.example.ex06_03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TestView extends View {
    int x,y;
    public TestView ( Context context ) {
        super ( context );
    }
    
    public void getXY ( int _x , int _y ) {
        x=_x;
        y=_y;
    }
    
    @Override
    protected void onDraw ( Canvas canvas ) {
        super.onDraw ( canvas );
        canvas.drawColor ( Color.CYAN );
        Paint paint=new Paint ();
        paint.setAntiAlias ( true );
        paint.setColor ( Color.BLACK );
        canvas.drawCircle ( x,y,15,paint );
        paint.setColor ( Color.WHITE );
        canvas.drawCircle ( x-6,y-6,3,paint );
    }
}
