package Test;

import javax.swing.*;

public class BackGround extends JFrame {
    public void setBg() {
        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon
                ("E:\\1.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
}
