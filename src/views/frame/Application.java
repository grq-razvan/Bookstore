package views.frame;

import views.LoginView;

import javax.swing.*;

public class Application {

    public static void show() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                new Frame();
                Frame.getFrame().add(new LoginView().getPanel());
            }
        });
    }

}
