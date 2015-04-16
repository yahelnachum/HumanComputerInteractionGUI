package main;

import javax.swing.UIManager;

import boundries.Application;
import entities.RootNode;
import entities.XMLReader;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLReader reader = new XMLReader("project4.xml");
		reader.readFile();
		
		RootNode root = reader.getRootNode();
		root.sortEverything();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		try {
			Application frame = new Application(root.getChildrenAsString());
			//JFrame frame = new JFrame();
			//frame.add(new ScrollBarContentsPanel());
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
