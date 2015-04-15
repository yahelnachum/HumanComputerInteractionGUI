package entities;

/* code was used from the following site for parsing the xml file:
 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
 * 
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLReader {

	String fileName;
	RootNode root = new RootNode("rootNode");
	
	public XMLReader(String fileName){
		this.fileName = fileName;
	}
	
	public void readFile(){
		try {

			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("cd");

			//System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				//System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					/*
					System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
					System.out.println("Artist : "+ eElement.getElementsByTagName("artist").item(0).getTextContent());
					System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
					*/
					
					root.addCDTitle(eElement.getElementsByTagName("title").item(0).getTextContent(), 
									eElement.getElementsByTagName("artist").item(0).getTextContent(), 
									eElement.getElementsByTagName("genre").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public RootNode getRootNode(){
		return root;
	}
}
