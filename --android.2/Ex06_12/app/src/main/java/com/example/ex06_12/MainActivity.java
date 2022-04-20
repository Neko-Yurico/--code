package com.example.ex06_12;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText[] edit=new EditText[20];
    int data[]={R.id.editText1,R.id.editText2,R.id.editText3,R.id.editText4,R.id.editText5,R.id.editText6,R.id.editText7,R.id.editText8,R.id.editText9,R.id.editText10,R.id.editText11,R.id.editText12,R.id.editText13,R.id.editText14,R.id.editText15,R.id.editText16,R.id.editText17,R.id.editText18,R.id.editText19,R.id.editText20};
    float[] carray=new float[20];
    Button changeBtn;
    MyView myView;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        myView=findViewById ( R.id.imageView1 );
        changeBtn=findViewById ( R.id.button1 );
        for ( int i=0;i<20;i++ ){
            edit[i]=findViewById ( data[i] );
            carray[i]=Float.parseFloat ( edit[i].getText ().toString () );
        }
        changeBtn.setOnClickListener ( new mClick() );
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            getValues();
            myView.setValues ( carray );
            myView.invalidate ();
        }
    
        private void getValues ( ) {
            for ( int i=0;i<20;i++ ){
                carray[i]=Float.parseFloat ( edit[i].getText ().toString () );
            }
        }
    }
}