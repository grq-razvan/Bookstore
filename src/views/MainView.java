package views;

import java.awt.Color;

import javax.swing.JLabel;

public class MainView extends Window implements View {

	public MainView(String username) {
		JLabel helloMessage = new JLabel("<html><font size=5><b>Welcome, "+username+"!</b></font></html>");
		helloMessage.setBounds(150, 0, 220, 50);
		helloMessage.setForeground(Color.WHITE);
		panel.add(helloMessage);
	}


}
