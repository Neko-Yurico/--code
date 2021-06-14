package me.nekoyurico.project;

import Test.MyDateThread;
import Test.MyPortThread;
import Test.Sp;
import Test.StreamLED;
import com.fazecast.jSerialComm.SerialPort;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
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
        //获取串口列表Port
        Object[] options = ComPortScanUtil.getComPorts ( );// ComPortScanUtil.getComPorts () 获取一个串口列表
        String Port = ( String ) JOptionPane.showInputDialog ( null , "请选择输出串口:\n" , "ComC" , JOptionPane.PLAIN_MESSAGE , new ImageIcon ( ) , options , "xx" );
        Port.trim ( );
        MyPortThread threadPort = new MyPortThread ( );
        //测试串口
        threadPort.test ( Port );
        //时钟线程
        MyDateThread thread1 = new MyDateThread ( "timer" ,TimeLabel);
        thread1.start ( );
        
        try {
            Thread.sleep ( 1000 );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
        StreamLED streamLED = new StreamLED ( Port , LED1RadioButton, LED2RadioButton, LED3RadioButton);
        streamLED.start ( );
        
        boolean[] IsRun = { true };
        
        mainButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Object[] options = { "退出" , "暂停" };
                if ( IsRun[ 0 ] ) {
                    if ( JOptionPane.showOptionDialog ( null , "你想要做什么？" , "提示" , JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE , null , options , options[ 0 ] ) == JOptionPane.YES_OPTION ) {
                        Sp.close ( );
                        try {
                            Thread.sleep ( 500 );
                        }
                        catch ( InterruptedException interruptedException ) {
                            interruptedException.printStackTrace ( );
                        }
                        System.exit ( 0 );
                    } else {
                        thread1.close ( );
                        Sp.close ( );
                        mainButton.setText ( "重新启动" );
                        TimeLabel.setText ( "已暂停" );
                        IsRun[ 0 ] = false;
                    }
                } else {
                    thread1.open ( );
                    Sp.open ( );
                    mainButton.setText ( "退出/暂停" );
                    IsRun[ 0 ] = true;
                }
            }
        } );
        
        TimeSetButton.addActionListener ( new ActionListener ( ) {                  //定时器
            @Override
            public void actionPerformed ( ActionEvent e ) {
                try {
                    String str = JOptionPane.showInputDialog ( null , "需要在多少秒后启动/关闭？" , "定时器" , JOptionPane.PLAIN_MESSAGE );
                    boolean is = isDigit ( str );//判断输入的是否是数字
                    if ( is ) {
                        int time = Integer.parseInt (str);
                        for(int i = time;i >= 0;i--){
                            Label1.setText ( "当前任务剩余时间：" + i + "秒" );
                            Thread.sleep ( 1000 );
                        }
//                        TimeLabel.setVisible ( false );
//                        Robot r = new Robot ( );
//                        Label1.setText ( "当前任务剩余时间：" + time + "秒" );
//                        while ( time != 0 ) {
//                            r.delay ( 1000 );
//                            time--;
//                            Label1.setText ( "当前任务剩余时间：" + time + "秒" );
//                        }
//                        setTime setTime = new setTime ( str );
//                        setTime.start ( );
//                        if ( setTime.getIsStop ( ) ) {
//                            thread1.open ( );
//                            Sp.open ( );
//                            mainButton.setText ( "退出/暂停" );
//                            IsRun[ 0 ] = true;
//                        } else {
//                            thread1.close ( );
//                            Sp.close ( );
//                            mainButton.setText ( "重新启动" );
//                            TimeLabel.setText ( "已暂停" );
//                            IsRun[ 0 ] = false;
//                        }
                    } else {
                        JOptionPane.showMessageDialog ( null , "输入有误" , "提示" , JOptionPane.YES_NO_OPTION );
                    }
                }
                catch ( Exception exception ) {
                    exception.printStackTrace ( );
                }
            }
        } );
        
        LEDStringButton.addActionListener ( new ActionListener ( ) {                //流水灯控制
            @Override
            public void actionPerformed ( ActionEvent e ) {
                
                if ( IsRun[ 0 ] ){
                    Sp.change ( );
                }
            }
        } );
        
        SingleLightControlButton.addActionListener ( new ActionListener ( ) {       //单灯控制
            @Override
            public void actionPerformed ( ActionEvent e ) {
                Sp.close ();
                LED1RadioButton.setEnabled ( !LED1RadioButton.isEnabled () );
                LED2RadioButton.setEnabled ( !LED2RadioButton.isEnabled () );
                LED3RadioButton.setEnabled ( !LED3RadioButton.isEnabled () );
                
            }
        } );
//        LED1RadioButton.addItemListener ( new ItemListener ( ) {
//            @Override
//            public void itemStateChanged ( ItemEvent e ) {
////                sp sp=new sp ( Port );
//                byte[] bytes = {0x11};
//                Sp.ControlLed ( bytes );
//                LED1change ();
//            }
//        });
    }
    
    
    public static void main ( String[] args ) {
        JFrame frame = new JFrame ( "UI" );
        frame.setBounds ( 500 , 200 , 0 , 0 );
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
    
    class setTime extends Thread {                                      //定时
        String string;
        double num;
        boolean isStop = false;
    
        public setTime ( String str ) {
            string = str.trim ( );
        }
    
        public boolean getIsStop ( ) {
            return isStop;
        }
    
        @Override
        public void run ( ) {
            try {
                Scanner scanner = new Scanner ( string );
                num = scanner.nextInt ( );
                Label1.setText ( "当前任务剩余时间：" + num + "秒" );
                while ( num != 0 ) {
                    Thread.sleep ( 1000 );
                    num--;
                    Label1.setText ( "当前任务剩余时间：" + num + "秒" );
                }
                isStop = ! isStop;
            }
            catch ( InterruptedException e ) {
                e.printStackTrace ( );
            }
        }
    }
    
    public void LED1change ( ) {
        LED1RadioButton.setSelected ( ! LED1RadioButton.isSelected ( ) );
    }
    
    public void LED2change ( ) {
        LED2RadioButton.setSelected ( ! LED2RadioButton.isSelected ( ) );
    }
    
    public void LED3change ( ) {
        LED3RadioButton.setSelected ( ! LED3RadioButton.isSelected ( ) );
    }
    
    private boolean isDigit ( String x ) {                      //判断是否为数字
        String reg = "^[0-9]+(.[0-9]+)?$";
        return x.matches ( reg );
    }
    
}