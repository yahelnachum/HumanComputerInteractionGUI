package boundries;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class LoginApp extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	
	JButton loginWithCredentialsButton;

	int width = 450;
	int height = 300;
	private JLabel incorrectCredentialsLabel;
	/**
	 * Create the frame.
	 */
	public LoginApp(Application app) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(app.frameWidth/2-width/2, app.frameHeight/2-height/2, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel loginPromptLabel = new JLabel("<html><center>Please Log In Using Your Credentials</center></html>");
		loginPromptLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginPromptLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_loginPromptLabel = new GridBagConstraints();
		gbc_loginPromptLabel.fill = GridBagConstraints.BOTH;
		gbc_loginPromptLabel.insets = new Insets(0, 0, 5, 0);
		gbc_loginPromptLabel.gridx = 0;
		gbc_loginPromptLabel.gridy = 0;
		contentPane.add(loginPromptLabel, gbc_loginPromptLabel);
		
		incorrectCredentialsLabel = new JLabel("");
		incorrectCredentialsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectCredentialsLabel.setForeground(Color.RED);
		incorrectCredentialsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_incorrectCredentialsLabel = new GridBagConstraints();
		gbc_incorrectCredentialsLabel.fill = GridBagConstraints.VERTICAL;
		gbc_incorrectCredentialsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_incorrectCredentialsLabel.gridx = 0;
		gbc_incorrectCredentialsLabel.gridy = 1;
		contentPane.add(incorrectCredentialsLabel, gbc_incorrectCredentialsLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTextField.setText("UserName");
		GridBagConstraints gbc_usernameTextField = new GridBagConstraints();
		gbc_usernameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameTextField.fill = GridBagConstraints.BOTH;
		gbc_usernameTextField.gridx = 0;
		gbc_usernameTextField.gridy = 2;
		contentPane.add(usernameTextField, gbc_usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordTextField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordTextField.setText("Password");
		passwordTextField.setColumns(10);
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordTextField.fill = GridBagConstraints.BOTH;
		gbc_passwordTextField.gridx = 0;
		gbc_passwordTextField.gridy = 3;
		contentPane.add(passwordTextField, gbc_passwordTextField);
		
		loginWithCredentialsButton = new JButton("Login");
		loginWithCredentialsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_loginWithCredentialsButton = new GridBagConstraints();
		gbc_loginWithCredentialsButton.fill = GridBagConstraints.BOTH;
		gbc_loginWithCredentialsButton.gridx = 0;
		gbc_loginWithCredentialsButton.gridy = 4;
		contentPane.add(loginWithCredentialsButton, gbc_loginWithCredentialsButton);
	}
	
	public JButton getLoginWithCredentialsButton(){
		return this.loginWithCredentialsButton;
	}
	
	public JTextField getUsernameTextField(){
		return usernameTextField;
	}

	public JTextField getPasswordTextField(){
		return passwordTextField;
	}

	public JLabel getIncorrectCredentialsLabel(){
		return incorrectCredentialsLabel;
	}
}
