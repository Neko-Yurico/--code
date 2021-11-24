package com.example.ex05_02;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {
    private boolean STOP=true;
    private int count=0;
    private mHandler handler;
    private mThread thread;
    private Button mbutton,sbutton;
    private TextView mtextView;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        handler=new mHandler ( );
        thread=new mThread ();
        mtextView=findViewById ( R.id.txt );
        mbutton=findViewById ( R.id.mbutton );
        mbutton.setOnClickListener ( new mClick() );
        sbutton=findViewById ( R.id.sbutton );
        sbutton.setOnClickListener ( new mClick() );
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( view==mbutton ){
                STOP=false;
                thread.start ();
            }else if ( view==sbutton ){
                STOP=true;
            }
        }
    }
    
    private class mHandler extends Handler{
        public void handleMessage(Message message){
            switch ( message.arg1 ){
                case 1:{
                    count++;
                    mtextView.setText ( Integer.toString ( count ) );
                    break;
                }
            }
        }
    }
    
    private class mThread extends Thread{
        @Override
        public void run(){
            while ( !STOP ){
                try {
                    Thread.sleep ( 1000 );
                }catch ( InterruptedException e ){
                    e.printStackTrace ();
                }
                Message message=new Message ();
                message.arg1=1;
                handler.sendMessage ( message );
            }
        }
    }
}