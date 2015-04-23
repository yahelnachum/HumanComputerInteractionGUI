package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import boundries.Application;
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
		// TODO Auto-generated method stub
		app.getScrollBarPanel().changeScrollBarContentsPanel(cl.getNode().getChildren(), cl.getNode().getChildrensLevel());
		app.updateControllers();
	}
}