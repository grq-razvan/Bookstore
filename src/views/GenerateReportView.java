package views;

import javax.swing.JButton;

import controllers.UserController;

public class GenerateReportView extends Window {

	private JButton text,xml;
	
	public GenerateReportView(){
		text = new JButton("Text report");
		xml = new JButton("XML report");
		
		panel.add(text);
		panel.add(xml);
		
		UserController.report(this);
	}

	public JButton getText() {
		return text;
	}

	public void setText(JButton text) {
		this.text = text;
	}

	public JButton getXml() {
		return xml;
	}

	public void setXml(JButton xml) {
		this.xml = xml;
	}
	
}
