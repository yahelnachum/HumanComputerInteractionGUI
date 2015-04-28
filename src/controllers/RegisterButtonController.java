package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import boundries.Application;
import boundries.RegisterApp;

public class RegisterButtonController implements ActionListener{

	Application app;
	public RegisterButtonController(Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			
		}
		try {
			RegisterApp frame = new RegisterApp(app);
			app.setRegisterApp(frame);
			frame.setVisible(true);
			app.setUpRegisterUserController();
		} catch (Exception e2) {
			e2.printStackTrace();
		}		
	}

}
