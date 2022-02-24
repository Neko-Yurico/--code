package com.example.ex03_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.example.ex03_10.R;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        progressBar=findViewById(R.id.ProgressBar01);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button1.setOnClickListener(new click1());
        button2.setOnClickListener(new click2());
    }
    class click1 implements View.OnClickListener{
        public void onClick(View view){
            progressBar.incrementProgressBy(5);
        }
    }
    class click2 implements View.OnClickListener{
        public void onClick(View view){
            progressBar.incrementProgressBy(-5);
        }
    }
}
