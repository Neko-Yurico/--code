package com.example.work6_5;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mmediaPlayer;
    SurfaceView msurfaceView;
    Button playBtn,stopBtn;
    String path;
    SurfaceHolder sh;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        msurfaceView=findViewById ( R.id.surfaceView1 );
        playBtn=findViewById ( R.id.play1 );
        path="/sdcard/zsm/sample.3gp";
        mmediaPlayer=new MediaPlayer ();
        playBtn.setOnClickListener ( new mClick() );
        stopBtn=findViewById ( R.id.stop1 );
        stopBtn.setOnClickListener ( new mStopClick () );
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            try {
                mmediaPlayer.reset ();
                mmediaPlayer.setAudioStreamType ( AudioManager.STREAM_MUSIC );
                mmediaPlayer.setDataSource ( path );
                sh=msurfaceView.getHolder ();
                mmediaPlayer.setDisplay ( sh );
                mmediaPlayer.prepare ();
                mmediaPlayer.start ();
            }
            catch ( Exception e ) {
                Log.i ( "mediaplay err", "mediaplay err" );
            }
        }
    }
    
    private class mStopClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            mmediaPlayer.stop ();
        }
    }
}