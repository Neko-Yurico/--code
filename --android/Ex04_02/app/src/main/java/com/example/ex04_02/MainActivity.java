package com.example.ex04_02;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button=findViewById ( R.id.button );
        button.setOnClickListener ( new btnclock() );
    }
    
    private class btnclock implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            Intent intent=new Intent ();
            intent.setClass ( MainActivity.this,SecondActivity.class );
            EditText text=findViewById ( R.id.editText1 );
            Bundle bundle=new Bundle ();
            bundle.putString ( "text",text.getText ().toString () );
            intent.putExtras ( bundle );
            startActivity ( intent );
        }
    }
}