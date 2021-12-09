package com.example.job_p123;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {
    ProgressDialog mydialog;
    AlertDialog.Builder dialog=new AlertDialog.Builder ( MainActivity.this );
    AlertDialog.Builder dialog2=new AlertDialog.Builder ( MainActivity.this );
    Button button;
    LinearLayout calculate;
    @Override
    public void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button=findViewById ( R.id.button1 );
        button.setOnClickListener ( new mClick ( ) );
    }
    
    class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( view==button ){
                calculate=(LinearLayout ) getLayoutInflater ().inflate ( R.layout.second_activity,null );
                dialog.setTitle ( "计算：" );
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
            editText=(EditText )calculate.findViewById ( R.id.input );
            try {
                Fx fx=new Fx ( (editText.getText ().toString ()).trim () );
            }
            catch ( FxException e ) {
                dialog2.setTitle ( "计算结果" );
                dialog2.setMessage ( e.getMessage () );
                dialog2.setPositiveButton ( "确定" ,new okClick());
            }
            dialog.dismiss();
        }
    }
    
    class exitClick implements DialogInterface.OnClickListener {
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            MainActivity.this.finish ();
        }
    }
    
    class okClick implements DialogInterface.OnClickListener {
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            dialog2.cancel();
        }
    }
}