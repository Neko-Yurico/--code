package com.example.ex06_05;

import android.gesture.*;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {
    GestureLibrary mLibrary;
    GestureOverlayView gesturesView;
    TextView txt;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        gesturesView=findViewById ( R.id.gestures1 );
        gesturesView.addOnGesturePerformedListener ( this );
        txt=findViewById ( R.id.textView1 );
        mLibrary= GestureLibraries.fromRawResource ( this,R.raw.gestures);
        if ( !mLibrary.load () ){
            finish ();
        }
    }
    
    @Override
    public void onGesturePerformed ( GestureOverlayView gestureOverlayView , Gesture gesture ) {
        ArrayList predictions=mLibrary.recognize ( gesture );
        if ( predictions.size ()>0 ){
            Prediction prediction=(Prediction ) predictions.get ( 0 );
            if ( prediction.score > 1.0 ) {
                Toast.makeText ( this,prediction.name,Toast.LENGTH_SHORT ).show ();
                txt.append ( prediction.name );
            }
        }
    }
}