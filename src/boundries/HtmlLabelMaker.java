package boundries;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HtmlLabelMaker {

	static final double METRIC_LENGTH = 0.2;  // smaller means more line length
	static final double METRIC_HEIGHT = 50.0; // bigger means less lines
	static final double METRIC_OTHER = 0.125;
	static final double METRIC_OTHER_OTHER = 120.0;
	static int fontSize = 0;
	
	public static String convertToHtml(String content, int panelSideLength){
		String start = "<html><center>";
		String end = "</center></html>";
		
		String str = start;
/*		
		ArrayList<String> blocks = new ArrayList<String>();		
		for(int i = 25; i > 0; i--){
			blocks = getBreakArray(content, i, panelSideLength);
			if(blocks.size()*METRIC_HEIGHT < panelSideLength){
				System.out.println("font size = " + i);
				fontSize = i;
				break;
			}
		}
		
		for(String line: blocks){
			str += line + "<br>";
		}
		
		str = str.substring(0, str.length()-4);*/
		for(int i = 25; i > 0; i++){
			Font font = new Font("Serif", Font.PLAIN, i);//.stringWidth("d");
			BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
			FontMetrics fm = img.getGraphics().getFontMetrics(font);
			int width = fm.stringWidth("Your string");
			fontSize = i;
			
		}
		str += content;
		
		str += end;
		System.out.println(fontSize);
		
		return str;
	}
	
	public static ArrayList<String> getBreakArray(String content, int fontSize, int panelSideLength){
		
		ArrayList<String> breakArray = new ArrayList<String>();
		
		int firstIndex = 0;
		int rollBackIndex = 0;
		String prev = content.substring(firstIndex, 1);
		String current;
		
		for(int i = 0; i < content.length(); i++){
			System.out.println("i = " + i);
			i = findNextSpaceIndex(content, i);
			if(i == -1){
				breakArray.add(content.substring(firstIndex));
				break;
			}
			
			current = content.substring(firstIndex, i);
			if(current.length()*METRIC_LENGTH*fontSize < panelSideLength){
				System.out.println(current);
				rollBackIndex = i;
				prev = current;
			}
			else if(i == content.length()-1){
				breakArray.add(content.substring(firstIndex));
			}
			else{
				breakArray.add(prev);
				i = rollBackIndex;
				firstIndex = i+1;
				prev = content.substring(i+1, i+2);
			}
		}
		
		return breakArray;
	}
	
	public static int findNextSpaceIndex(String content, int startIndex){
		for(int i = startIndex; i < content.length(); i++){
			if(content.charAt(i) == ' ') return i;
		}
		
		return -1;
	}
	
	public static int getFontSize(){
		return fontSize;
	}
}
