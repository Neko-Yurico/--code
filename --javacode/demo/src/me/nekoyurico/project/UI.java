package me.nekoyurico.project;

import Test.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JLabel labell;

    public UI ( ) {
        //添加图标
        setPicture();
        //获取串口列表Port
        Object[] options = ComPortScanUtil.getComPorts ( );// ComPortScanUtil.getComPorts () 获取一个串口列表
        String Port = ( String ) JOptionPane.showInputDialog ( null , "请选择输出串口:\n" , "ComC" , JOptionPane.PLAIN_MESSAGE , new ImageIcon ( ) , options , "xx" );
        Port.trim ( );
        Exp exp = new Exp(LED1RadioButton,LED2RadioButton,LED3RadioButton);
        exp.start();
        MyPortThread threadPort = new MyPortThread ( );
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
        //程序开始后直接启动流水灯
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
                        byte[] bytes = {0x00};
                        Sp.ControlLed ( bytes );
                        try {
                            Thread.sleep ( 500 );
                        }
                        catch ( InterruptedException interruptedException ) {
                            interruptedException.printStackTrace ( );
                        }
                        System.exit ( 0 );
                    } else {
                        String Port = Arrays.toString(ComPortScanUtil.getComPorts());
                        if(Port=="[]"){
                            setUnable();
                        }else{
                            Sp.close ( );
                            mainButton.setText ( "重新启动" );
                            Label1.setText("已暂停");
                            IsRun[ 0 ] = false;
                        }
                    }
                } else {
                    Sp.open ( );
                    mainButton.setText ( "退出/暂停" );
                    Label1.setText("当前没有定时任务");
                    IsRun[ 0 ] = true;
                }
            }
        } );
        //流水灯的延时控制
        TimeSetButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String Port = Arrays.toString(ComPortScanUtil.getComPorts());
                if(Port=="[]"){
                    setUnable();
                }else{
                    try{
                        String str = JOptionPane.showInputDialog(null,"需要在多少秒后启动/关闭？","定时器",JOptionPane.PLAIN_MESSAGE);
                        boolean is = isDigit ( str );//判断输入的是否是数字
                        if(is){
                            setTime setTime = new setTime(str,Label1);
                            setTime.start ();
                        }else {
                            JOptionPane.showMessageDialog ( null, "输入有误", "提示", JOptionPane.YES_NO_OPTION);
                        }
                    }
                    catch ( Exception exception ) {
                        exception.printStackTrace ( );
                    }
                }
            }
        } );
        //流水灯控制
        LEDStringButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String Port = Arrays.toString(ComPortScanUtil.getComPorts());
                if(Port=="[]"){
                    setUnable();
                }else{
                    if ( IsRun[ 0 ] ){
                        Sp.change ( );
                    }
                }
            }
        } );
        //单灯控制
        SingleLightControlButton.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String Port = Arrays.toString(ComPortScanUtil.getComPorts());
                if(Port=="[]"){
                    setUnable();
                }else{
                    Sp.close ();
                    Button1.setEnabled ( !Button1.isEnabled () );
                    Button2.setEnabled ( !Button2.isEnabled () );
                    Button3.setEnabled ( !Button3.isEnabled () );
                    LEDStringButton.setEnabled( !LEDStringButton.isEnabled() );
                    TimeSetButton.setEnabled( !TimeSetButton.isEnabled() );
                }
            }
        } );
        //单灯控制开关
        Button1.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String Port = Arrays.toString(ComPortScanUtil.getComPorts());
                if(Port=="[]"){
                    setUnable();
                }else{
                    boolean flag = LED1RadioButton.isSelected ( );
                    if ( flag == true ){
                        byte[] bytes = {0x10};
                        Sp.ControlLed ( bytes );
                        //
                        Icon LED1Radio = new ImageIcon("image\\LED-Off.png");
                        LED1RadioButton.setIcon(LED1Radio);
                        LED1RadioButton.setSelected ( !LED1RadioButton.isSelected () );
                    }else {
                        byte[] bytes = {0x11};
                        Sp.ControlLed ( bytes );
                        //
                        Icon LED1Radio = new ImageIcon("image\\LED-Red.png");
                        LED1RadioButton.setIcon(LED1Radio);
                        LED1RadioButton.setSelected ( !LED1RadioButton.isSelected () );
                    }
                }
            }
        } );
        Button2.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String Port = Arrays.toString(ComPortScanUtil.getComPorts());
                if(Port=="[]"){
                    setUnable();
                }else{
                    boolean flag = LED2RadioButton.isSelected ( );
                    if ( flag == true ){
                        byte[] bytes = {0x20};
                        Sp.ControlLed ( bytes );
                        //
                        Icon LED2Radio = new ImageIcon("image\\LED-Off.png");
                        LED2RadioButton.setIcon(LED2Radio);
                        LED2RadioButton.setSelected ( !LED2RadioButton.isSelected () );
                    }else {
                        byte[] bytes = {0x21};
                        Sp.ControlLed ( bytes );
                        //
                        Icon LED2Radio = new ImageIcon("image\\LED-Green.png");
                        LED2RadioButton.setIcon(LED2Radio);
                        LED2RadioButton.setSelected ( !LED2RadioButton.isSelected () );
                    }
                }
            }
        } );
        Button3.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String Port = Arrays.toString(ComPortScanUtil.getComPorts());
                if(Port=="[]"){
                    setUnable();
                }else{
                    boolean flag = LED3RadioButton.isSelected ( );
                    if ( flag == true ){
                        byte[] bytes = {0x30};
                        Sp.ControlLed ( bytes );
                        Icon LED3Radio = new ImageIcon("image\\LED-Off.png");
                        LED3RadioButton.setIcon(LED3Radio);
                        LED3RadioButton.setSelected ( !LED3RadioButton.isSelected () );
                    }else {
                        byte[] bytes = {0x31};
                        Sp.ControlLed ( bytes );
                        //
                        Icon LED3Radio = new ImageIcon("image\\LED-Blue.png");
                        LED3RadioButton.setIcon(LED3Radio);
                        LED3RadioButton.setSelected ( !LED3RadioButton.isSelected () );
                    }
                }
            }
        } );
    }
    //判断是否为数字
    private boolean isDigit ( String x ) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return x.matches ( reg );
    }
    //给按钮添加图标
    private void setPicture(){
        Icon LEDRadio = new ImageIcon("image\\LED-Off.png");
        LED1RadioButton.setIcon(LEDRadio);
        LED2RadioButton.setIcon(LEDRadio);
        LED3RadioButton.setIcon(LEDRadio);
        Icon LEDButton = new ImageIcon("image\\Button.png");
        LEDStringButton.setIcon(LEDButton);
        Icon main = new ImageIcon("image\\Power.png");
        mainButton.setIcon(main);
        Icon light1 = new ImageIcon("image\\light3.png");
        Icon light2 = new ImageIcon("image\\light1.png");
        Icon light3 = new ImageIcon("image\\light2.png");
        Button1.setIcon(light1);
        Button2.setIcon(light2);
        Button3.setIcon(light3);
        Icon light = new ImageIcon("image\\light.png");
        SingleLightControlButton.setIcon(light);
        Icon Time = new ImageIcon("image\\clock in.png");
        TimeSetButton.setIcon(Time);
    }
    //使按钮失效
    private void setUnable(){
        Button1.setEnabled (false);
        Button2.setEnabled (false);
        Button3.setEnabled (false);
        LEDStringButton.setEnabled(false);
        TimeSetButton.setEnabled(false);
        SingleLightControlButton.setEnabled ( false );
        JOptionPane.showMessageDialog ( null , "已与设备断开连接！" , "提示" , JOptionPane.ERROR_MESSAGE );
    }
    //
    public static void main ( String[] args ) {
        JFrame frame = new JFrame ( "UI" );
        frame.setBounds ( 500 , 200 , 0 , 0 );
        frame.setContentPane ( new UI ( ).panel1 );
        //
        JPanel imagePanel ;
        ImageIcon background;
        background = new ImageIcon("image\\Background.jpg");
            //把背景图片显示在一个标签里面
        JLabel label = new JLabel(background);
            //把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
            //把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel = (JPanel)frame.getContentPane();
        imagePanel.setOpaque(false);
        frame.getLayeredPane().setLayout(null);
            //把背景图片添加到分层窗格的最底层作为背景
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        frame.setSize(background.getIconWidth(),background.getIconHeight());
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.pack ( );
        frame.setVisible ( true );
    }
}
