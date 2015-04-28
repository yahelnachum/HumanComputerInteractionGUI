package main;

import javax.swing.UIManager;

import boundries.Application;
import entities.RootNode;
import entities.XMLReader;

public class Main {
	
	public static void main(String[] args) {
				
		RootNode root = XMLReader.readCatalogueFile("project4.xml");;
		root.sortEverything();
		
		XMLReader.readUserProfileWishList("UserProfile.xml");
		XMLReader.readUserProfileCredentials("UserProfile.xml");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		try {
			Application frame = new Application(root);
			//JFrame frame = new JFrame();
			//frame.add(new ScrollBarContentsPanel());
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
