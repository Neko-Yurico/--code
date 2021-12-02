package com.example.job_p123;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button=findViewById ( R.id.button1 );
        button.setOnClickListener ( new mClick ( ) );
    }
    
    private static class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            
        }
    }
}