package com.example.ex06_10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    Camera mCamera=null;
    SurfaceView surfaceView;
    SurfaceHolder holder;
    ImageView mImageView;
    Button cameraBtn,exitBtn;
    String path="/sdcard/test/camera.jpg";
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        mImageView=findViewById ( R.id.imageView1 );
        cameraBtn=findViewById ( R.id.button1 );
        exitBtn=findViewById ( R.id.button2 );
        cameraBtn.setOnClickListener ( new mClick() );
        exitBtn.setOnClickListener ( new mClick () );
        surfaceView=findViewById ( R.id.surfaceView1 );
        holder=surfaceView.getHolder ();
        holder.addCallback ( this );
        holder.setType ( SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS );
    }
    
    @Override
    public void surfaceCreated ( @NonNull SurfaceHolder surfaceHolder ) {
        mCamera=Camera.open (  );
        try {
            mCamera.setPreviewDisplay ( surfaceHolder );
        }
        catch ( IOException e ) {
            System.out.println ( "预览错误" );
        }
    }
    
    @Override
    public void surfaceChanged ( @NonNull SurfaceHolder surfaceHolder , int i , int i1 , int i2 ) {
        initCamera();
    }
    
    private void initCamera ( ) {
        Camera.Parameters parameters=mCamera.getParameters ();
        parameters.setPictureFormat ( PixelFormat.JPEG );
        parameters.setPreviewSize ( 320,240 );
        parameters.setPictureSize ( 320,240 );
        mCamera.setParameters ( parameters );
        mCamera.startPreview ();
    }
    
    @Override
    public void surfaceDestroyed ( @NonNull SurfaceHolder surfaceHolder ) {
    
    }
    
    class mClick implements View.OnClickListener {
        @Override
        public void onClick ( View view ) {
            if ( view==cameraBtn ){
                mCamera.takePicture ( null,null,new jpegCallback() );
            }else  if ( view==exitBtn ){
                exit();
            }
        }
    }
    
    private void exit ( ) {
        mCamera.release ();
        mCamera=null;
    }
    
    private class jpegCallback implements Camera.PictureCallback {
        @Override
        public void onPictureTaken ( byte[] bytes , Camera camera ) {
            Bitmap bitmap= BitmapFactory.decodeByteArray ( bytes , 0,bytes.length);
            try {
                BufferedOutputStream outputStream=new BufferedOutputStream ( new FileOutputStream ( path ) );
                bitmap.compress ( Bitmap.CompressFormat.JPEG,80,outputStream );
                outputStream.flush ();
                outputStream.close ();
                mImageView.setImageBitmap ( bitmap );
            }catch ( Exception e ){
                Log.e ( "err",e.getMessage () );
            }
        }
    }
}