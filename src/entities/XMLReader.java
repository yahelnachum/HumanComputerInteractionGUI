package entities;

/* code was used from the following site for parsing the xml file:
 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
 * 
 * Formal Citation:
 * 
 * Mkyong. "How to Read XML File in Java – (DOM Parser)." Mkyongcom. N.p., n.d. Web. 15 
 * 		Apr. 2015. <http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/>. 
 */

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import boundries.UserProfile;

public class XMLReader {

	public static UserProfile readUserProfileCredentials(String fileName){
		try {
			
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node user = doc.getElementsByTagName("User").item(0);
			
			String userName = user.getAttributes().item(0).getTextContent();
			String password = user.getAttributes().item(1).getTextContent();
			
			return new UserProfile(userName, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static RootNode readUserProfileWishList(String fileName){
		try {

			RootNode root = new RootNode("rootNode");
			
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node user = doc.getElementsByTagName("User").item(0);
			
			System.out.println(user.getAttributes().item(0).getTextContent());
			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			/*System.out.println("Root element :" + doc.getDocumentElement().getNodeName());*/

			NodeList nList = doc.getElementsByTagName("WishListCD");

			/*System.out.println("----------------------------");*/

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				/*System.out.println("\nCurrent Element :" + nNode.getNodeName());*/

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
		
					root.addCDTitle(eElement.getElementsByTagName("title").item(0).getTextContent(), 
									eElement.getElementsByTagName("artist").item(0).getTextContent(), 
									eElement.getElementsByTagName("genre").item(0).getTextContent());
				}
			}
			
			return root;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static RootNode readCatalogueFile(String fileName){
		try {

			RootNode root = new RootNode("rootNode");
			
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			/*System.out.println("Root element :" + doc.getDocumentElement().getNodeName());*/

			NodeList nList = doc.getElementsByTagName("cd");

			/*System.out.println("----------------------------");*/

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				/*System.out.println("\nCurrent Element :" + nNode.getNodeName());*/

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					
					/*System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
					System.out.println("Artist : "+ eElement.getElementsByTagName("artist").item(0).getTextContent());
					System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());*/
					
					
					root.addCDTitle(eElement.getElementsByTagName("title").item(0).getTextContent(), 
									eElement.getElementsByTagName("artist").item(0).getTextContent(), 
									eElement.getElementsByTagName("genre").item(0).getTextContent());
				}
			}
			
			return root;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
