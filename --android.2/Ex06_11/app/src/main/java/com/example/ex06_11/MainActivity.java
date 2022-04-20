package com.example.ex06_11;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {
    TextToSpeech tts;
    int i = 0;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        tts=new TextToSpeech ( this,this );
        Button speakButton=findViewById ( R.id.speak1 );
        speakButton.setOnClickListener ( this );
    }
    
    @Override
    public void onInit ( int i ) {
        if (i==TextToSpeech.SUCCESS){
            tts.speak ( "I'm ready",TextToSpeech.QUEUE_FLUSH,null  );
        }else {
            System.out.println ("tts error!" );
        }
    }
    
    @Override
    public void onClick ( View view ) {
        EditText txt=findViewById ( R.id.edit1 );
        String str=txt.getText ().toString ();
        tts.speak ( str,TextToSpeech.QUEUE_FLUSH,null );
    }
    
    protected void onDestroy(){
        super.onDestroy ();
        tts.shutdown ();
    }
}