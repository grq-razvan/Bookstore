package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends Window implements View {
    private int counter, counterY;

    public MainView(String username) {
        JLabel helloMessage = new JLabel("<html><font size=5><b>Welcome, " + username + "!</b></font></html>");
        //helloMessage.setBounds(150, 0, 220, 50);
        helloMessage.setForeground(Color.WHITE);
        counter = 0;
        counterY = 0;
        moveLabel(helloMessage);
        panel.add(helloMessage);
    }

    private void moveLabel(JLabel label) {
        label.setBounds(counter, counterY, 220, 50);
        int timerDelay = 100;
        new javax.swing.Timer(timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                counter += 7;
                if (counter >= 970) {
                    counter = 0;
                }
                counterY = (int) (Math.pow(-1, counter) + 160);

                if (counterY > 400) {
                    counterY = 0;
                    counter = 0;

                }
                label.setBounds(counter, counterY + counter, 220, 50);
            }
        }).start();
        panel.repaint();
    }


}
