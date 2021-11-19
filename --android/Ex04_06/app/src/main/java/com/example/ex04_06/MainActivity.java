package com.example.ex04_06;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        button1=findViewById ( R.id.button1 );
        button2=findViewById ( R.id.button2 );
        button3=findViewById ( R.id.button3 );
        button1.setOnClickListener ( new mClick() );
        button2.setOnClickListener ( new mClick() );
        button3.setOnClickListener ( new mClick() );
    }
    
    class mClick implements View.OnClickListener {
        int m_year=2021;
        int m_month=1;
        int m_day=1;
        int m_hour=12;
        int m_minute=1;
        @Override
        public void onClick ( View view ) {
            if ( view==button1 ){
                ProgressDialog dialog=new ProgressDialog ( MainActivity.this );
                dialog.setTitle ( "进度对话框" );
                dialog.setIndeterminate ( true );
                dialog.setMessage ( "程序正在loading..." );
                dialog.setCancelable ( true );
                dialog.setMax ( 10 );
                dialog.setProgress ( 2 );
                dialog.show ();
            }else if ( view==button2 ){
                DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener ( ) {
                    @Override
                    public void onDateSet ( DatePicker datePicker , int i , int i1 , int i2 ) {
                        m_year=i;
                        m_month=i1;
                        m_day=i2;
                    }
                };
                DatePickerDialog datePickerDialog=new DatePickerDialog ( MainActivity.this,dateSetListener,m_year,m_month,m_day );
                datePickerDialog.setTitle ( "日期对话框" );
                datePickerDialog.show ();
            }else if ( view==button3 ){
                TimePickerDialog.OnTimeSetListener timeSetListener =new TimePickerDialog.OnTimeSetListener ( ) {
                    @Override
                    public void onTimeSet ( TimePicker timePicker , int i , int i1 ) {
                        m_hour=i;
                        m_minute=i1;
                    }
                };
                TimePickerDialog timePickerDialog=new TimePickerDialog ( MainActivity.this,timeSetListener,m_hour,m_minute,true );
                timePickerDialog.setTitle ( "时间对话框" );
                timePickerDialog.show ();
            }
        }
    }
}