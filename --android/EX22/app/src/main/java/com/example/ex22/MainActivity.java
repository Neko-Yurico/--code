package com.example.ex22;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        TextView textView=new TextView ( this );
        String msg0="";
        for ( int i = 0 ; i < 5 ; i++ ) {
            for ( int j = 0 ; j < i ; j++ ) {
                msg0=msg0+" "+" ";
            }
            for ( int j = 0 ; j < 7-i-i ; j++ ) {
                msg0=msg0+"*"+" ";
            }
            for ( int j = 0 ; j < i ; j++ ) {
                msg0=msg0+"   ";
            }
            msg0=msg0+"\n";
        }
        textView.append ( msg0 );
        setContentView ( textView );
//        setContentView ( R.layout.activity_main );
    }
}