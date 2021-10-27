package com.example.ex03_17;

import android.app.Activity;
import android.app.ListActivity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {
    
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        String[] data={
                "(1)荷塘月色",
                "(2)最炫民族风",
                "(3)天蓝蓝",
                "(4)最美天下",
                "(5)自由飞翔",
        };
        ListView listView=findViewById ( R.id.list );
        TextView header=new TextView ( this );
        header.setText ( "凤凰传奇经典歌曲" );
        header.setTextSize ( 24 );
        listView.addHeaderView ( header );
        TextView foot=new TextView ( this );
        foot.setText ( "请选择:" );
        foot.setTextSize ( 24 );
        listView.addFooterView ( foot );
        setListAdapter ( new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1,data  ) );
        listView.setOnItemClickListener ( new mItemClick () );
    }
    class mItemClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick ( AdapterView< ? > adapterView , View view , int i , long l ) {
            Toast.makeText ( getApplicationContext (),"您选择的项目是："+((TextView)view).getText (),Toast.LENGTH_SHORT ).show ();
        }
    }
}