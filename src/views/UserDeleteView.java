package views;

import javax.swing.JButton;
import javax.swing.JTextField;

import controllers.UserController;

public class UserDeleteView extends Window {
	private JButton clear,submit;
	private JTextField id;
	
	public UserDeleteView(){
		clear = new JButton("Clear");
		submit = new JButton("Submit");
		id = new JTextField();
		
		panel.add(id);
		panel.add(submit);
		panel.add(clear);
		
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
