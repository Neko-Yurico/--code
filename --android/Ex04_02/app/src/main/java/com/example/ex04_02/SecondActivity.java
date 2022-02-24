package com.example.ex04_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button button;
    @Override
    public void  onCreate( Bundle savedInstanceState ){
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.second );
        TextView textView2=findViewById ( R.id.textview2 );
        Bundle bundle=this.getIntent ().getExtras ();
        String string=bundle.getString ( "text" );
        textView2.setText ( string );
        button=findViewById ( R.id.button2 );
        button.setOnClickListener ( new btnclock2() );
    }
    
    private class btnclock2 implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            Intent intent=new Intent ();
            intent.setClass ( SecondActivity.this,MainActivity.class );
            startActivityForResult ( intent,0 );
        }
    }
}
