package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.XMLParser;
import boundries.Application;

public class AddToWishlistController implements ActionListener {

	Application app;
	
	public AddToWishlistController(Application app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cd = app.getCDInfoPanel().getCDLabel().getText();
		String artist = app.getRoot().getArtist(cd);
		String genre = app.getRoot().getGenre(artist);

		XMLParser.addCDToUserProfile(app.getUsername()+"UserProfile.xml", cd, artist, genre);
	}
}
