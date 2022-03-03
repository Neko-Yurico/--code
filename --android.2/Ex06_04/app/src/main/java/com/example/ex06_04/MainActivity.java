package com.example.ex06_04;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private HandWrite handWrite =null;
    private Button clear=null ;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        handWrite =findViewById ( R.id.handwriteview );
        clear=findViewById ( R.id.clear );
        clear.setOnClickListener ( new mClick() );
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            handWrite.Clear ();
        }
    }
}