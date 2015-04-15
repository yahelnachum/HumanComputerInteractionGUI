package main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import boundries.Application;
import entities.RootNode;
import entities.XMLReader;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLReader reader = new XMLReader("testXMLFile.xml");
		reader.readFile();
		
		RootNode root = reader.getRootNode();
		root.sortEverything();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		//EventQueue.invokeLater(new Runnable() {
		//	public void run() {
				try {
					Application frame = new Application(root.getChildrenAsString());
					//JFrame frame = new JFrame();
					//frame.add(new ScrollBarContentsPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		//});
	}

}
