package Test;

import me.nekoyurico.project.ComPortScanUtil;

import javax.swing.*;
import java.util.Arrays;

public class Exp extends Thread {
    @Override
    public void run() {
        while (true){
            String Port = Arrays.toString(ComPortScanUtil.getComPorts());
            if(Port=="[]"){
                Sp.close();
                JOptionPane.showMessageDialog(null , "已与设备断开连接！" , "提示" , JOptionPane.YES_OPTION  );
                break;
            }
        }
    }
}
