package com.example.appcurriculumdesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentActivity extends Activity {
    Button button;
    @Override
    public void  onCreate( Bundle savedInstanceState ){
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.student );
        button=findViewById ( R.id.button );
        button.setOnClickListener ( new btnclock() );
    }
    
    private class btnclock implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            Intent intent=new Intent ();
            intent.setClass ( StudentActivity.this,MainActivity.class );
            startActivityForResult ( intent,0 );
        }
    }
}
