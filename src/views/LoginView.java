package views;

import controllers.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends Window implements View {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submit, exit;

    public LoginView() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        submit = new JButton("Submit");
        exit = new JButton("Exit");
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        usernameField.setBounds(680, 220, 140, 29);
        passwordField.setBounds(680, 265, 140, 29);
        usernameLabel.setBounds(580, 220, 140, 29);
        passwordLabel.setBounds(580, 265, 140, 29);
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        submit.setBounds(635, 325, 85, 30);
        exit.setBounds(745, 325, 80, 30);

        panel.add(usernameField);
        panel.add(usernameLabel);
        panel.add(passwordField);
        panel.add(passwordLabel);
        panel.add(submit);
        panel.add(exit);

        LoginController.loginAs(this);

    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

}
