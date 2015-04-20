package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import boundries.Application;
import boundries.ContentsLabel;

public class ContentsLabelController implements MouseListener{

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
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}