package boundries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Font;

public class ScrollBarContentsPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public ScrollBarContentsPanel() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		String str = "Katey Perry is ";//a pop singer from the 80s";//, what is up with that smell over there";
		//str = HtmlLabelMaker.convertToHtml(str, 100);
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, HtmlLabelMaker.getFontSize()));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(100, 100));
		lblNewLabel.setPreferredSize(new Dimension(100, 100));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblNewLabel);
		
		

	}
}
