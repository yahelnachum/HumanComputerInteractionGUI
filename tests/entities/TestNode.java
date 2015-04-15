package entities;

import junit.framework.TestCase;

public class TestNode extends TestCase {
	
	public void testNode() {
		Node newNode = new Node("Hello");
		newNode.addChild("World!");
		newNode.addChild("World!");
		
		assertEquals(newNode.getName(), "Hello");
		assertEquals(newNode.getChild("World!").getName(), "World!");
		assertEquals(newNode.getChildren().size(), 1);
		assertEquals(newNode.hasChild("tool"), false);
		assertEquals(newNode.childrenToString(), "World!\n");
		
		newNode.addChild("Abercombie and Fitch");
		
		assertEquals(newNode.childrenToString(), "World!\nAbercombie and Fitch\n");
		
		newNode.sortChildren();
		
		assertEquals(newNode.childrenToString(), "Abercombie and Fitch\nWorld!\n");
	}
}
