package views;

import controllers.UserController;

import javax.swing.*;

public class GenerateReportView extends Window {

    private JButton text, xml;

    public GenerateReportView() {
        text = new JButton("Text report");
        xml = new JButton("XML report");

        xml.setBounds(310, 200, 100, 60);
        text.setBounds(510, 200, 100, 60);

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
