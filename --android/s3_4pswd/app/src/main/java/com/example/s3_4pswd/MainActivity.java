package com.example.s3_4pswd;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView1,textView2;
    private Button button;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        textView1=(TextView ) findViewById ( R.id.textView );
        textView2=(TextView ) findViewById ( R.id.textView2 );
        editText=(EditText ) findViewById ( R.id.editTextTextPassword );
        button=(Button ) findViewById ( R.id.button );
        button.setOnClickListener ( new mClick () );
    }
    class mClick implements View.OnClickListener
    {
        public void onClick(View v)
        {
            String pswd;
            pswd=editText.getText ().toString ();
            if ( pswd.equals ( "abc123" ) )
                textView2.setText ( "欢迎登录" );
            else
                textView2.setText ( "密码错误" );
        }
    }
}