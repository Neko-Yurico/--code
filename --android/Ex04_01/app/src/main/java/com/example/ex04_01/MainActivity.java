package com.example.ex04_01;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button button;
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
            Intent intent=new Intent (MainActivity.this,SecondActivity.class);
            startActivity ( intent );
        }
    }
}