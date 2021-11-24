package com.example.ex05_01;

import android.app.ProgressDialog;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    ProgressDialog dialog;
    Toast toast;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        textView1=new TextView ( this );
        int x=15,y=0,z;
        String c=" ";
        try {
            z=x/y;
            c=String.valueOf ( z );
        }catch ( Exception e ){
            c="x=15, y=0, z=x/y 错误, 除数不能为0!";
        }
        toast=Toast.makeText ( this,c,Toast.LENGTH_LONG );
        toast.setText ( c );
        toast.show ();
        setContentView ( textView1 );
    }
}