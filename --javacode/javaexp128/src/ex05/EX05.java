package ex05;

import javax.swing.*;
import java.awt.*;

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
public class EX05 {
    public static void main ( String[] args ) {

        JLabel disp = new JLabel ( "这是文本标签" );
        JTextField input = new JTextField ( "我是输入框" );
        JButton button = new JButton ( "按钮" );
        JFrame f = new JFrame ( "1" );
        f.setBounds ( 100 , 100 , 500 , 200 );
        f.setVisible ( true );
        f.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        f.add ( disp , BorderLayout.SOUTH );
        f.add ( input , BorderLayout.NORTH );
        f.add ( button , BorderLayout.CENTER );

        button.addActionListener ( actionEvent -> {
            try {
                String exp = input.getText ( );
                exp = exp.trim ( );
                ex05.Fx f1 = new ex05.Fx ( exp );
                String result = f1.getX ( );
                disp.setText ( result );
            } catch ( ex05.FxException exception ) {
                JOptionPane.showMessageDialog ( null , exception.getMessage ( ) , "发生异常" , JOptionPane.WARNING_MESSAGE );
            }
        } );
    }
}

