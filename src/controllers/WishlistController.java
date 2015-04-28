package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundries.Application;
import entities.RootNode;
import entities.XMLParser;

public class WishlistController implements ActionListener{

	Application app;
	public WishlistController(Application app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RootNode root = XMLParser.readUserProfileWishList(app.getUsername()+"UserProfile.xml");
		
		app.getScrollBarPanel().changeScrollBarContentsPanel(root.getAllCDs(), "Wishlist CDs");
		app.updateControllers();
		
		app.setAtWishlist(true);
	}

}
