package com.example.work6_4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    CheckBox ch1,ch2,ch3;
    ImageButton mStopButton, mStartButton, mPauseButton;
    MediaPlayer	mMediaPlayer;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMediaPlayer = new MediaPlayer();
        ch1=findViewById(R.id.check1);
        ch2=findViewById(R.id.check2);
        ch3=findViewById(R.id.check3);
        mStopButton  = findViewById(R.id.Stop);
        mStartButton = findViewById(R.id.Start);
        mPauseButton = findViewById(R.id.Pause);
        mStopButton.setOnClickListener(new mStopClick());
        mStartButton.setOnClickListener(new mStartClick());
        mPauseButton.setOnClickListener(new mPauseClick());
    }
    class mStopClick implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            /* 是否正在播放 */
            if (mMediaPlayer.isPlaying())
            {
                //重置MediaPlayer到初始状态
                mMediaPlayer.reset();
            }
        }
    }
    class mStartClick implements View.OnClickListener
    {
        public void onClick(View v)
        {
            if ( mMediaPlayer.isPlaying ()  ) {
                mMediaPlayer.reset ();
            }
            if(ch1.isChecked())
            {
                try {
                    mMediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.togetheragain);
                    mMediaPlayer.start();
                } catch (Exception e) {Log.i( "ch1", "res err ....");	}
            }
            
            else if(ch2.isChecked())
            {
                try {
                    mMediaPlayer = MediaPlayer.create( MainActivity.this, R.raw.harumachiclover);
                    mMediaPlayer.start();
                } catch (Exception e) {Log.i("ch2", "res err ....");	}
            }
            else if(ch3.isChecked())
            {
                try {
                    mMediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.ohayosekai);
                    mMediaPlayer.start();
                } catch (Exception e) {Log.i("ch3", "res err ....");	}
            }
        }
    }
    class mPauseClick implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {        if (mMediaPlayer.isPlaying())
        {
            /* 暂停 */
            mMediaPlayer.pause();
        }
        else
        {
            /* 开始播放 */
            mMediaPlayer.start();
        }
        }
    }
}