package com.example.job_p137;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {
    private boolean STOP1=true;
    private int count1=0;
    private boolean STOP2=true;
    private int count2=0;
    private mHandler1 handler1;
    private mThread1 thread1;
    private mHandler2 handler2;
    private mThread2 thread2;
    private Button mbutton1,sbutton1,mbutton2,sbutton2;
    private TextView mtextView1,mtextView2;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        handler1= new mHandler1 ( );
        handler2= new mHandler2 ( );
        thread1= new mThread1 ();
        thread2= new mThread2 ();
        mtextView1=findViewById ( R.id.txt1 );
        mbutton1=findViewById ( R.id.mbutton1 );
        mbutton1.setOnClickListener ( new mClick1() );
        sbutton1=findViewById ( R.id.sbutton1 );
        sbutton1.setOnClickListener ( new mClick1() );
        mtextView2=findViewById ( R.id.txt2 );
        mbutton2=findViewById ( R.id.mbutton2 );
        mbutton2.setOnClickListener ( new mClick2() );
        sbutton2=findViewById ( R.id.sbutton2 );
        sbutton2.setOnClickListener ( new mClick2() );
    }
    
    private class mClick1 implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( view==mbutton1 ){
                STOP1=false;
                thread1.start ();
            }else if ( view==sbutton1 ){
                STOP1=true;
            }
        }
    }
    private class mClick2 implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( view==mbutton2 ){
                STOP2=false;
                thread2.start ();
            }else if ( view==sbutton2 ){
                STOP2=true;
            }
        }
    }
    
    private class mHandler1 extends Handler{
        public void handleMessage(Message message){
            switch ( message.arg1 ){
                case 1:{
                    count1++;
                    mtextView1.setText ( Integer.toString ( count1 ) );
                    break;
                }
            }
        }
    }
    private class mHandler2 extends Handler{
        public void handleMessage(Message message){
            switch ( message.arg2 ){
                case 1:{
                    count2++;
                    mtextView2.setText ( Integer.toString ( count2 ) );
                    break;
                }
            }
        }
    }
    
    private class mThread1 extends Thread{
        @Override
        public void run(){
            while ( !STOP1 ){
                try {
                    Thread.sleep ( 1000 );
                }catch ( InterruptedException e ){
                    e.printStackTrace ();
                }
                Message message=new Message ();
                message.arg1=1;
                handler1.sendMessage ( message );
            }
        }
    }
    private class mThread2 extends Thread{
        @Override
        public void run(){
            while ( !STOP2 ){
                try {
                    Thread.sleep ( 1000 );
                }catch ( InterruptedException e ){
                    e.printStackTrace ();
                }
                Message message=new Message ();
                message.arg2=1;
                handler2.sendMessage ( message );
            }
        }
    }
}