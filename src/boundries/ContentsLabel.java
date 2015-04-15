package boundries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ContentsLabel extends JLabel {

	int sideLength = 150;
	
	/**
	 * Create the panel.
	 */
	public ContentsLabel(String str1) {

		String str = str1;//"Katey Perry is a pop singer ";//from the 80s, what is up with that smell over there";
		int i = getFontSize(str);
		str = convertToHtml(str);
		setText(str);
		setFont(new Font("Tahoma", Font.PLAIN, i));//HtmlLabelMaker.getFontSize()));
		setHorizontalAlignment(SwingConstants.CENTER);
		setMaximumSize(new Dimension(sideLength, sideLength));
		setPreferredSize(new Dimension(sideLength, sideLength));
		setBorder(new LineBorder(new Color(0, 0, 0)));
	}

	public int getFontSize(String content){		
		
		if(isOneWord(content)){
			for(int i = 100; i > 0; i--){
				Font font = new Font("Tahoma", Font.PLAIN, i);//.stringWidth("d");
				BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
				FontMetrics fm = img.getGraphics().getFontMetrics(font);
				int width = fm.stringWidth(content);
				double result = (double)width/(double)sideLength*1.1;
				System.out.println(result);
				if(0.75 <= result && result <= 1.0){
					System.out.println(i);
					return i;
				}
			}
			return 10;
		}
		
		double[] list = new double[51];
		double d = 0.07;
		for(int i = 0; i < 51; i++){
			list[i] = d+i*0.02;
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
	
	public boolean isOneWord(String content){
		for(int i = 0; i < content.length(); i++){
			if(content.charAt(i) == ' ') return false;
		}
		
		return true;
	}
	
	public String convertToHtml(String content){
		String str = "<html><center>" + content + "</center></html>";
		
		return str;
	}
}
