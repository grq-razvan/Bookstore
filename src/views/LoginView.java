package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import services.UserValidator;
import views.frame.Frame;
import views.menu.Menu;

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

		addListeners();

		panel.add(usernameField);
		panel.add(usernameLabel);
		panel.add(passwordField);
		panel.add(passwordLabel);
		panel.add(submit);
		panel.add(exit);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		submit.addActionListener(new ActionListener() {

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

	}

}
