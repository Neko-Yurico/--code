package Test;

import javax.swing.*;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/6/14 15:04
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
public class StreamLED extends Thread{
    private JRadioButton LED1RadioButton;
    private JRadioButton LED2RadioButton;
    private JRadioButton LED3RadioButton;
    byte[] bytes = { 0x00 };
    String Port ;

    public StreamLED(String s,JRadioButton L1,JRadioButton L2,JRadioButton L3){
        Port=s;
        LED1RadioButton = L1;
        LED2RadioButton = L2;
        LED3RadioButton = L3;
    }
    @Override
    public void run ( ) {
        Sp sp=new Sp ( Port );
        try {
            while ( true ) {
                while ( sp.isStream ) {
                    bytes[ 0 ] = 0x31;
                    sp.ControlLed ( bytes );
                    LED3change ();
                    Thread.sleep ( 500 );
                    bytes[ 0 ] = 0x30;
                    sp.ControlLed ( bytes );
                    LED3change ();
                    Thread.sleep ( 500 );
                    if ( sp.isStream ) {
                        bytes[ 0 ] = 0x21;
                        sp.ControlLed ( bytes );
                        LED2change ();
                        Thread.sleep ( 500 );
                        bytes[ 0 ] = 0x20;
                        sp.ControlLed ( bytes );
                        LED2change ();
                        Thread.sleep ( 500 );
                    }
                    if ( sp.isStream ) {
                        bytes[ 0 ] = 0x11;
                        sp.ControlLed ( bytes );
                        LED1change ();
                        Thread.sleep ( 500 );
                        bytes[ 0 ] = 0x10;
                        sp.ControlLed ( bytes );
                        LED1change ();
                        Thread.sleep ( 500 );
                    }
                }
                Thread.sleep ( 500 );
            }
        }
        catch ( InterruptedException e ) {
            e.printStackTrace ( );
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
    
}
