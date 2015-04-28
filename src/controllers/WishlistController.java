package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundries.Application;
import entities.RootNode;
import entities.XMLReader;

public class WishlistController implements ActionListener{

	Application app;
	public WishlistController(Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RootNode root = XMLReader.readUserProfileWishList("UserProfile.xml");
		
		app.getScrollBarPanel().changeScrollBarContentsPanel(root.getAllCDs(), "Wishlist CDs");
		app.updateControllers();
	}

}
