package main;

import java.util.ArrayList;
import java.util.List;

import services.BookService;
import services.GenerateBookReportService;
import services.UserService;
import views.LoginView;
import views.frame.Frame;

public class EntryPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bookProperties = new ArrayList<String>();
		bookProperties.add("1");
		bookProperties.add("30");
		bookProperties.add("Groovy in action");
		bookProperties.add("Manning");
		bookProperties.add("Geek");

		// new BookService().restockBook(1,16);
		// new BookService().restock(100);
		// System.out.println(new BookService().getBooksOutOfStock());

		GenerateBookReportService serv = new GenerateBookReportService();
		serv.generateReport("XML format report");
		BookService b = new BookService();
		System.out.println(b.findById("0"));
		
		UserService u = new UserService();
		System.out.println(u.getList());
		
		new Frame().getFrame().add(new LoginView().getPanel());
	}
}
