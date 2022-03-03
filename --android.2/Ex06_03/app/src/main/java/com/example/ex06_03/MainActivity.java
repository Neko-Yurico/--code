package com.example.ex06_03;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int x1=150,y1=50;
    TestView testView;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        testView =new TestView ( this) ;
        testView.setOnTouchListener ( new mOnTouch()) ;
        testView.getXY( x1, y1);
        setContentView ( testView );
    }
    
    private class mOnTouch implements View.OnTouchListener {
        @Override
        public boolean onTouch ( View view , MotionEvent motionEvent ) {
            if (motionEvent .getAction () ==MotionEvent.ACTION_MOVE){
                x1= ( int ) motionEvent .getX ();
                y1= ( int ) motionEvent.getY ();
                testView.getXY(x1,y1);
                setContentView (testView ) ;
            }
            if (motionEvent .getAction () ==MotionEvent.ACTION_DOWN){
                x1= ( int ) motionEvent .getX ();
                y1= ( int ) motionEvent.getY ();
                testView.getXY(x1,y1);
                setContentView (testView ) ;
            }
            return true;
        }
    }
}