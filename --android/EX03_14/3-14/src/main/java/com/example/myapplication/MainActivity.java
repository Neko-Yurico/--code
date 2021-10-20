package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;
    Gallery gallery;
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            
    };
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        imageSwitcher = findViewById ( R.id.IamgeSwitcher01 );
        imageSwitcher.setInAnimation ( AnimationUtils.loadAnimation ( this , android.R.anim.fade_in) );
        imageSwitcher.setOutAnimation( AnimationUtils.loadAnimation ( this , android.R.anim.fade_out) );
        imageSwitcher.setImageResource ( R.drawable.img1 );
        gallery = findViewById ( R.id.Gallery01 );
        gallery.setOnItemSelectedListener ( new onItemSelectedListener() );
        gallery.setSpacing ( 10 );
        gallery.setAdapter ( new baseAdapter ());
    }
    class viewFactory implements ViewSwitcher.ViewFactory{
    
        @Override
        public View makeView ( ) {
            ImageView imageView = new ImageView ( MainActivity.this );
            imageView.setScaleType ( ImageView.ScaleType.FIT_CENTER );
            return imageView;
        }
    }
    class onItemSelectedListener implements AdapterView.OnItemSelectedListener{
    
        @Override
        public void onItemSelected ( AdapterView< ? > adapterView , View view , int i , long l ) {
            imageSwitcher.setImageResource ( ( int ) gallery.getItemIdAtPosition ( i ) );
        }
    
        @Override
        public void onNothingSelected ( AdapterView< ? > adapterView ) {
        
        }
    }
    class baseAdapter extends BaseAdapter{
    
        @Override
        public int getCount ( ) {
            return imgs.length;
        }
    
        @Override
        public Object getItem ( int i ) {
            return null;
        }
    
        @Override
        public long getItemId ( int i ) {
            return imgs[i];
        }
    
        @Override
        public View getView ( int i , View view , ViewGroup viewGroup ) {
            ImageView imageView = new ImageView ( MainActivity.this );
            imageView.setImageResource ( imgs[i] );
            imageView.setScaleType ( ImageView.ScaleType.FIT_CENTER );
            imageView.setLayoutParams ( new ViewGroup.LayoutParams ( 60,60 ) );
            return imageView;
        }
    }
}