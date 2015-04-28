package controllers;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundries.Application;
import entities.Node;
import entities.RootNode;
import entities.XMLParser;

public class BackButtonController implements ActionListener {

	Application app;
	public BackButtonController(Application app) {
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(app.getAtCDInfo() && !app.getAtWishlist()){
			app.remove(app.getCDInfoPanel());
			
			String category = "";
			String subCategory = app.getScrollBarPanel().getScrollBarContentsPanel().getListOfContentsLabel().get(0).getText();
			subCategory = subCategory.substring(14, (subCategory.length()-16));
			
			Node cl = app.getRoot().getParent(subCategory, category);
			app.getScrollBarPanel().changeScrollBarContentsPanel(cl.getChildren(), cl.getChildrensLevel());
			app.updateControllers();
			
			GridBagConstraints gbc_scrollBarPanel = new GridBagConstraints();
			gbc_scrollBarPanel.gridwidth = 4;
			gbc_scrollBarPanel.insets = new Insets(0, 0, 5, 0);
			gbc_scrollBarPanel.fill = GridBagConstraints.BOTH;
			gbc_scrollBarPanel.gridx = 0;
			gbc_scrollBarPanel.gridy = 4;
			
			app.getContentPane().add(app.getScrollBarPanel(), gbc_scrollBarPanel);
			
			app.validate();
			app.repaint();
			app.setAtCDInfo(false);
		}
		else if(app.getAtCDInfo() && app.getAtWishlist()){
			app.setAtCDInfo(false);
			app.remove(app.getCDInfoPanel());
			
			RootNode cl = XMLParser.readUserProfileWishList(app.getUsername()+"UserProfile.xml");
			app.getScrollBarPanel().changeScrollBarContentsPanel(cl.getAllCDs(), "Wishlist CDs");
			app.updateControllers();
			
			GridBagConstraints gbc_scrollBarPanel = new GridBagConstraints();
			gbc_scrollBarPanel.gridwidth = 4;
			gbc_scrollBarPanel.insets = new Insets(0, 0, 5, 0);
			gbc_scrollBarPanel.fill = GridBagConstraints.BOTH;
			gbc_scrollBarPanel.gridx = 0;
			gbc_scrollBarPanel.gridy = 4;
			
			app.getContentPane().add(app.getScrollBarPanel(), gbc_scrollBarPanel);
			
			app.validate();
			app.repaint();
		}
		else if(app.getAtWishlist()){
			app.setAtWishlist(false);
		
			app.getScrollBarPanel().changeScrollBarContentsPanel(app.getRoot().getChildren(), app.getRoot().getChildrensLevel());
			app.updateControllers();
		}
		else if(!app.getScrollBarPanel().getCategoryLabel().getText().equals("Genres")){
			String category = app.getScrollBarPanel().getCategoryLabel().getText();
			String subCategory = app.getScrollBarPanel().getScrollBarContentsPanel().getListOfContentsLabel().get(0).getText();
			subCategory = subCategory.substring(14, (subCategory.length()-16));
			
			Node cl = app.getRoot().getParent(subCategory, category);
			app.getScrollBarPanel().changeScrollBarContentsPanel(cl.getChildren(), cl.getChildrensLevel());
			app.updateControllers();
		}
	}

	
}
