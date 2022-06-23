package com.example.appcurriculumdesign;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.net.IDN;
import java.util.Scanner;

public class TeacherActivity extends Activity {
    Button button;
    ListView listView;
    ArrayAdapter<String> adapter;
    ClassDatabaseHelper dbHelper;
    LinearLayout classManager;
    int num[]=new int[10],sum;
    @Override
    public void  onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.teacher );
        button = findViewById ( R.id.parent );
        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Intent intent=new Intent ();
                intent.setClass ( TeacherActivity.this,MainActivity.class );
                startActivityForResult ( intent,0 );
            }} );
        dbHelper=new ClassDatabaseHelper ( this,"classManager.db",null,1 );
        listView=findViewById ( R.id.list );
        adapter=new ArrayAdapter<String> ( this,  android.R.layout.simple_list_item_1);
        listView.setAdapter (adapter);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        pasteList ( db );//更新列表
        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener ( ) {
            AlertDialog.Builder dialog1 =new AlertDialog.Builder (TeacherActivity.this) ;
            AlertDialog.Builder dialog2 =new AlertDialog.Builder (TeacherActivity.this) ;
            @Override
            public void onItemClick ( AdapterView< ? > adapterView , View view , int i , long l ) {
                if ( i==sum ){
                    dialog1.setTitle ( "操作" );
                    dialog1.setMessage ( "请确认对该内容的操作" );
                    dialog1.setPositiveButton ( "添加" , new DialogInterface.OnClickListener ( ) {
                        AlertDialog.Builder dialog4 =new AlertDialog.Builder (TeacherActivity.this) ;
                        @Override
                        public void onClick ( DialogInterface dialogInterface , int i ) {
                            classManager=(LinearLayout )  getLayoutInflater ().inflate ( R.layout.classmanager,null);
                            dialog4.setTitle ( "请输入要添加的内容" );
                            dialog4.setView ( classManager );
                            dialog4.setPositiveButton ( "确认" , new DialogInterface.OnClickListener ( ) {
                                EditText id = (EditText ) classManager.findViewById ( R.id.editText1 );
                                EditText name = (EditText ) classManager.findViewById ( R.id.editText2 );
                                EditText beforename = (EditText ) classManager.findViewById ( R.id.editText3 );
                                EditText teacher = (EditText ) classManager.findViewById ( R.id.editText4 );
                                EditText time = (EditText ) classManager.findViewById ( R.id.editText5 );
                                EditText point = (EditText ) classManager.findViewById ( R.id.editText6 );
                                EditText test = (EditText ) classManager.findViewById ( R.id.editText7 );
                                EditText number = (EditText ) classManager.findViewById ( R.id.editText8 );
                                @Override
                                public void onClick ( DialogInterface dialogInterface , int i ) {
                                    ContentValues values=new ContentValues ();
                                    values.put ( "ID", String.valueOf ( id.getText () ) );
                                    values.put ( "NAME",name.getText ().toString () );
                                    values.put ( "BEFORENAME",beforename.getText ().toString () );
                                    values.put ( "TEACHER",teacher.getText ().toString () );
                                    values.put ( "TIME",time.getText ().toString () );
                                    values.put ( "POINT",point.getText ().toString () );
                                    values.put ( "TEST",test.getText ().toString () );
                                    values.put ( "NUMBER", String.valueOf ( number.getText () ) );
                                    SQLiteDatabase db2=dbHelper.getWritableDatabase ();
                                    db2.insert ( "class",null,values );
                                    pasteList ( db );//更新列表
                                }
                            } );
                            dialog4.create ();
                            dialog4.show ();
                            pasteList ( db );//更新列表
                        }
                    } );
                    dialog1.create ();
                    dialog1.show ();
                }else {
                    int i1=i;
                    dialog2.setTitle ( "操作" );
                    dialog2.setMessage ( "请确认对该内容的操作" );
                    dialog2.setPositiveButton ( "修改" , new DialogInterface.OnClickListener ( ) {
                        AlertDialog.Builder dialog3 =new AlertDialog.Builder (TeacherActivity.this) ;
                        @Override
                        public void onClick ( DialogInterface dialogInterface , int i ) {
                            classManager=(LinearLayout )  getLayoutInflater ().inflate ( R.layout.classmanager,null);
                            dialog3.setTitle ( "请编辑需要修改的内容：" );
                            dialog3.setView ( classManager );
                            classManager.findViewById ( R.id.editText1 ).setEnabled ( false );
                            dialog3.setPositiveButton ( "确认" , new DialogInterface.OnClickListener ( ) {
                                EditText id = (EditText ) classManager.findViewById ( R.id.editText1 );
                                EditText name = (EditText ) classManager.findViewById ( R.id.editText2 );
                                EditText beforename = (EditText ) classManager.findViewById ( R.id.editText3 );
                                EditText teacher = (EditText ) classManager.findViewById ( R.id.editText4 );
                                EditText time = (EditText ) classManager.findViewById ( R.id.editText5 );
                                EditText point = (EditText ) classManager.findViewById ( R.id.editText6 );
                                EditText test = (EditText ) classManager.findViewById ( R.id.editText7 );
                                EditText number = (EditText ) classManager.findViewById ( R.id.editText8 );
                                @Override
                                public void onClick ( DialogInterface dialogInterface , int i ) {
                                    ContentValues values=new ContentValues ();
                                    values.put ( "NAME",name.getText ().toString () );
                                    values.put ( "BEFORENAME",beforename.getText ().toString () );
                                    values.put ( "TEACHER",teacher.getText ().toString () );
                                    values.put ( "TIME",time.getText ().toString () );
                                    values.put ( "POINT",point.getText ().toString () );
                                    values.put ( "TEST",test.getText ().toString () );
                                    values.put ( "NUMBER", String.valueOf ( number.getText () ) );
                                    SQLiteDatabase db3=dbHelper.getWritableDatabase ();
                                    String where1="ID="+String.valueOf ( num[i1] );
//System.out.println ("11111111" );
//System.out.println (values );
                                    db3.update ( "class",values ,where1,null);
                                    pasteList ( db );//更新列表
                                }
                            } );
                            dialog3.create ();
                            dialog3.show ();
                            pasteList ( db );//更新列表
                        }
                    } );
                    dialog2.setNegativeButton ( "删除" , new DialogInterface.OnClickListener ( ) {
                        @Override
                        public void onClick ( DialogInterface dialogInterface , int i ) {
                            SQLiteDatabase db4=dbHelper.getWritableDatabase ();
                            String where1="ID="+String.valueOf ( num[i1] );
                            db4.delete ( "class",where1 , null);
                            pasteList ( db );//更新列表
                        }
                    } );
                    dialog2.create ();
                    dialog2.show ();
                }
            }
        } );
    }
    
    @SuppressLint ( "Range" )
    private void pasteList ( SQLiteDatabase db ) {
        adapter.clear ();
        sum=0;
        Cursor cursor = db.query( "class", null, null, null, null, null, null);
        ;
        if (cursor !=null&&cursor.moveToFirst()&&cursor.getCount()>0){//遍历对象
            do {
                //向适配器中添加数据
                if ( cursor.getInt ( cursor.getColumnIndex ( "NUMBER" ) )>=20 ){
                    adapter.add ( "课程号：" + cursor.getInt ( cursor.getColumnIndex ( "ID" ) )+"; 课程名："+cursor.getString ( cursor.getColumnIndex ( "NAME" ) )+"; 先修课程名："+cursor.getString ( cursor.getColumnIndex ( "BEFORENAME" ) )+"; 教师名："+cursor.getString ( cursor.getColumnIndex ( "TEACHER" ) ) +"; 学时："+cursor.getString ( cursor.getColumnIndex ( "TIME" ) )+"; 学分："+cursor.getString ( cursor.getColumnIndex ( "POINT" ) )+"; 考试方式："+cursor.getString ( cursor.getColumnIndex ( "TEST" ) )+"; 选修人数："+cursor.getString ( cursor.getColumnIndex ( "NUMBER" ) )+"正常开课");
                }else {
                    adapter.add ( "课程号：" + cursor.getInt ( cursor.getColumnIndex ( "ID" ) )+"; 课程名："+cursor.getString ( cursor.getColumnIndex ( "NAME" ) )+"; 先修课程名："+cursor.getString ( cursor.getColumnIndex ( "BEFORENAME" ) )+"; 教师名："+cursor.getString ( cursor.getColumnIndex ( "TEACHER" ) ) +"; 学时："+cursor.getString ( cursor.getColumnIndex ( "TIME" ) )+"; 学分："+cursor.getString ( cursor.getColumnIndex ( "POINT" ) )+"; 考试方式："+cursor.getString ( cursor.getColumnIndex ( "TEST" ) )+"; 选修人数："+cursor.getString ( cursor.getColumnIndex ( "NUMBER" ) )+"不开课");
                }
                num[sum]=cursor.getInt ( cursor.getColumnIndex ( "ID" ) );
                sum=sum+1;
            }while (cursor.moveToNext());
        }
        adapter.add ( "。。。" );
        cursor.close();
    }
    
}