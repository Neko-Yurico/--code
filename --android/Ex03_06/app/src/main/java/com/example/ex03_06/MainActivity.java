package com.example.ex03_06;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        imageView =(ImageView ) this.findViewById ( R.id.imageView );
        imageView.setImageResource ( R.drawable.img1 );
    }
}