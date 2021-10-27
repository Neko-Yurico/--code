package com.example.ex03_16;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        listView=findViewById ( R.id.listview1 );
        String[] data={
                "(1)荷塘月色",
                "(2)最炫民族风",
                "(3)天蓝蓝",
                "(4)最美天下",
                "(5)自由飞翔",
        };
        listView.setAdapter ( new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1,data ) );
        listView.setOnItemClickListener ( new mItemClick () );
    }
    class mItemClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick ( AdapterView< ? > adapterView , View view , int i , long l ) {
            Toast.makeText ( MainActivity.this,"你的选择是："+(( TextView )view).getText (),Toast.LENGTH_SHORT ).show ();
        }
    }
}