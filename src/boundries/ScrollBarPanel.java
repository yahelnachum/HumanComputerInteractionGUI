package boundries;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entities.Node;

public class ScrollBarPanel extends JPanel {

	JLabel categoryLabel;
	JButton leftButton;
	JButton rightButton;
	JScrollPane scrollPane;
	ScrollBarContentsPanel scrollBarContentsPanel;
	
	/**
	 * Create the panel.
	 */
	public ScrollBarPanel(ArrayList<Node> nodeList, String level) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 0, 150, 0};
		gridBagLayout.rowHeights = new int[]{0, 160, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 10.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// category label
		categoryLabel = new JLabel(level);
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_categoryLabel = new GridBagConstraints();
		gbc_categoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_categoryLabel.gridx = 1;
		gbc_categoryLabel.gridy = 0;
		add(categoryLabel, gbc_categoryLabel);
		
		// left button
		leftButton = new JButton("");
		leftButton.setMinimumSize(new Dimension(150, 150));
		leftButton.setPreferredSize(new Dimension(150, 150));
		leftButton.setMaximumSize(new Dimension(150, 150));
		leftButton.setIcon(new ImageIcon(".\\src\\resources\\left_arrow.png"));
		GridBagConstraints gbc_leftButton = new GridBagConstraints();
		gbc_leftButton.insets = new Insets(0, 0, 0, 0);
		gbc_leftButton.gridx = 0;
		gbc_leftButton.gridy = 1;
		add(leftButton, gbc_leftButton);
		
		// scroll pane
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		// scroll bar contents panel
		scrollBarContentsPanel = new ScrollBarContentsPanel(nodeList);
		//panel.setPreferredSize(new Dimension(2000, 10));
		scrollPane.setViewportView(scrollBarContentsPanel);
		
		// right button
		rightButton = new JButton("");
		rightButton.setMinimumSize(new Dimension(150, 150));
		rightButton.setMaximumSize(new Dimension(150, 150));
		rightButton.setPreferredSize(new Dimension(150, 150));
		rightButton.setIcon(new ImageIcon(".\\src\\resources\\right_arrow.png"));
		GridBagConstraints gbc_rightButton = new GridBagConstraints();
		gbc_rightButton.insets = new Insets(0, 0, 0, 0);
		gbc_rightButton.gridx = 2;
		gbc_rightButton.gridy = 1;
		add(rightButton, gbc_rightButton);

	}
	
	public JLabel getCategoryLabel(){
		return categoryLabel;
	}
	
	public JButton getLeftButton(){
		return leftButton;
	}
	
	public JButton getRightButton(){
		return rightButton;
	}
	
	public JScrollPane getJScrollPane(){
		return scrollPane;
	}
	
	public ScrollBarContentsPanel getScrollBarContentsPanel(){
		return scrollBarContentsPanel;
	}
	
	public void changeScrollBarContentsPanel(ArrayList<Node> nodeList, String level){
		scrollBarContentsPanel = new ScrollBarContentsPanel(nodeList);
		categoryLabel.setText(level);
		scrollPane.setViewportView(scrollBarContentsPanel);
	}
	
	//scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue()+10);

}
