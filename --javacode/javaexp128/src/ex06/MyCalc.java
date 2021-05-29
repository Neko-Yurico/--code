package ex06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Neko_Yurico
 * @description
 * @date 2021/5/25 13:58
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

public class MyCalc extends JFrame {
    public static String X="";
    public MyCalc ( String string ) {
        super(string);
        setBounds (200,200, 300,400 );
        setVisible ( true );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        
        JMenuBar menuBar=new JMenuBar ();
        setJMenuBar ( menuBar );
        
        JMenu menu=new JMenu ("文件");
        menuBar.add ( menu );
        
        JMenuItem item1 = new JMenuItem ("基本型",new ImageIcon ("basic.png"));
        JMenuItem item2 = new JMenuItem ("科学型",new ImageIcon ("steam.png"));
        JMenuItem item3 = new JMenuItem ("退出",new ImageIcon ("Exit.png"));
        menu.add ( item1 );
        menu.add ( item2 );
        menu.addSeparator (  );
        menu.add ( item3 );
        
        JLabel calcScreen = new JLabel ();
        calcScreen.setSize ( 280,100 );
        add ( calcScreen, BorderLayout.NORTH );
        calcScreen.setFont ( new Font ( "宋体", Font.BOLD, 40) );
        calcScreen.setHorizontalAlignment ( JLabel.RIGHT );
        calcScreen.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        calcScreen.setText ( "0" );
        
        JPanel buttonContainer = new JPanel ();
        add ( buttonContainer );
        String[] buttonNames ={"7","8","9","+","4","5","6","-","1","2","3","x",".","0","=","÷"};
        JButton button;
        for ( String bn : buttonNames ){
            button =new JButton (bn);
            button.setFont ( new Font ( "宋体", Font.PLAIN, 25) );
            button.setPreferredSize ( new Dimension (65,65) );
            buttonContainer.add ( button );
            button.addActionListener ( e -> {
                X=X+bn;
                calcScreen.setText ( X );
                if ( X.endsWith ( "=" ) ){
                    calcScreen.setText ( "0" );
                    X="";
                }
            } );
        }
        
        validate ();
    }
}
