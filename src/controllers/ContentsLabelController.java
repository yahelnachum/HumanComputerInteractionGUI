package controllers;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundries.Application;
import boundries.CDInfoPanel;
import boundries.ContentsLabel;

public class ContentsLabelController extends MouseAdapter{

	Application app;
	ContentsLabel cl;
	public ContentsLabelController(Application app, ContentsLabel cl){
		this.app = app;
		this.cl = cl;
	}
	@Override
	public void mouseClicked(MouseEvent e) {

		if(cl.getNode().getChildrensLevel().equals("")){
			app.remove(app.getScrollBarPanel());
			
			CDInfoPanel scrollBarPanel = new CDInfoPanel(cl.getNode().getName(), app);
			GridBagConstraints gbc_scrollBarPanel = new GridBagConstraints();
			gbc_scrollBarPanel.gridwidth = 4;
			gbc_scrollBarPanel.insets = new Insets(0, 0, 5, 0);
			gbc_scrollBarPanel.fill = GridBagConstraints.BOTH;
			gbc_scrollBarPanel.gridx = 0;
			gbc_scrollBarPanel.gridy = 4;
			app.getContentPane().add(scrollBarPanel, gbc_scrollBarPanel);
			app.validate();
			app.repaint();
			
			app.setAtCDInfo(true);
			app.setCDInfoPanel(scrollBarPanel);
			
		}
		else{
			app.getScrollBarPanel().changeScrollBarContentsPanel(cl.getNode().getChildren(), cl.getNode().getChildrensLevel());
			app.updateControllers();
		}
	}
}