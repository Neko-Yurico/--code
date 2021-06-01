package ex07;

import javax.security.auth.SubjectDomainCombiner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/6/1 14:42
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
public class EX07 {
    public static void main ( String[] args ) {
        new MyCalc (  );
    }
}

class MyCalc extends JFrame{
    public MyCalc(){
        setTitle("新计算器");
        setBounds(100,100,500,150);
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    
        JPanel Container = new JPanel ();
        add ( Container );
        
        JTextField input = new JTextField (20);
        input.setHorizontalAlignment ( JTextField.LEFT );
        input.setFont ( new Font ( "SERIF",0,30 ) );
        
        JButton bCalc =new JButton ("calc");
        bCalc.setFont (  new Font ( "SERIF",0,30 ) );
        
        JButton bCle =new JButton ("clear");
        bCle.setFont (  new Font ( "SERIF",0,30 ) );
        
        Container.add ( input );
        Container.add ( bCalc );
        Container.add ( bCle );
        
        
        bCalc.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                MathThread m=new MathThread ( input );
                Thread thread=new Thread (m);
                thread.start ();
            }
        } );
        
        bCle.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                input.setText ( "" );
            }
        } );
        
        setVisible ( true );
    }
    
    class MathThread implements Runnable{
        JTextField input;
        
        public MathThread(JTextField input){
            super();
            this.input=input;
        }
        @Override
        public void run(){
            try {
                String exp = input.getText ( );
                exp = exp.trim ( );
                Fx f1 = new Fx ( exp );
                String result = f1.getX ( );
                input.setText ( result );
            } catch ( FxException exception ) {
                JOptionPane.showMessageDialog ( null , exception.getMessage ( ) , "发生异常" , JOptionPane.WARNING_MESSAGE );
            }
        }
    }
}

