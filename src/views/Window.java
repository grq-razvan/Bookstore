package views;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class Window {

	protected JPanel panel;

	protected Window() {
		panel = new JPanel();
		panel.setBackground(new Color(77, 79, 76));
		panel.setBounds(0, 0, 960, 640);
		panel.setVisible(true);
		panel.setLayout(null);
	}

	protected abstract void addListeners();

	public JPanel getPanel() {
		return panel;
	}

}
