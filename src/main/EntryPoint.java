package main;

import java.util.ArrayList;
import java.util.List;

import models.User;
import services.UserService;

public class EntryPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bookProperties = new ArrayList<String>();
		bookProperties.add("1");
		bookProperties.add("30");
		bookProperties.add("Groovy in action");
		bookProperties.add("Manning");
		bookProperties.add("Geek");
		
		//new BookService().restockBook(1,16);
		//new BookService().restock(100);
		System.out.println(new UserService().isAdmin((User)	new UserService().match("grq-stfn","password2")));
		
	}

}
