package entities;

import junit.framework.TestCase;

public class TestXMLReader extends TestCase {

	public void testXMLReader(){
		XMLReader reader = new XMLReader("testXMLFile.xml");
		reader.readFile();
		
		RootNode root = reader.getRootNode();
		System.out.println(root.childrenToString());
		
		assertEquals(2, root.getArtists("Jazz").getChildren().size());
	}
}
