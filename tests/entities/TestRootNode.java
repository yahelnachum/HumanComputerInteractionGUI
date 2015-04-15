package entities;

import junit.framework.TestCase;

public class TestRootNode extends TestCase {
	
	public void testRootNode(){
		RootNode root = new RootNode("root");
		root.addCDTitle("Going in the river",	"Beyonce", 	"Electronic Funk");
		root.addCDTitle("Going in the boat", 	"Weird Al", "Funk");
		root.addCDTitle("Going in the city", 	"Jayz", 	"Electronic");
		
		root.sortEverything();
		
		assertEquals(root.getCDTitles("Beyonce").getName(), "Beyonce");
		assertEquals(root.getChildren().size(), 3);
		
		root.addCDTitle("Where did you go", "Beyonce", "Electronic Funk");
		
		assertEquals(root.getCDTitles("Beyonce").getChildren().size(), 2);
		assertEquals(root.getArtists("Electronic").getChildren().get(0).getName(), "Jayz");
	}
}
