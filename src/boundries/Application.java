package boundries;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.BackButtonController;
import controllers.ContentsLabelController;
import controllers.LoginButtonController;
import controllers.LoginWithCredentialsButtonController;
import controllers.ScrollButtonController;
import controllers.WishlistController;
import entities.RootNode;

public class Application extends JFrame {

	protected final int frameWidth = 1200;
	protected final int frameHeight = 435;
	
	RootNode root;
	
	JPanel titlePanel;
	JLabel titleLabel;
	JLabel subtitleLabel;
	
	CDInfoPanel cdInfoPanel;
	
	ScrollBarPanel scrollBarPanel;
	private JButton backButton;
	
	boolean atCDInfo = false;
	private JButton loginButton;
	
	LoginApp loginApp;
	private JButton wishlistButton;
	/**
	 * Create the frame.
	 */
	public Application(RootNode root) {
		this.root = root;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//getDisplayBounds();
		setBounds(0, 0, frameWidth, frameHeight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 75, 50, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 20.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 5.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		backButton = new JButton("Go Back");
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_backButton.insets = new Insets(0, 0, 5, 5);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 0;
		getContentPane().add(backButton, gbc_backButton);
		
		loginButton = new JButton("Login");
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginButton.insets = new Insets(0, 0, 5, 5);
		gbc_loginButton.gridx = 2;
		gbc_loginButton.gridy = 0;
		getContentPane().add(loginButton, gbc_loginButton);
		
		wishlistButton = new JButton("Wishlist");
		GridBagConstraints gbc_wishlistButton = new GridBagConstraints();
		gbc_wishlistButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_wishlistButton.insets = new Insets(0, 0, 5, 0);
		gbc_wishlistButton.gridx = 3;
		gbc_wishlistButton.gridy = 0;
		getContentPane().add(wishlistButton, gbc_wishlistButton);
		wishlistButton.setVisible(false);
		
		// title panel
		titlePanel = new JPanel();
		GridBagConstraints gbc_titlePanel = new GridBagConstraints();
		gbc_titlePanel.gridwidth = 4;
		gbc_titlePanel.insets = new Insets(0, 0, 5, 5);
		gbc_titlePanel.fill = GridBagConstraints.BOTH;
		gbc_titlePanel.gridx = 0;
		gbc_titlePanel.gridy = 2;
		getContentPane().add(titlePanel, gbc_titlePanel);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{0, 0};
		gbl_titlePanel.rowHeights = new int[]{0, 0, 0};
		gbl_titlePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_titlePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
		
		// title label
		titleLabel = new JLabel("The CD Warehouse");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 0;
		titlePanel.add(titleLabel, gbc_titleLabel);
		
		// subtitle label
		subtitleLabel = new JLabel("Come for all your musical needs");
		subtitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_subtitleLabel = new GridBagConstraints();
		gbc_subtitleLabel.gridx = 0;
		gbc_subtitleLabel.gridy = 1;
		titlePanel.add(subtitleLabel, gbc_subtitleLabel);
		
		// scroll bar panel
		scrollBarPanel = new ScrollBarPanel(root.getChildren(), root.getChildrensLevel());
		GridBagConstraints gbc_scrollBarPanel = new GridBagConstraints();
		gbc_scrollBarPanel.gridwidth = 4;
		gbc_scrollBarPanel.insets = new Insets(0, 0, 5, 0);
		gbc_scrollBarPanel.fill = GridBagConstraints.BOTH;
		gbc_scrollBarPanel.gridx = 0;
		gbc_scrollBarPanel.gridy = 4;
		getContentPane().add(scrollBarPanel, gbc_scrollBarPanel);show();
		setUpControllers();
	}
	
	public JPanel getTitlePanel(){
		return titlePanel;
	}
	
	public JLabel getTitleLabel(){
		return titleLabel;
	}
	
	public JLabel getSubtitleLabel(){
		return subtitleLabel;
	}
	
	public ScrollBarPanel getScrollBarPanel(){
		return scrollBarPanel;
	}
	
	public RootNode getRoot(){
		return root;
	}
	
	public void setUpControllers(){
		
		ArrayList<ContentsLabel> contentsLabels = this.getScrollBarPanel().getScrollBarContentsPanel().contentsLabels;
		
		for(ContentsLabel cl: contentsLabels){
			cl.addMouseListener(new ContentsLabelController(this, cl));
		}
		
		backButton.addActionListener(new BackButtonController(this));
		loginButton.addActionListener(new LoginButtonController(this));
		scrollBarPanel.getLeftButton().addActionListener(new ScrollButtonController(this, -173));
		scrollBarPanel.getRightButton().addActionListener(new ScrollButtonController(this, 173));
	}
	
	public void updateControllers(){

		ArrayList<ContentsLabel> contentsLabels = this.getScrollBarPanel().getScrollBarContentsPanel().contentsLabels;
		
		for(ContentsLabel cl: contentsLabels){
			cl.addMouseListener(new ContentsLabelController(this, cl));
		}
	}
	
	public boolean getAtCDInfo(){
		return this.atCDInfo;
	}
	
	public void setAtCDInfo(boolean bool){
		this.atCDInfo = bool;
	}
	
	public CDInfoPanel getCDInfoPanel(){
		return this.cdInfoPanel;
	}
	
	public void setCDInfoPanel(CDInfoPanel cdInfoPanel){
		this.cdInfoPanel = cdInfoPanel;
	}
	
	public void setLoginApp(LoginApp app){
		this.loginApp = app;
	}
	
	public LoginApp getLoginApp(){
		return this.loginApp;
	}
	
	public void setUpLoginWithCredentialsController(){
		loginApp.getLoginWithCredentialsButton().addActionListener(new LoginWithCredentialsButtonController(this));
	}
	
	public JButton getWishlistButton(){
		return wishlistButton;
	}
	
	public void setupWishlistController(){
		wishlistButton.addActionListener(new WishlistController(this));
	}
}
