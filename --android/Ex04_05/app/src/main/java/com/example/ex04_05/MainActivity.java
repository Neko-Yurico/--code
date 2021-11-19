package com.example.ex04_05;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {
    ProgressDialog mydialog;
    Button button1,button2;
    LinearLayout login;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button1=findViewById ( R.id.button1 );
        button2=findViewById ( R.id.button2 );
        button1.setOnClickListener ( new mClick() );
        button2.setOnClickListener ( new mClick() );
    }
    
    class mClick implements View.OnClickListener {
        AlertDialog.Builder dialog=new AlertDialog.Builder ( MainActivity.this );
        @Override
        public void onClick ( View view ) {
            if ( view==button1 ){
                dialog.setTitle ( "警告" );
                dialog.setIcon ( R.drawable.img1 );
                dialog.setMessage ( "本项操作可能导致信息泄露！" );
                dialog.setPositiveButton ( "确定",new okClick() );
                dialog.create ();
                dialog.show ();
            }else if ( view==button2 ){
                login=(LinearLayout ) getLayoutInflater ().inflate ( R.layout.login,null );
                dialog.setTitle ( "用户登录" ).setMessage ( "请输入用户名和密码" ).setView ( login );
                dialog.setPositiveButton ( "确定",new loginClicl() );
                dialog.setNegativeButton ( "退出",new exitClicl() );
                dialog.setIcon ( R.drawable.img1 );
                dialog.create ();
                dialog.show ();
            }
        }
    }
    
    class okClick implements DialogInterface.OnClickListener {
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            dialogInterface.cancel ();
        }
    }
    
    class loginClicl implements DialogInterface.OnClickListener {
        EditText txt;
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            txt=(EditText ) login.findViewById ( R.id.paswdEdit );
            if ( (txt.getText ().toString ()).equals ( "admin" ) ){
                Toast.makeText ( getApplicationContext (),"登录成功",Toast.LENGTH_SHORT ).show ();
            }else {
                Toast.makeText ( getApplicationContext (),"密码错误",Toast.LENGTH_SHORT ).show ();
            }
            dialogInterface.dismiss ();
        }
    }
    
    private class exitClicl implements DialogInterface.OnClickListener {
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            MainActivity.this.finish ();
        }
    }
}