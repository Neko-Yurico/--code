package com.example.ex05_03;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int i = 80,j=10,step;
    ballView view;
    Button button;
    Handler handler;
    Thread thread;
    boolean STOP=true;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        view=(ballView ) findViewById ( R.id.view1 );
        button=findViewById ( R.id.btn1 );
        button.setOnClickListener ( new mClick() );
        handler=new mHandler();
        thread=new mThread();
        view.setXY(i,j);
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            STOP=false;
            thread.start ();
        }
    }
    
    private class mHandler extends Handler {
        public void handleMessage( Message message ){
            switch ( message.what ){
                case 1:{
                    step+=5;
                    j+=step;
                    if ( j>120 ){
                        STOP=true;
                    }
                    break;
                }
            }
            view.setXY(i,j);
            view.invalidate();
        }
    }
    
    private class mThread extends Thread {
        @Override
        public void run(){
            while ( !STOP ){
                try {
                    Thread.sleep ( 500 );
                }catch ( InterruptedException e ){
                    e.printStackTrace ();
                }
                Message message=new Message ();
                message.what=1;
                handler.sendMessage ( message );
            }
        }
    }
}