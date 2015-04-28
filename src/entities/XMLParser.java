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
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import boundries.UserProfile;

public class XMLParser {

	public static void createUserProfile(String username, String password){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			
			Element user = doc.createElement("User");
			user.setAttribute("name", username);
			user.setAttribute("password", password);
			
			doc.appendChild(user);
			
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(username+"UserProfile.xml"));
			transformer.transform(source, result);
		}
		catch (Exception e){
			
		}
			
	}
	
	public static void addCDToUserProfile(String fileName, String cd, String artist, String genre){
		try {
			
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node user = doc.getElementsByTagName("User").item(0);
			
			/*String userName = user.getAttributes().item(0).getTextContent();
			String password = user.getAttributes().item(1).getTextContent();
			
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("WishListCD");

			System.out.println("----------------------------");*/
			ArrayList<String> currentWishListInfo = new ArrayList<String>();
			/*for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
		
					currentWishListInfo.add(eElement.getElementsByTagName("title").item(0).getTextContent());
					currentWishListInfo.add(eElement.getElementsByTagName("artist").item(0).getTextContent());
					currentWishListInfo.add(eElement.getElementsByTagName("genre").item(0).getTextContent());
				}
			}*/
			
			currentWishListInfo.add(cd);
			currentWishListInfo.add(artist);
			currentWishListInfo.add(genre);
			
			Element userElement = (Element) user;
			
			Element wishlistElement = doc.createElement("WishListCD");
			
			Element genreName = doc.createElement("genre");
			genreName.appendChild(doc.createTextNode(genre));
			wishlistElement.appendChild(genreName);
			
			Element artistName = doc.createElement("artist");
			artistName.appendChild(doc.createTextNode(artist));
			wishlistElement.appendChild(artistName);
			
			Element cdTitle = doc.createElement("title");
			cdTitle.appendChild(doc.createTextNode(cd));
			wishlistElement.appendChild(cdTitle);
			userElement.appendChild(wishlistElement);
			
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(fileName));
			transformer.transform(source, result);
			
			/*DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();*/
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
			
			//System.out.println(user.getAttributes().item(0).getTextContent());
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
			root.sortEverything();
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
