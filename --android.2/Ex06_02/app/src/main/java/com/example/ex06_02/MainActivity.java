package com.example.ex06_02;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int x1=150,y1=50;
    TestView testView;
    Button btn;
    EditText edit_y;
    @Override
    public void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        testView=findViewById ( R.id.testView1 );
        testView.setXY ( x1,y1 );
        btn=findViewById ( R.id.button1 );
        edit_y=findViewById ( R.id.editText1 );
        btn.setOnClickListener ( new mClick() );
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            y1=Integer.parseInt ( edit_y.getText ().toString () );
            testView.setXY ( x1,y1 );
            testView.invalidate ();
        }
    }
}