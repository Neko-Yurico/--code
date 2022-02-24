package com.example.ex04_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.ex04_04.R;

public class MainActivity extends AppCompatActivity {
    TextView txt1,txt2,txt3;
    private static final int item1 = Menu.FIRST;
    private static final int item2 = Menu.FIRST + 1;
    private static final int item3 = Menu.FIRST + 2;
    String str[] = {"令狐冲","杨 过","萧 峰"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt1.setText(str[0].toString());
        txt2.setText(str[1].toString());
        txt3.setText(str[2].toString());
        registerForContextMenu(txt1);
        registerForContextMenu(txt2);
        registerForContextMenu(txt3);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("人物简介");
        //
        menu.add(0,item1,0,"武功");
        menu.add(0,item2,0,"战斗力");
        menu.add(0,item3,0,"经典语录");
    }
    
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        
        return true;
    }
}
