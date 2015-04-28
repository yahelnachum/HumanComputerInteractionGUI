package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundries.Application;

public class ScrollButtonController implements ActionListener {

	Application app;
	int delta;
	
	public ScrollButtonController(Application app, int delta) {
		this.app = app;
		this.delta = delta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 25; i++){
			app.getScrollBarPanel().getJScrollPane().getHorizontalScrollBar().setValue(app.getScrollBarPanel().getJScrollPane().getHorizontalScrollBar().getValue()+delta/25);
			try{Thread.sleep(10);}catch (Exception e1){}
		}
	}
}
