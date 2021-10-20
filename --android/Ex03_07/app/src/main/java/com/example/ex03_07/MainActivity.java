package com.example.ex03_07;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        imageView1=(ImageView ) this.findViewById ( R.id.imageView );
        imageView2=(ImageView ) this.findViewById ( R.id.imageView2 );
        imageView3=(ImageView ) this.findViewById ( R.id.imageView3 );
        imageView4=(ImageView ) this.findViewById ( R.id.imageView4 );
        imageView5=(ImageView ) this.findViewById ( R.id.imageView5);
        imageView1.setImageResource ( R.drawable.img1 );
        imageView2.setImageResource ( R.drawable.img2 );
        imageView3.setImageResource ( R.drawable.img3 );
        imageView4.setImageResource ( R.drawable.img4 );
        imageView5.setImageResource ( R.drawable.img5 );
    }
}