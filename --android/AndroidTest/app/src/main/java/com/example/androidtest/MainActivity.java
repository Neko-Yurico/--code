package com.example.androidtest;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ImageView img0;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        img0=new ImageView ( this );
        img0.setImageResource ( R.drawable.flower );
        setContentView ( img0 );
    }
}