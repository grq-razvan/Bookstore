package views.frame;

import javax.swing.*;

public class Frame {

    private static JFrame frame;

    public Frame() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(960, 640);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("My bookstore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public static JFrame getFrame() {
        return frame;
    }

}
