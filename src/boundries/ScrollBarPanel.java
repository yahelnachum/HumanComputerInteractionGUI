package boundries;

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
import java.awt.Dimension;

public class ScrollBarPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScrollBarPanel(ArrayList<String> list) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 0, 150, 0};
		gridBagLayout.rowHeights = new int[]{0, 150, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 10.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Artists");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setPreferredSize(new Dimension(150, 150));
		btnNewButton.setMaximumSize(new Dimension(150, 150));
		btnNewButton.setIcon(new ImageIcon(".\\src\\resources\\left_arrow.png"));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		ScrollBarContentsPanel panel = new ScrollBarContentsPanel(list);
		//panel.setPreferredSize(new Dimension(2000, 10));
		scrollPane.setViewportView(panel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setMaximumSize(new Dimension(150, 150));
		btnNewButton_1.setPreferredSize(new Dimension(150, 150));
		btnNewButton_1.setIcon(new ImageIcon(".\\src\\resources\\right_arrow.png"));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}
	
	//scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue()+10);

}
