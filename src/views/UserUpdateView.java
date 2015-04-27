package views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.UserController;

public class UserUpdateView extends Window {
	private JButton clear, submit;
	private JTextField id, username;
	private JPasswordField password;
	private JCheckBox role;

	public UserUpdateView() {
		clear = new JButton("Clear");
		submit = new JButton("Update");
		id = new JTextField();
		username = new JTextField();
		password = new JPasswordField();
		role = new JCheckBox();
		role.setSelected(false);

		// TODO add labels and set bounds
		JLabel idLabel = new JLabel("ID: ");
		JLabel userLabel = new JLabel("Username: ");
		JLabel passLabel = new JLabel("Password: ");
		JLabel roleLabel = new JLabel("Role: ");
		
		JLabel operation = new JLabel("<html><font size=5 color='white'>Update employee</font></html>");
		
		idLabel.setBounds(390, 160, 50, 30);
		idLabel.setForeground(Color.WHITE);
		userLabel.setBounds(360, 200, 80, 30);
		userLabel.setForeground(Color.WHITE);
		passLabel.setBounds(360, 240, 80, 30);
		passLabel.setForeground(Color.WHITE);
		roleLabel.setBounds(390, 280, 50, 30);
		roleLabel.setForeground(Color.WHITE);
		id.setBounds(460, 160, 160, 30);
		username.setBounds(460, 200, 160, 30);
		password.setBounds(460, 240, 160, 30);
		role.setBounds(520, 280, 30, 30);
		operation.setBounds(440,90,180,50);
		
		submit.setBounds(430, 380, 80, 30);
		clear.setBounds(530, 380, 80, 30);
		

		panel.add(clear);
		panel.add(submit);
		panel.add(id);
		panel.add(username);
		panel.add(password);
		panel.add(role);
		panel.add(idLabel);
		panel.add(userLabel);
		panel.add(passLabel);
		panel.add(roleLabel);
		panel.add(operation);

		UserController.update(this);
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

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JCheckBox getRole() {
		return role;
	}

	public void setRole(JCheckBox role) {
		this.role = role;
	}
}