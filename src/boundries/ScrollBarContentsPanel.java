package boundries;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import entities.Node;

public class ScrollBarContentsPanel extends JPanel {

	ArrayList<ContentsLabel> contentsLabels = new ArrayList<ContentsLabel>();
	/**
	 * Create the panel.
	 */
	public ScrollBarContentsPanel(ArrayList<Node> nodeList) {
		
		int i = 0;
		for(Node n: nodeList){
			ContentsLabel newContentsLabel = new ContentsLabel(n);
			newContentsLabel.setBounds(i*150, 0, 150, 150);
			add(newContentsLabel);
			contentsLabels.add(newContentsLabel);
			i++;
		}
		setPreferredSize(new Dimension((int)(155.085*i), 150));
	}
	
	public ArrayList<ContentsLabel> getListOfContentsLabel(){
		return contentsLabels;
	}
}
