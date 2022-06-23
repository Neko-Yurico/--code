package com.example.appcurriculumdesign;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class ClassDatabaseHelper extends SQLiteOpenHelper {
    public ClassDatabaseHelper ( @Nullable Context context , @Nullable String name , @Nullable SQLiteDatabase.CursorFactory factory , int version ) {
        super ( context , name , factory , version );
    }
    
    @Override
    public void onCreate ( SQLiteDatabase sqLiteDatabase ) {
        String sqlCommand1 = "CREATE TABLE IF NOT EXISTS class (ID INTEGER NOT NULL UNIQUE PRIMARY KEY, NAME TEXT NOT NULL, BEFORENAME TEXT NOT NULL, TEACHER TEXT NOT NULL, TIME TEXT NOT NULL, POINT TEXT NOT NULL, TEST TEXT NOT NULL, NUMBER INTEGER NOT NULL);";
        //执行sql语句
        sqLiteDatabase.execSQL(sqlCommand1);
    }
    
    @Override
    public void onUpgrade ( SQLiteDatabase sqLiteDatabase , int i , int i1 ) {
    
    }
}
