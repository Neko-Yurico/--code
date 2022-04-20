package com.example.ex08_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button createBtn, deleteBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        createBtn = findViewById(R.id.button1);
        deleteBtn = findViewById(R.id.button2);
        createBtn.setOnClickListener(new mClick());
        deleteBtn.setOnClickListener(new mClick());
        
    }
    
    class mClick implements View.OnClickListener {
        
        @Override
        public void onClick(View v) {
            if (v == createBtn) {
                new DBCreate ( );
            } else if (v == deleteBtn) {
                deleteDatabase(DBCreate.Database_name);
            }
        }
    }
    
    class DBCreate {
        static final String Database_name = "PhoneBook.db";
        private  DBCreate(){
            SQLiteDatabase db;
            String TABLE_NAME = "Users";
            String ID = "_id";
            String USER_NAME = "user_name";
            String ADDRESS = "address";
            String TELEPHONE = "telephone";
            String MALL_ADDRESS = "mail_address";
            String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER primary key autoincrement, " + USER_NAME + " text not null, " + TELEPHONE + " text not null, " + ADDRESS + " text not null, "
                                     + MALL_ADDRESS + " text not null " + ") ";
            db = openOrCreateDatabase( Database_name, Context.MODE_PRIVATE , null);
            db.execSQL(DATABASE_CREATE);
            
        }
    }
}
