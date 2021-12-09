package com.example.calculatedemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    
    GridLayout gridLayout;
    EditText edResult;         // 计算器的显示界面
    
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edResult = findViewById(R.id.edResult);
        
        gridLayout = findViewById(R.id.gridlayout);
        int rowSize = gridLayout.getChildCount();
        for (int i = 1; i < rowSize; i++) {
            LinearLayout view = (LinearLayout) gridLayout.getChildAt(i);
            int colSize = view.getChildCount();
            for (int j = 0; j < colSize; j++) {
                Button button = (Button) view.getChildAt(j);
                button.setOnClickListener(this);
            }
        }
    }
    
    String currentNumber = "";   // 当前数字
    String previousNumber = "";  // 前一个数字
    String operator = "";        // 符号
    
    @SuppressLint ( "SetTextI18n" )
    public void onClick( View view) {
        if(view instanceof Button) {
            Button button = (Button)view;
            String btnStr = button.getText().toString();
            Log.i("calculator__",btnStr);
            
            switch (btnStr) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case ".":
                    // 字符串的拼接
                    currentNumber += btnStr;
                    // 将内容显示到 EditText
                    edResult.setText(currentNumber);
                    break;
                case"+":
                case"-":
                case"*":
                case"/":
                case"%":
                    operator = btnStr;
                    previousNumber = currentNumber;
                    currentNumber = "";
                    break;
                case"Del":
                    // 采用字符串截取的方式实现退格操作
                    currentNumber = currentNumber.substring(0,currentNumber.length() - 1);
                    edResult.setText(currentNumber);
                    break;
                case"AC":
                    // 清空数据
                    operator = "";
                    currentNumber = "";
                    previousNumber = "";
                    edResult.setText("");
                    break;
                case"=":
                    try{
                        double d1 = 0,d2 = 0,result = 0;
                        // RuntimeError(运行时异常,最好进行异常处理)
                        d1 = Double.parseDouble(previousNumber);
                        d2 = Double.parseDouble(currentNumber);
                        switch (operator) {
                            case"+":
                                result = d1 + d2;
                                break;
                            case"-":
                                result = d1 - d2;
                                break;
                            case"*":
                                result = d1 * d2;
                                break;
                            case"/":
                                result = d1 / d2;
                                break;
                            case"%":
                                result = d1 % d2;
                                break;
                        }
                        currentNumber = result + "";
                        // 实现多项式计算
                        edResult.setText(currentNumber+"");
                    } catch(NumberFormatException e) {
                        // 打印错误信息
                        Log.i("calculate__",e.getMessage() + "");
                    }
                    break;
            }
        }
    }
}