package com.example.s3_3test;

import android.graphics.Color;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private Button btn;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        btn=(Button ) findViewById ( R.id.button1 );
        txt=(TextView ) findViewById ( R.id.textView1 );
        btn.setOnClickListener ( new click () );
    }
    class click implements OnClickListener
    {
        public void onClick( View v )
        {
            int BLACK=0xffcccccc;
            txt.setText ( "改变了文字背景颜色" );
            txt.setTextColor ( Color.YELLOW );
            txt.setBackgroundColor ( BLACK );
        }
    }
}