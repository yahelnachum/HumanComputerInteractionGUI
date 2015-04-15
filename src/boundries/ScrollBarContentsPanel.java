package boundries;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ScrollBarContentsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScrollBarContentsPanel(ArrayList<String> list) {
		
		int i = 0;
		for(String str: list){
			ContentsLabel lblNewLabel = new ContentsLabel(str);
			lblNewLabel.setBounds(i*150, 0, 150, 150);
			add(lblNewLabel);
			i++;
		}
		setPreferredSize(new Dimension((int)(155.085*i), 150));
	}
}
