package com.example.ex06_13;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyView zsmView;
    Button btn;
    EditText[] edit=new EditText[9];
    float[] carray=new float[9];
    int data[]={
            R.id.editText1,R.id.editText2,R.id.editText3,
            R.id.editText4,R.id.editText5,R.id.editText6,
            R.id.editText7,R.id.editText8,R.id.editText9,
    };
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        zsmView=findViewById ( R.id.imageView1 );
        btn=findViewById ( R.id.button1 );
        btn.setOnClickListener ( new mClick() );
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            getValues();
            zsmView.setValues ( carray );
            zsmView.invalidate ();
        }
    }
    
    private void getValues ( ) {
        for ( int i = 0 ; i < 9 ; i++ ) {
            edit[i]=findViewById ( data[i] );
            carray[i]=Float.valueOf ( edit[i].getText ().toString () );
        }
    }
}