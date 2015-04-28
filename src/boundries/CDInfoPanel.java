package boundries;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controllers.AddToWishlistController;
import controllers.WishlistController;

public class CDInfoPanel extends JPanel {

	JLabel cdLabel;
	JButton wishListButton;
	
	/**
	 * Create the panel.
	 */
	public CDInfoPanel(String cdName, Application app) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 6.0, 5.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 10.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		cdLabel = new JLabel(cdName);
		cdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cdLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cdLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_cdLabel = new GridBagConstraints();
		gbc_cdLabel.gridheight = 2;
		gbc_cdLabel.fill = GridBagConstraints.BOTH;
		gbc_cdLabel.gridwidth = 2;
		gbc_cdLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cdLabel.gridx = 1;
		gbc_cdLabel.gridy = 0;
		add(cdLabel, gbc_cdLabel);
		
		JButton buyButton = new JButton("Buy It Now");
		GridBagConstraints gbc_buyButton = new GridBagConstraints();
		gbc_buyButton.fill = GridBagConstraints.BOTH;
		gbc_buyButton.insets = new Insets(0, 0, 5, 5);
		gbc_buyButton.gridx = 3;
		gbc_buyButton.gridy = 0;
		add(buyButton, gbc_buyButton);
		
		wishListButton = new JButton("Add to Wish List");
		GridBagConstraints gbc_wishListButton = new GridBagConstraints();
		gbc_wishListButton.fill = GridBagConstraints.BOTH;
		gbc_wishListButton.insets = new Insets(0, 0, 5, 5);
		gbc_wishListButton.gridx = 3;
		gbc_wishListButton.gridy = 1;
		add(wishListButton, gbc_wishListButton);
		
		JLabel albumArtLabel = new JLabel("Album Art");
		albumArtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		albumArtLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		albumArtLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_albumArtLabel = new GridBagConstraints();
		gbc_albumArtLabel.fill = GridBagConstraints.BOTH;
		gbc_albumArtLabel.insets = new Insets(0, 0, 0, 5);
		gbc_albumArtLabel.gridx = 1;
		gbc_albumArtLabel.gridy = 2;
		add(albumArtLabel, gbc_albumArtLabel);
		
		JLabel albumInfoLabel = new JLabel("Album Info");
		albumInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		albumInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		albumInfoLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_albumInfoLabel = new GridBagConstraints();
		gbc_albumInfoLabel.gridwidth = 2;
		gbc_albumInfoLabel.fill = GridBagConstraints.BOTH;
		gbc_albumInfoLabel.insets = new Insets(0, 0, 0, 5);
		gbc_albumInfoLabel.gridx = 2;
		gbc_albumInfoLabel.gridy = 2;
		add(albumInfoLabel, gbc_albumInfoLabel);

		getWishListButton().addActionListener(new AddToWishlistController(app));
	}
	
	public JLabel getCDLabel(){
		return cdLabel;
	}
	
	public JButton getWishListButton(){
		return wishListButton;
	}

}
