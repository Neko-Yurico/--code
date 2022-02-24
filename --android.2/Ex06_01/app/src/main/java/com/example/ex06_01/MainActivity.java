package com.example.ex06_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        TestView testView =new TestView(this);
        setContentView ( testView );
    }
    
    private class TestView extends View {
        public TestView ( Context context ) {
            super (context );
        }
        @Override
        protected void onDraw( Canvas canvas ){
            canvas.drawColor ( Color.CYAN );
            Paint paint=new Paint ();
            paint.setStrokeWidth ( 3 );
            paint.setStyle ( Paint.Style.STROKE );
            paint.setAntiAlias ( true );
            canvas.drawRect ( 10,10,70,70,paint );
            paint.setStyle ( Paint.Style.FILL );
            canvas.drawRect ( 100,10,170,70,paint );
            paint.setColor ( Color.BLUE );
            canvas.drawCircle ( 100,120,30,paint );
            paint.setColor ( Color.WHITE );
            canvas.drawCircle ( 91,111,6,paint );
            paint.setColor ( Color.RED );
            Path path=new Path ();
            path.moveTo ( 100,170 );
            path.lineTo ( 70,230 );
            path.lineTo ( 130,230 );
            path.close ();
            canvas.drawPath ( path,paint );
            paint.setTextSize ( 28 );
            paint.setColor ( Color.BLUE );
            canvas.drawText ( "几何图形示例",30,270,paint );
        }
    }
}