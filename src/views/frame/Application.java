package views.frame;

import javax.swing.SwingUtilities;

import views.LoginView;

public class Application {

	public static void show(){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Frame();
				Frame.getFrame().add(new LoginView().getPanel());
			}
		});
	}
	
}
