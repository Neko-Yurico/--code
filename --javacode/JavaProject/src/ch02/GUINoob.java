package ch02;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/25 15:57
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class GUINoob {
    public static void main ( String[] args ) throws InterruptedException {
        JLabel disp =new JLabel ( "这是文本标签") ;
        JTextField input = new JTextField ("我是输入框");
        JButton button =new JButton ("按钮") ;
        JFrame f = new JFrame("1");
        f.setBounds (100,100,500,200);
        f.setVisible (true );
        f.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        f.add ( disp, BorderLayout.NORTH );
        f.add ( input,BorderLayout.SOUTH );
        f.add ( button,BorderLayout.CENTER );
        while (true) {
            Date date = new Date ( );
            SimpleDateFormat sdf = new SimpleDateFormat ( "现在是yyyy年MM月dd日 E\naHH时mm分ss秒" );
            String z = sdf.format ( new Date ( ) );
            button.setText (z) ;
        }
    }
}
