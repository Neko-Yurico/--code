package com.example.ex06_09;

import android.media.MediaRecorder;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaRecorder mRecorder;
    Button startBtn,stopBtn;
    String path;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        path="/sdcard/zsm/audio.amr";
        startBtn=findViewById ( R.id.start );
        stopBtn=findViewById ( R.id.stop );
        startBtn.setOnClickListener ( new mClick() );
        stopBtn.setOnClickListener ( new mClick() );
    }
    
    private class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( view==startBtn ){
                startRecordAudio(path);
            }else if ( view==stopBtn ){
                stopRecord();
            }
        }
    }
    
    private void stopRecord ( ) {
        mRecorder.stop ();
        mRecorder.reset ();
        mRecorder.release ();
    }
    
    private void startRecordAudio ( String path ) {
        mRecorder=new MediaRecorder (  );
        mRecorder.setAudioSource ( MediaRecorder.AudioSource.MIC );
        mRecorder.setOutputFormat ( MediaRecorder.OutputFormat.THREE_GPP );
        mRecorder.setAudioEncoder ( MediaRecorder.AudioEncoder.AMR_NB );
        mRecorder.setOutputFile ( path );
        try {
            mRecorder.prepare ();
        }
        catch ( Exception e ) {
            System.out.println ("recorder err..." );
        }
        mRecorder.start ();
    }
}