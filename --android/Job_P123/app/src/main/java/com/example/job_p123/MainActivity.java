package com.example.job_p123;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button button=null;
    LinearLayout calculate=null;
    @Override
    public void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button=findViewById ( R.id.button1 );
        button.setOnClickListener ( new mClick ( ) );
    }
    class mClick implements View.OnClickListener {
        Builder dialog=new AlertDialog.Builder ( MainActivity.this );
        @SuppressLint ( "InflateParams" )
        @Override
        public void onClick ( View view ) {
            if ( view==button ){
                calculate=(LinearLayout ) getLayoutInflater ().inflate ( R.layout.second_activity,null );
                dialog.setTitle ( "计算：" );
                dialog.setView ( calculate );
                dialog.setPositiveButton ( "确定",new calculateClick() );
                dialog.setNegativeButton ( "取消",new exitClick() );
                dialog.create ();
                dialog.show ();
            }
        }
    }
    
    class calculateClick implements DialogInterface.OnClickListener {
        EditText editText;
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            editText= calculate.findViewById ( R.id.input );
            try {
                Fx fx=new Fx ( ( editText.getText ( ).toString ( ) ).trim ( ) );
                Toast.makeText ( getApplicationContext (),fx.getX (),Toast.LENGTH_LONG ).show ();
            }
            catch ( FxException e ) {
                Toast.makeText ( getApplicationContext (),e.getMessage (),Toast.LENGTH_LONG ).show ();
            }
            dialogInterface.dismiss ();
        }
    }
    
    class exitClick implements DialogInterface.OnClickListener {
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            MainActivity.this.finish ();
        }
    }
}