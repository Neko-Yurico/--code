package ch02;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/5/31 21:23
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
public class LoginForm {
    public static void main ( String[] args ) {
        new Login ( "登录器" );
    }
}

class Login extends JFrame {
    public Login ( String string ) {
        super ( string );
        JTextField usernameField;
        JPasswordField passwordField;
        JLabel label1, label2;
        JButton okButton;
        
        Font s32 = new Font ( "宋体" , Font.BOLD , 32 );
        Font s24 = new Font ( "宋体" , Font.BOLD , 24 );
        
        label1 = new JLabel ( "用户名" );
        usernameField = new JTextField ( 15 );
        label2 = new JLabel ( "密  码" );
        passwordField = new JPasswordField ( 15 );
        passwordField.setEchoChar ( '*' );
        okButton = new JButton ( "     登录     " );
        
        setLayout ( new FlowLayout ( ) );
        label1.setBounds ( 50 , 20 , 50 , 20 );
        label1.setFont ( s32 );
        label2.setBounds ( 50 , 60 , 50 , 20 );
        label2.setFont ( s32 );
        usernameField.setBounds ( 110 , 20 , 200 , 20 );
        usernameField.setFont ( s24 );
        passwordField.setBounds ( 110 , 60 , 200 , 20 );
        passwordField.setFont ( s24 );
        okButton.setBounds ( 150 , 20 , 320 , 20 );
        okButton.setFont ( s32 );
        
        okButton.addActionListener ( actionEvent -> {
            String c = String.valueOf ( passwordField.getPassword ( ) );
            String n = usernameField.getText ( );
            if ( Objects.equals ( c , n ) && ! Objects.equals ( c , "" ) ) {
                JOptionPane.showMessageDialog ( null , "欢迎用户" + n , "登录成功" , JOptionPane.PLAIN_MESSAGE );
                JOptionPane.showMessageDialog ( null , "用户" + n + "的密码为" + c , "登录成功" , JOptionPane.PLAIN_MESSAGE );
                JOptionPane.showMessageDialog ( null , "flag{Thl3_1s_@_fIa9}" , "Flag" , JOptionPane.PLAIN_MESSAGE );
            } else if ( Objects.equals ( c , "" ) || Objects.equals ( n , "" ) ) {
                JOptionPane.showMessageDialog ( null , "用户名或密码未输入" , "登录失败" , JOptionPane.ERROR_MESSAGE );
            } else {
                JOptionPane.showMessageDialog ( null , "用户名与密码不匹配" , "登录失败" , JOptionPane.ERROR_MESSAGE );
            }
            usernameField.setText ( "" );
            passwordField.setText ( "" );
        } );
        
        add ( label1 );
        add ( usernameField );
        add ( label2 );
        add ( passwordField );
        add ( okButton );
        setSize ( 350 , 180 );
        setLocationRelativeTo ( null );
        setVisible ( true );
        setResizable ( false );
        
        validate ( );
        
        setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );
    }
}
