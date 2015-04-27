package views;

import controllers.UserController;

import javax.swing.*;
import java.awt.*;

public class UserDeleteView extends Window {
    private JButton clear, submit;
    private JTextField id;

    public UserDeleteView() {
        clear = new JButton("Clear");
        submit = new JButton("Delete");
        id = new JTextField();
        JLabel operation = new JLabel("<html><font size=5 color='white'>Delete user</font></html>");
        JLabel idLabel = new JLabel("ID: ");
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(400, 160, 50, 30);
        id.setBounds(450, 160, 80, 30);
        submit.setBounds(385, 220, 80, 30);
        clear.setBounds(490, 220, 80, 30);
        operation.setBounds(420, 90, 140, 50);
        panel.add(id);
        panel.add(submit);
        panel.add(clear);
        panel.add(operation);
        panel.add(idLabel);

        UserController.delete(this);
    }

    public JButton getClear() {
        return clear;
    }

    public void setClear(JButton clear) {
        this.clear = clear;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }
}
