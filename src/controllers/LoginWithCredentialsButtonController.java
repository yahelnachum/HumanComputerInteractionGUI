package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import boundries.Application;
import boundries.UserProfile;
import entities.XMLReader;

public class LoginWithCredentialsButtonController implements ActionListener {

	Application app;
	
	public LoginWithCredentialsButtonController(Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		UserProfile user = XMLReader.readUserProfileCredentials("UserProfile.xml");
		
		if(app.getLoginApp().getUsernameTextField().getText().equals(user.getUserName()) &&
		   app.getLoginApp().getPasswordTextField().getText().equals(user.getPassword())){
			app.getLoginApp().setVisible(false);
			app.getLoginApp().dispose();//dispatchEvent(new WindowEvent(app.getLoginApp(), WindowEvent.WINDOW_CLOSING));
			app.getWishlistButton().setVisible(true);
			app.setupWishlistController();
		}
		else{
			app.getLoginApp().getIncorrectCredentialsLabel().setText("Incorrect Login Credentials, Please Try Again");
		}
	}

}
