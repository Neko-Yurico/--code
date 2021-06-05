package me.nekoyurico.project;

import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;


/**
 * @author Neko_Yurico,BOW
 * @description
 * @date 2021/5/6 12:35
 * ========================
 * <p>
 * ,---.   .--.    .-''-.  .--.   .--.      ,-----.                      ____     __   ___    _ .-------.   .-./`)     _______      ,-----.
 * |    \  |  |  .'_ _   \ |  | _/  /     .'  .-,  '.                    \   \   /  /.'   |  | ||  _ _   \  \ .-.')   /   __  \   .'  .-,  '.
 * |  ,  \ |  | / ( ` )   '| (`' ) /     / ,-.|  \ _ \                    \  _. /  ' |   .'  | || ( ' )  |  / `-' \  | ,_/  \__) / ,-.|  \ _ \
 * |  |\_ \|  |. (_ o _)  ||(_ ()_)     ;  \  '_ /  | :                    _( )_ .'  .'  '_  | ||(_ o _) /   `-'`"`,-./  )      ;  \  '_ /  | :
 * |  _( )_\  ||  (_,_)___|| (_,_)   __ |  _`,/ \ _/  |                ___(_ o _)'   '   ( \.-.|| (_,_).' __ .---. \  '_ '`)    |  _`,/ \ _/  |
 * | (_ o _)  |'  \   .---.|  |\ \  |  |: (  '\_/ \   ;  _ _     _ _  |   |(_,_)'    ' (`. _` /||  |\ \  |  ||   |  > (_)  )  __: (  '\_/ \   ;
 * |  (_,_)\  | \  `-'    /|  | \ `'   / \ `"/  \  ) /--( ' )---(_I_)-|   `-'  /     | (_ (_) _)|  | \ `'   /|   | (  .  .-'_/  )\ `"/  \  ) /
 * |  |    |  |  \       / |  |  \    /   '. \_/``".'  (_{;}_) (_(=)_) \      /       \ /  . \ /|  |  \    / |   |  `-'`-'     /  '. \_/``".'
 * '--'    '--'   `'-..-'  `--'   `'-'      '-----'   --(_,_)---(_I_)-  `-..-'         ``-'`-'' ''-'   `'-'  '---'    `._____.'     '-----'
 * <p>
 * d8888b.  .d88b.  db   d8b   db
 * 88  `8D .8P  Y8. 88   I8I   88
 * 88oooY' 88    88 88   I8I   88
 * 88~~~b. 88    88 Y8   I8I   88
 * 88   8D `8b  d8' `8b d8'8b d8'
 * Y8888P'  `Y88P'   `8b8' `8d8'
 * <p>
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */

public class UI {
    
    public UI ( ) {
        MyDateThread thread1 = new MyDateThread ( "timer" );
        thread1.start ();
        Communication.MyPortThread threadPort = new Communication.MyPortThread ();
        threadPort.test ();
        try {
            Thread.sleep ( 1000 );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
        StreamLED streamLED=new StreamLED ();
        streamLED.start ();
        
        final boolean[] IsRun = { true };
        
        mainButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Object[] options ={ "退出", "暂停" };
                if ( IsRun[ 0 ] ){
                    if ( JOptionPane.showOptionDialog( null, "你想要做什么？", "提示", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION)
                    {
                        streamLED.exit ();
                        try {
                            Thread.sleep ( 500 );
                        }
                        catch ( InterruptedException interruptedException ) {
                            interruptedException.printStackTrace ( );
                        }
                        System.exit(0);
                    }else
                    {
                        thread1.change ();
                        streamLED.change ();
                        mainButton.setText ( "重新启动" );
                        TimeLabel.setText ( "已暂停" );
                        IsRun[ 0 ] =false;
                    }
                }else {
                    thread1.change ();
                    streamLED.change ();
                    mainButton.setText ( "退出/暂停" );
                    IsRun[ 0 ]=true;
                }
            }
        } );
        
        TimeSetButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                try{
                    String str = JOptionPane.showInputDialog(null,"需要在多少秒后启动/关闭？","定时器",JOptionPane.PLAIN_MESSAGE);
                    boolean is = isDigit ( str );//判断输入的是否是数字
                    if(is){
                        setTime setTime = new setTime(str);
                        setTime.start ();
                        Thread.sleep ( setTime.getTime () );
                        if ( setTime.getIsStop () ){
                            thread1.change ();
                            streamLED.change ();
                            mainButton.setText ( "退出/暂停" );
                            IsRun[ 0 ]=true;
                        }else {
                            thread1.change ();
                            streamLED.change ();
                            mainButton.setText ( "重新启动" );
                            TimeLabel.setText ( "已暂停" );
                            IsRun[ 0 ] =false;
                        }
                    }else {
                        JOptionPane.showMessageDialog ( null, "输入有误", "提示", JOptionPane.YES_NO_OPTION);
                    }
                }
                catch ( Exception exception ) {
                    exception.printStackTrace ( );
                }
            }
        } );
        
        LEDStringButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
            }
        } );
        
        SingleLightControlButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
            
            }
        } );
    }
    
    
    
    public static void main ( String[] args ) {
        JFrame frame = new JFrame ( "UI" );
        frame.setBounds ( 500,200,0,0 );
        frame.setContentPane ( new UI ( ).panel1 );
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.pack ( );
        frame.setVisible ( true );
    }

    private JPanel panel1;
    private JRadioButton LED1RadioButton;
    private JRadioButton LED2RadioButton;
    private JRadioButton LED3RadioButton;
    private JButton LEDStringButton;
    private JButton SingleLightControlButton;
    private JButton TimeSetButton;
    private JButton mainButton;
    private JLabel TimeLabel;
    private JLabel Label1;
    
    class MyDateThread extends Thread{
        boolean i=true;
        public MyDateThread ( String s){
            setName ( s );
        }
        public void change(){
            i=!i;
        }
        @Override
        public void run ( ) {
            while ( true ){
                while ( i ){
                    try {
                        Date date = new Date ( );
                        SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy/MM/dd E\naHH:mm:ss" );
                        String z = sdf.format ( new Date ( ) );
                        TimeLabel.setText ( z );
                        sleep ( 500 );
                    }
                    catch ( InterruptedException e ) {
                        e.printStackTrace ( );
                    }
                }
            }
        }
    }
    
    class setTime extends Thread{
        String string;
        double num;
        boolean isStop =false;
        public setTime ( String str ) { string = str.trim ();}
        public long getTime(){
            Scanner scanner = new Scanner ( string );
            return scanner.nextLong ();
        }
        public boolean getIsStop(){return isStop;}
        @Override
        public void run(){
            try{
                Scanner scanner = new Scanner ( string );
                num =scanner.nextDouble ();
                Label1.setText ( "当前任务剩余时间："+num+"秒" );
                while ( num!=0 ){
                    Thread.sleep ( 1000 );
                    num--;
                    Label1.setText ( "当前任务剩余时间："+num+"秒" );
                }
                isStop =! isStop;
            }
            catch ( InterruptedException e ){
                e.printStackTrace ();
            }
        }
    }
    
    
    private boolean isDigit ( String x ) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return x.matches ( reg );
    }
}
