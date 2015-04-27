package views;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
		submit = new JButton("Submit");
		id = new JTextField();
		username = new JTextField();
		password = new JPasswordField();
		role = new JCheckBox();
		role.setSelected(false);

		// TODO add labels and set bounds

		panel.add(clear);
		panel.add(submit);
		panel.add(id);
		panel.add(username);
		panel.add(password);
		panel.add(role);

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