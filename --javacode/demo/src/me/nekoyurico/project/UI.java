package me.nekoyurico.project;

import javax.swing.*;

/**
 * @author Neko_Yurico
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

public class UI {

    public static void main ( String[] args ) {
        JFrame frame = new JFrame ( "UI" );
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

}
