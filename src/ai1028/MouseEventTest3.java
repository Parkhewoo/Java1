package ai1028;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTest3 extends JFrame {
    JLabel lblImg = new JLabel();

    public MouseEventTest3(){
        String[] btnText = {"pet1", "pet2", "pet3"};
        JPanel panel = new JPanel();
        for (int i = 0; i < btnText.length; i++) {
            JButton btn = new JButton(btnText[i]);
            btn.addMouseListener(btnMouseListener);
            panel.add(btn);
        }
        add("North", panel);
        add("Center", lblImg);
        lblImg.setOpaque(true);
        lblImg.setBackground(Color.WHITE);

        SetFrame.setFrame(this, "버튼에 따른 이미지 변경", 300, 300);
    }
    MouseListener btnMouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton eBtn = (JButton)e.getSource();
            ImageIcon imageIcon = null;
            switch (eBtn.getText()){
                case "pet1":
                    imageIcon = new ImageIcon("pets/pet01.png");
                    break;
                case "pet2":
                    imageIcon = new ImageIcon("pets/pet02.png");
                    break;
                case "pet3":
                    imageIcon = new ImageIcon("pets/pet03.png");
                    break;
            }
            lblImg.setIcon(imageIcon);
        }
    };

    public static void main(String[] args) {
        new MouseEventTest3();
    }
}
