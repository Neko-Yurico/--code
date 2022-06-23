package com.example.appcurriculumdesign;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button stu_bt,tch_bt;
    LinearLayout login ;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        stu_bt=findViewById ( R.id.student_check );
        tch_bt=findViewById ( R.id.teacher_check );
        stu_bt.setOnClickListener ( new mClick () );
        tch_bt.setOnClickListener ( new mClick () );
    }
    
    private class mClick implements View.OnClickListener {
        AlertDialog.Builder dialog=new AlertDialog.Builder ( MainActivity.this );
        @Override
        public void onClick ( View view ) {
            if ( view == stu_bt ){
                login=(LinearLayout ) getLayoutInflater ().inflate ( R.layout.login,null );
                dialog.setTitle ( "用户登录" ).setView ( login );
                dialog.setPositiveButton ( "确定",new studentLogin() );
                dialog.setNegativeButton ( "返回",new exitClicl() );
                dialog.create ();
                dialog.show ();
            }else if ( view == tch_bt ){
                login=(LinearLayout ) getLayoutInflater ().inflate ( R.layout.login,null );
                dialog.setTitle ( "用户登录" ).setView ( login );
                dialog.setPositiveButton ( "确定",new teacherLogin() );
                dialog.setNegativeButton ( "返回",new exitClicl() );
                dialog.create ();
                dialog.show ();
            }
        }
    }
    
    private class studentLogin implements DialogInterface.OnClickListener {
        EditText pswd = (EditText ) login.findViewById ( R.id.paswdEdit );
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            if ( (pswd.getText ().toString ()).equals ( "123" ) ){
                Toast.makeText ( getApplicationContext (), "登录成功", Toast.LENGTH_SHORT ).show ();
            }else {
                Toast.makeText ( getApplicationContext (),"密码错误",Toast.LENGTH_SHORT ).show ();
            }
            Intent intent=new Intent ();
            intent.setClass ( MainActivity.this,StudentActivity.class );
            startActivity ( intent );
            dialogInterface.dismiss ();
        }
    }
    
    private class teacherLogin implements DialogInterface.OnClickListener {
        EditText nm = (EditText ) login.findViewById ( R.id.userEdit );
        EditText pswd = (EditText ) login.findViewById ( R.id.paswdEdit );
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            if ( (nm.getText ().toString ()).equals ( "admin" )&&(pswd.getText ().toString ()).equals ( "admin" ) ){
                Toast.makeText ( getApplicationContext (),"登录成功",Toast.LENGTH_SHORT ).show ();
                Intent intent=new Intent ();
                intent.setClass ( MainActivity.this,TeacherActivity.class );
                startActivity ( intent );
            }else {
                Toast.makeText ( getApplicationContext (),"密码错误",Toast.LENGTH_SHORT ).show ();
            }
            dialogInterface.dismiss ();
        }
    }
    
    private class exitClicl implements DialogInterface.OnClickListener {
        @Override
        public void onClick ( DialogInterface dialogInterface , int i ) {
            dialogInterface.dismiss ();
        }
    }
}