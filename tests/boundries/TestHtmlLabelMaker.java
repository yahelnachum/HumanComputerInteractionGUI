package boundries;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;


public class TestHtmlLabelMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String list = HtmlLabelMaker.convertToHtml("Katy Perry is a pop singer from the 80s", 75);
		
		System.out.println(list);*/
		
		Font font = new Font("Serif", Font.PLAIN, 32);//.stringWidth("d");
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(font);
		int width = fm.stringWidth("Your string");
		System.out.println(width);
	}

}
