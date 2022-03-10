package com.example.ex06_06;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox ch1,ch2;
    TextView txt;
    ImageButton mStopButton,mStartButton,mPauseButton;
    MediaPlayer mMediaPlayer;
    @SuppressLint ( "SdCardPath" )
    String sdcard_file= "/sdcard/Music/ets.mp3";
    int res_file=R.raw.ets;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        mMediaPlayer=new MediaPlayer ();
        ch1=findViewById ( R.id.check1 );
        ch2=findViewById ( R.id.check2 );
        txt=findViewById ( R.id.text1 );
        mStopButton=findViewById ( R.id.stop );
        mStartButton=findViewById ( R.id.play );
        mPauseButton=findViewById ( R.id.pause );
       // setRegist();
        mStopButton.setOnClickListener ( new mStopClick() );
        mStartButton.setOnClickListener ( new mStartClick() );
        mPauseButton.setOnClickListener ( new mPauseClick() );
    }
    
    private void setRegist ( ) {
        if ( Build.VERSION.SDK_INT>=23 ){
            int REQUEST_CODE_CONTACT=101;
            String[] PERMISSIONS_STORAGE={
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };
            for ( String str:PERMISSIONS_STORAGE ){
                if ( this.checkSelfPermission ( str ) != PackageManager.PERMISSION_GRANTED ){
                    this.requestPermissions ( PERMISSIONS_STORAGE,REQUEST_CODE_CONTACT );
                    return;
                }
            }
        }
    }
    
    private class mStopClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( mMediaPlayer.isPlaying () ){
                mMediaPlayer.reset ();
                mMediaPlayer.release ();
            }
        }
    }
    
    private class mStartClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            String str="";
            if ( ch1.isChecked () ){
                str=str+"\n"+ch1.getText ();
                try {
                    mMediaPlayer=MediaPlayer.create ( MainActivity.this,res_file );
                    mMediaPlayer.start ();
                }catch ( Exception e ){
                    Log.i ( "ch1","res err ..." );
                }
            }
            if ( ch2.isChecked () ){
                str=str+"\n"+ch2.getText ();
                try {
                    mMediaPlayer=new MediaPlayer ();
                    mMediaPlayer.setDataSource ( sdcard_file );
                    playMusic(sdcard_file);
                }catch ( Exception e ){
                    Log.i ( "ch2","sdcard err ..." );
                }
            }
            txt.setText ( str );
        }
    }
    
    private void playMusic ( String path ) {
        try {
            mMediaPlayer.reset ();
            mMediaPlayer.setDataSource ( path );
            mMediaPlayer.prepare ();
            mMediaPlayer.start ();
        }catch ( IOException ignored ){        }
    }
    
    private class mPauseClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( mMediaPlayer.isPlaying () ){
                mMediaPlayer.pause ();
            }else {
                mMediaPlayer.start ();
            }
        }
    }
}