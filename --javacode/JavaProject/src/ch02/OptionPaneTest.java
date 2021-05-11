package ch02;

import javax.swing.*;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/5/11 14:39
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
public class OptionPaneTest {
    public static void main ( String[] args ) {
        String name =JOptionPane.showInputDialog ( "请输入名字" );
        System.out.println (name );
        JOptionPane.showMessageDialog ( null,"欢迎"+name );
        int isMale = JOptionPane.showConfirmDialog ( null,"你是男生吗" );
        System.out.println (isMale );
        String sportType=null;
        if ( isMale==0 ){
            String[] sportList = {"足球","篮球","游戏"};
            sportType=(String) JOptionPane.showInputDialog ( null,"清选择你喜欢的运动","title",JOptionPane.PLAIN_MESSAGE,null,sportList,null);
        }
        else if ( isMale==1 ){
            String[] sportList = {"1","2","3"};
            sportType=(String) JOptionPane.showInputDialog ( null,"清选择你喜欢的运动","title",JOptionPane.PLAIN_MESSAGE,null,sportList,null);
        }
        JOptionPane.showMessageDialog ( null,name +"喜欢"+sportType);
    }
}
