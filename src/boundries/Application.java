package boundries;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Application extends JFrame {

	int frameWidth = 100;
	int frameHeight = 100;
	
	/**
	 * Create the frame.
	 */
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getDisplayBounds();
		setBounds(0, 0, frameWidth, frameHeight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 5.0, 1.0, 5.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTheCdWarehouse = new JLabel("The CD Warehouse");
		lblTheCdWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GridBagConstraints gbc_lblTheCdWarehouse = new GridBagConstraints();
		gbc_lblTheCdWarehouse.insets = new Insets(0, 0, 5, 0);
		gbc_lblTheCdWarehouse.gridx = 0;
		gbc_lblTheCdWarehouse.gridy = 0;
		panel.add(lblTheCdWarehouse, gbc_lblTheCdWarehouse);
		
		JLabel lblComeForAll = new JLabel("Come for all your musical needs");
		lblComeForAll.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblComeForAll = new GridBagConstraints();
		gbc_lblComeForAll.gridx = 0;
		gbc_lblComeForAll.gridy = 1;
		panel.add(lblComeForAll, gbc_lblComeForAll);
		
		ScrollBarPanel panel_1 = new ScrollBarPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		getContentPane().add(panel_1, gbc_panel_1);
	}
	
	public void getDisplayBounds(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		frameWidth = 600;//gd.getDisplayMode().getWidth();
		frameHeight = 300;//gd.getDisplayMode().getHeight();
	}
}
