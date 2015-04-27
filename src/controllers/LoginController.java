package controllers;

import services.UserValidator;
import views.LoginView;
import views.MainView;
import views.frame.Frame;
import views.menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    public static void loginAs(LoginView loginPage) {

        JButton submitParameter = loginPage.getSubmit();
        JButton exitParameter = loginPage.getExit();
        JTextField usernameField = loginPage.getUsernameField();
        JPasswordField passwordField = loginPage.getPasswordField();

        submitParameter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                Container container = Frame.getFrame().getContentPane();

                if (UserValidator.isUserValid(username, password)) {
                    if (UserValidator.isUserAdmin(username, password)) {
                        Frame.getFrame().setJMenuBar(
                                new Menu(true).getMenuBar());
                    } else {
                        Frame.getFrame().setJMenuBar(
                                new Menu(false).getMenuBar());
                    }
                    container.removeAll();
                    container.repaint();
                    container.revalidate();
                    container.add(new MainView(username).getPanel());
                    container.repaint();
                    container.revalidate();

                } else {
                    JOptionPane
                            .showMessageDialog(null,
                                    "Invalid username/password combination.Please try again!");
                    usernameField.setText("");
                    passwordField.setText("");
                    container.repaint();
                    container.revalidate();
                }
            }
        });

        exitParameter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
    }

}
