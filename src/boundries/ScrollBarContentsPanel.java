package boundries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ScrollBarContentsPanel extends JPanel {
	
	int sideLength = 150;
	/**
	 * Create the panel.
	 */
	public ScrollBarContentsPanel() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		String str = "Katey Perry is a pop singer ";//from the 80s, what is up with that smell over there";
		int i = getFontSize(str);
		str = convertToHtml(str);
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, i));//HtmlLabelMaker.getFontSize()));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(sideLength, sideLength));
		lblNewLabel.setPreferredSize(new Dimension(sideLength, sideLength));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lblNewLabel);
	}
	
	public int getFontSize(String content){		
		double[] list = new double[51];
		double d = 0.07;
		for(int i = 0; i < 51; i++){
			list[i] = d+i*0.01;
		}
		
		for(int i = 50; i > 0; i--){
			Font font = new Font("Tahoma", Font.PLAIN, i);//.stringWidth("d");
			BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
			FontMetrics fm = img.getGraphics().getFontMetrics(font);
			int width = fm.stringWidth(content);
			double result = (double)width/(double)sideLength*list[i];
			System.out.println(result);
			if(0.75 <= result && result <= 1.0){
				System.out.println(i);
				return i;
			}
		}
		
		return 5;
	}
	
	public String convertToHtml(String content){
		String str = "<html><center>" + content + "</center></html>";
		
		return str;
	}
}
