package Test;

import me.nekoyurico.project.ComPortScanUtil;

import javax.swing.*;
import java.util.Arrays;

public class Exp extends Thread {
    private JRadioButton jb1;
    private JRadioButton jb2;
    private JRadioButton jb3;
    public Exp(JRadioButton jb1,JRadioButton jb2,JRadioButton jb3){
        this.jb1 = jb1;
        this.jb2 = jb2;
        this.jb3 = jb3;
    }
    @Override
    public void run() {
        while (true){
            String Port = Arrays.toString(ComPortScanUtil.getComPorts());
            if(Port=="[]"){
                Sp.close();
                Icon LEDRadio = new ImageIcon("image\\LED-Off.png");
                jb1.setIcon(LEDRadio);
                jb2.setIcon(LEDRadio);
                jb3.setIcon(LEDRadio);
                JOptionPane.showMessageDialog(null , "已与设备断开连接！" , "提示" , JOptionPane.YES_OPTION  );
                break;
            }
        }
    }
}
