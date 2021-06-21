package Test;

import me.nekoyurico.project.ComPortScanUtil;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class Exp extends Thread {
    private JRadioButton b1;
    private JRadioButton b2;
    private JRadioButton b3;
    public Exp(JRadioButton b1,JRadioButton b2,JRadioButton b3){
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }
    @Override
    public void run() {
        while (true){
            String Port = Arrays.toString(ComPortScanUtil.getComPorts());
            if ( Objects.equals ( Port , "[]" ) ) {
                Sp.close ( );
                Icon LEDRadio = new ImageIcon ( "image\\LED-Off.png" );
                b1.setIcon ( LEDRadio );
                b2.setIcon ( LEDRadio );
                b3.setIcon ( LEDRadio );
                JOptionPane.showMessageDialog ( null , "已与设备断开连接！" , "提示" , JOptionPane.ERROR_MESSAGE );
                break;
            }
        }
    }

}
