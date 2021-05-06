package me.nekoyurico.project;

import com.fazecast.jSerialComm.SerialPort;

/**
 * @author Neko_Yurico，相欠
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
public class Communication {


    public Communication ( String ComPort ) {
        super ( );
        // 初始化串口
        // blink,and set all off
        // 读取初始状态
        // ledStatus=readLeds();
    }
    public static void main ( String[] args ) {
        byte ledAllOff = 0x00;
        byte ledAllOn = 0x07;
        byte[] bytes = { ledAllOff };
        // private SerialPort[] allPorts;
        SerialPort sp;
        sp = SerialPort.getCommPort ( "COM8" );
        sp.setBaudRate ( 9600 );
        // test whether port is open
        if ( ! sp.isOpen ( ) ) {
            sp.openPort ( );
        }
        try {
            // all on,and set all off
            bytes[ 0 ] = ledAllOn;
            sp.writeBytes ( bytes , 1 );
            Thread.sleep ( 10 );
            bytes[ 0 ] = ledAllOff;
            sp.writeBytes ( bytes , 1 );
            Thread.sleep ( 500 );
            // seperate control
            bytes[ 0 ] = 0x11;
            sp.writeBytes ( bytes , 1 );
            Thread.sleep ( 2000 );
            bytes[ 0 ] = 0x10;
            sp.writeBytes ( bytes , 1 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace ( );
        }
    }
}
