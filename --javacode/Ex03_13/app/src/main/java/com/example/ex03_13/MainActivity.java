package com.example.ex03_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.ex03_13.R;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button buttonLast, buttonNext;
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };
    private int index = 1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        imageView = findViewById(R.id.img);
        buttonLast = findViewById(R.id.btn_last);
        buttonNext = findViewById(R.id.btn_next);
        buttonLast.setOnClickListener(new mClick());
        buttonNext.setOnClickListener(new mClick());
    }
    
    class mClick implements View.OnClickListener {
        public void onClick(View view) {
            if (view == buttonLast) {
                if (index > 0 && index < imgs.length) {
                    index--;
                    imageView.setImageResource(imgs[index]);
                } else {
                    index = imgs.length - 1;
                    imageView.setImageResource(imgs[index]);
                }
            }
            if (view == buttonNext) {
                if (index >= 0 && index < imgs.length - 1) {
                    index++;
                    imageView.setImageResource(imgs[index]);
                } else {
                    index = 0;
                    imageView.setImageResource(imgs[index]);
                }
            }
        }
    }
}
