package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundries.Application;
import entities.XMLParser;

public class RegisterUserController implements ActionListener{

	Application app;
	
	public RegisterUserController(Application app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		app.setUsername(app.getRegisterApp().getUsernameTextField().getText());
		XMLParser.createUserProfile(app.getUsername(), app.getRegisterApp().getPasswordTextField().getText());
		
		app.getRegisterApp().setVisible(false);
		app.getRegisterApp().dispose();
	}
}
