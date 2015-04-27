package main;

import services.UserValidator;
import views.frame.Application;

public class EntryPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.show();
		System.out.println(UserValidator.isUserAdmin("grq-stfn", new char[] {
				'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '2' }));
	}
}
