package me.nekoyurico.project;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Neko_Yurico，相欠
 * @description UI
 * @date 2021/5/5 22:37
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
 *   　　　　　　　　＃＃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＃　　　　　　　　　　　　　　　　　
 * 　　　　　　　　　＃＃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＃＃＃　　　　　　　　　　　　　　　　
 * 　　　　　　　　　＃＃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　＃＃＃　　　　　　　　　　　　　　　　
 * 　　　　　　　　　＃＃　　　＃＃　　　　　　＃＃　　　　　　　　　　　　　　　　　＃＃　　　　　　　　　　　　　　　　　
 * 　　　　　　　　　＃＃　　　＃＃　　　＃＃＃＃＃＃　　　　　　　　　　　　　　　＃＃＃　　　　　　　　　　　　　　　　　
 * 　　　　　　　　　＃＃　　　＃＃＃＃＃＃＃＃＃＃　　　　　　　　　　　　　　　　＃＃　　　　　　　　　＃＃　　　　　　　
 * 　　　　　　　　　＃＃　　　　＃＃＃＃　　　＃＃　　　　　　　　　　　　　　　　＃＃　　　　　＃＃＃＃＃＃＃　　　　　　
 * 　　　　　　　＃＃＃＃＃＃＃＃＃　　　　　　＃＃　　　　　　　　　　　　　　　＃＃＃＃＃＃＃＃＃＃＃＃＃＃　　　　　　　
 * 　　　＃＃＃＃＃＃＃＃＃＃＃＃＃　　　　　　＃＃　　　　　　　　　　　　　　　＃＃＃＃＃＃＃＃　　＃＃＃　　　　　　　　
 * 　　　　＃＃＃　＃＃　　　　　＃　　＃＃＃＃＃＃　　　　　　　　　　　　　　＃＃　　　＃＃　　　　＃＃　　　　　　　　　
 * 　　　　　　　＃＃＃＃＃　　　＃＃＃＃＃＃＃＃＃　　　　　　　　　　　　　＃＃＃　　　　＃＃　　＃＃　　　　　　　　　　
 * 　　　　　　　＃＃＃＃＃＃　　＃＃＃　　　　＃＃　　　　　　　　　　　　　＃＃　　　　＃＃＃　　　　　　　　　　　　　　
 * 　　　　　　＃＃＃＃＃＃＃＃　＃　　　　　　＃　　　　　　　　　　　　　＃＃　　　　　＃＃　　　　　　　　　　　　　　　
 * 　　　　　　＃＃　＃＃　＃＃　＃　　　　　＃＃　　　　　　　　　　　　＃＃　　　　　　＃＃＃　　　　　　　　　　　　　　
 * 　　　　　＃＃＃　＃＃　　＃　＃＃＃＃＃＃＃＃　　　　　　　　　　　＃＃　　　　　　＃＃＃＃　　　　　　　　　　　　　　
 * 　　　　　＃＃　　＃＃　　　　＃＃＃＃＃＃＃＃　　　　　　　　　　　　　　　　　　　＃＃　＃＃　　　　　　　　　　　　　
 * 　　　　＃＃　　　＃＃　　　　＃　　　　　＃＃　　　　　　　　　　　　　　　　　　＃＃＃　＃＃＃　　　　　　　　　　　　
 * 　　　＃＃＃　　　＃＃　　　　＃　　　　　＃＃　　　　　　　　　　　　　　　　　　＃＃　　　＃＃　　　　　　　　　　　　
 * 　　　＃＃　　　　＃＃　　　　＃　　　　　＃＃　　　　　　　　　　　　　　　　　＃＃＃　　　　＃＃　　　　　　　　　　　
 * 　　　＃　　　　　＃＃　　　　＃＃＃＃＃＃＃＃　　　　　　　　　　　　　　　　　＃＃　　　　　＃＃＃　　　　　　　　　　
 * 　　　　　　　　　＃＃　　　　＃＃＃＃＃＃＃＃　　　　　　　　　　　　　　　　＃＃　　　　　　　＃＃＃　　　　　　　　　
 * 　　　　　　　　＃＃＃　　　＃＃＃　　　　＃＃　　　　　　　　　　　　　　　＃＃　　　　　　　　　＃＃＃　　　　　　　　
 * 　　　　　　　　＃＃　　　　＃＃　　　　　＃＃　　　　　　　　　　　　　＃＃＃　　　　　　　　　　　＃＃＃＃＃＃　　　　
 * 　　　　　　　　　＃　　　　　＃　　　　　　　　　　　　　　　　　　＃＃＃＃　　　　　　　　　　　　＃＃＃＃＃＃　　　　
 * 　　　　　　　　　＃　　　　　　　　　　　　　　　　　　　　　　　＃＃＃　　　　　　　　　　　　　　　　　　　　　　　　
 * <p>
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */

@SuppressWarnings ( "serial" )
public class UI extends JFrame {
    public final int ledCNT = 3;
    private boolean ledStatus = false;
    public UI ( ) {
        Communication lights = new Communication ( "COM8" );
        ImageIcon imageOFF = new ImageIcon ( "led_off.jpg" );
        ImageIcon imageON = new ImageIcon ( "led_on.jpg" );
        // using JButton
        JButton leds = new JButton ( imageOFF );
        leds.addActionListener ( new ActionListener ( ) {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                if ( ledStatus ) {
                    leds.setIcon ( imageOFF );
                    //lights.setOneLed(1, 0);
                    ledStatus = false;
                }
                else {

                    leds.setIcon ( imageON );
                    //lights.setOneLed(1, 1);
                    ledStatus = true;
                }
            }
        } );
        // JFrame基本结构
        setTitle ( "LED Control" );
        setBounds ( 500 , 300 , 330 , 370 );
        setVisible ( true );
        setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        add ( leds );
    }
    public static void main ( String[] args ) {
        new UI ( );
    }
}