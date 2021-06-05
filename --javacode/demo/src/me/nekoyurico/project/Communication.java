package me.nekoyurico.project;

import com.fazecast.jSerialComm.SerialPort;
/**
 * @author Neko_Yurico，BOW
 * @description Communicate with the board
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

public class Communication extends Thread{
    
    static class MyPortThread {
        byte[] bytes= {0x00};
        public void test(){
            SerialPort sp;
            sp = SerialPort.getCommPort("COM3");
            sp.setBaudRate(9600);
            if (!sp.isOpen()) {
                sp.openPort();
             }
            try {
                bytes[0]=0x07;
                sp.writeBytes(bytes,1);
                Thread.sleep(100);
                bytes[0]=0x00;
                sp.writeBytes(bytes,1);
        
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sp.closePort ();
        }
    }
}
class StreamLED extends Thread{
    byte[] bytes= {0x00};
    boolean isStream=true;//判断流水灯是否开启
    public void exit(){
        isStream=false;
    }
    public void change(){
        isStream=!isStream;
    }
    @Override
    public void run ( ) {
        SerialPort sp;
        sp = SerialPort.getCommPort("COM3");
        sp.setBaudRate(9600);
        if (!sp.isOpen()) {
            sp.openPort();
        }
        super.run ( );
        try {
            while ( true ){
                while ( isStream ){
                    bytes[0]=0x31;
                    sp.writeBytes(bytes,1);
                    Thread.sleep(500);
                    bytes[0]=0x30;
                    sp.writeBytes(bytes,1);
                    Thread.sleep(500);
                }
                bytes[0]=0x00;
                sp.writeBytes ( bytes,1 );
                Thread.sleep(500);
            }
        }
        catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
    }
}