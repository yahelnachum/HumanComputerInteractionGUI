package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import boundries.Application;
import boundries.LoginApp;

public class LoginButtonController implements ActionListener{

	Application app;
	public LoginButtonController(Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			
		}
		try {
			LoginApp frame = new LoginApp(app);
			app.setLoginApp(frame);
			frame.setVisible(true);
			app.setUpLoginWithCredentialsController();
		} catch (Exception e2) {
			e2.printStackTrace();
		}		
	}

}
