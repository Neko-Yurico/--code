package ch02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/5/11 13:47
 * ========================
 * ,---.   .--.    .-''-.  .--.   .--.      ,-----.                      ____     __   ___    _ .-------.   .-./`)     _______      ,-----.
 * |    \  |  |  .'_ _   \ |  | _/  /     .'  .-,  '.                    \   \   /  /.'   |  | ||  _ _   \  \ .-.')   /   __  \   .'  .-,  '.
 * |  ,  \ |  | / ( ` )   '| (`' ) /     / ,-.|  \ _ \                    \  _. /  ' |   .'  | || ( ' )  |  / `-' \  | ,_/  \__) / ,-.|  \ _ \
 * |  |\_ \|  |. (_ o _)  ||(_ ()_)     ;  \  '_ /  | :                    _( )_ .'  .'  '_  | ||(_ o _) /   `-'`"`,-./  )      ;  \  '_ /  | :
 * |  _( )_\  ||  (_,_)___|| (_,_)   __ |  _`,/ \ _/  |                ___(_ o _)'   '   ( \.-.|| (_,_).' __ .---. \  '_ '`)    |  _`,/ \ _/  |
 * | (_ o _)  |'  \   .---.|  |\ \  |  |: (  '\_/ \   ;  _ _     _ _  |   |(_,_)'    ' (`. _` /||  |\ \  |  ||   |  > (_)  )  __: (  '\_/ \   ;
 * |  (_,_)\  | \  `-'    /|  | \ `'   / \ `"/  \  ) /--( ' )---(_I_)-|   `-'  /     | (_ (_) _)|  | \ `'   /|   | (  .  .-'_/  )\ `"/  \  ) /
 * |  |    |  |  \       / |  |  \    /   '. \_/``".'  (_{;}_) (_(=)_) \      /       \ /  . \ /|  |  \    / |   |  `-'`-'     /  '. \_/``".'
 * '--'    '--'   `'-..-'  `--'   `'-'      '-----'   --(_,_)---(_I_)-  `-..-'         ``-'`-'' ''-'   `'-'  '---'    `._____.'     '-----'
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */
public class MathOpGui {
    public static void main ( String[] args ) throws InterruptedException {

        JLabel disp = new JLabel ( "这是文本标签" );
        JTextField input = new JTextField ( "我是输入框" );
        JButton button = new JButton ( "按钮" );
        JFrame f = new JFrame ( "1" );
        f.setBounds ( 100 , 100 , 500 , 200 );
        f.setVisible ( true );
        f.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        f.add ( disp , BorderLayout.SOUTH);
        f.add ( input , BorderLayout.NORTH );
        f.add ( button , BorderLayout.CENTER );

        button .addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent actionEvent ) {
                String exp = input.getText ();
                exp = exp.trim ();
                Fx f = new Fx ( exp );
                String result = f.getX ();
                disp.setText (result);
            }
        });
    }
}

