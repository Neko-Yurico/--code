package Test;

import javax.swing.*;
import java.util.Scanner;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/6/14 15:02
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
public class setTime extends Thread {
    JLabel Label1;
    String string;
    double time;
    boolean isStop = false;
    
    public setTime ( String str , JLabel L ) {
        string = str.trim ( );
        Label1 = L;
    }
    
//    public long getTime ( ) {
//        Scanner scanner = new Scanner ( string );
//        return scanner.nextLong ( );
//    }
//
//    public boolean getIsStop ( ) {
//        return isStop;
//    }
    
    @Override
    public void run ( ) {
        try {
            Scanner scanner = new Scanner ( string );
            time = scanner.nextDouble ( );
            Label1.setText ( "当前任务剩余时间：" + time + "秒" );
            while ( time != 0 ) {
                Thread.sleep ( 1000 );
                time--;
                Label1.setText ( "当前任务剩余时间：" + time + "秒" );
            }
            boolean stage = Sp.getIsStream();
            if(stage){
                Sp.change();
                Label1.setText ( "流水灯已关闭" );
            }else{
                Sp.change();
                Label1.setText ( "流水灯已开启" );
            }
//            isStop = ! isStop;
        }
        catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
    }
    
}
