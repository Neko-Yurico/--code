package com.example.ex03_15;

import android.view.Gravity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button button1,button2,button3;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button1 = findViewById ( R.id.btn1 );
        button2 = findViewById ( R.id.btn2 );
        button3 = findViewById ( R.id.btn3 );
        button1.setOnClickListener ( new mclick () );
        button2.setOnClickListener ( new mclick () );
        button3.setOnClickListener ( new mclick () );
    }
    class mclick implements View.OnClickListener{
        Toast toast;
        LinearLayout linearLayout;
        ImageView imageView;
        @Override
        public void onClick ( View view ) {
            if ( view==button1 ) {
                Toast.makeText ( getApplicationContext (),"默认toast方式",Toast.LENGTH_SHORT ).show ();
            } else if ( view == button2 ) {
                toast=Toast.makeText ( getApplicationContext (),"自定义taost位置",Toast.LENGTH_SHORT );
                toast.setGravity ( Gravity.CENTER,0,0 );
                toast.show ();
            }else if ( view == button3 ) {
                toast=Toast.makeText ( getApplicationContext (),"带图标的toast",Toast.LENGTH_SHORT );
                toast.setGravity ( Gravity.CENTER,0,80 );
                linearLayout= ( LinearLayout ) toast.getView ();
                imageView=new ImageView ( MainActivity.this );
                imageView.setImageResource ( R.drawable.img1 );
                linearLayout.addView ( imageView,0 );
                toast.show ();
            }
        }
    }
}