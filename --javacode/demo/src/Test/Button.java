package Test;

import javax.swing.*;

public class Button extends JFrame {
    JButton button;
    String address;

    public Button(JButton b, String str){
        button = b;
        address = str;
    }

    public void setPicture(){
        Icon i1 = new ImageIcon(address);
        button.setIcon(i1);
    }
}
