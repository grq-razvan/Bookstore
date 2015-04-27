package controllers

import java.awt.event.ActionEvent
import java.awt.event.ActionListener

import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JOptionPane
import javax.swing.JPasswordField
import javax.swing.JTable
import javax.swing.JTextField
import javax.swing.table.DefaultTableModel

import models.User
import services.BookService
import services.GenerateBookReportService
import services.UserService
import views.GenerateReportView
import views.UserAddView
import views.UserDeleteView
import views.UserFindView
import views.UserListView
import views.UserUpdateView

class UserController {

	private static UserService userService
	private static GenerateBookReportService bookReportService

	public static void list(UserListView userView){
		JButton button = userView.getButton();
		boolean processed = false;
		button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(processed==false){
							userService = new UserService();
							List<User> booksToList = userService.list;
							JTable table = userView.getTable();
							DefaultTableModel model = (DefaultTableModel) table.getModel()
							for(User user in booksToList){
								Object[] row = [user.id.toString(), user.username, user.role==0?"Employee":"Administrator"];
								model.addRow(row);
								processed=true;
							}
						}
					}
				})
	}

	public static void add(UserAddView userView){
		JButton submit = userView.getSubmit()
		JButton clear = userView.getClear()
		JTextField id=userView.id
		JTextField username=userView.username
		JPasswordField pass=userView.password
		JCheckBox role = userView.role

		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
						username.setText("")
						pass.setText('')
						role.setSelected(false)
					}
				})

		submit.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						userService = new UserService();
						List<String> properties = [id.getText(), username.getText(), pass.getText(), role.isSelected()?"1":"0"]
						userService.append(properties)
						id.setText("")
						username.setText("")
						pass.setText('')
						role.setSelected(false)
					}
				})
	}

	public static void delete(UserDeleteView userView){
		JButton delete = userView.submit
		JButton clear = userView.clear
		JTextField id=userView.id

		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
					}
				})

		delete.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						userService = new UserService();
						userService.delete(Integer.valueOf(id.getText()))
						id.setText("")
					}
				})
	}
	public static void update(UserUpdateView userView){
		JButton submit = userView.getSubmit()
		JButton clear = userView.getClear()
		JTextField id=userView.id
		JTextField username=userView.username
		JPasswordField pass=userView.password
		JCheckBox role = userView.role

		clear.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						id.setText("")
						username.setText("")
						pass.setText('')
						role.setSelected(false)
					}
				})

		submit.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						userService = new UserService();
						List<String> properties = [id.getText(), username.getText(), pass.getText(), role.isSelected()?"1":"0"]
						userService.modify(Integer.valueOf(id.getText()),properties)
						id.setText("")
						username.setText("")
						pass.setText('')
						role.setSelected(false)
					}
				})
	}
	public static void report(GenerateReportView generateReportView){
		JButton text = generateReportView.getText();
		JButton xml = generateReportView.getXml();
		text.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookReportService = new GenerateBookReportService()
						bookReportService.generateReport(GenerateBookReportService.TXT)
						JOptionPane.showMessageDialog(null,"Report generated!");
					}
				})
		xml.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						bookReportService = new GenerateBookReportService()
						bookReportService.generateReport(GenerateBookReportService.XML)
						JOptionPane.showMessageDialog(null,"Report generated!");
					}
				})
	}
	public static void find(UserFindView userView){
	}
}
