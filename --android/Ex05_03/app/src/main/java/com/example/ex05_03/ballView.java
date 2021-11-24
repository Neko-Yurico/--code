package com.example.ex05_03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ballView extends View {
    int x,y;
    public ballView ( Context context, AttributeSet attributeSet ) {
        super ( context ,attributeSet);
    }
    
    void setXY ( int _x , int _y ) {
        x=_x;
        y=_y;
    }
    
    protected void onDraw( Canvas canvas ){
        super.onDraw ( canvas );
        canvas.drawColor ( Color.CYAN );
        Paint paint=new Paint ();
        paint.setColor ( Color.BLACK );
        paint.setAntiAlias ( true );
        canvas.drawCircle ( x,y,15,paint );
        paint.setColor ( Color.WHITE );
        canvas.drawCircle ( x-6,y-6,3,paint );
    }
}
