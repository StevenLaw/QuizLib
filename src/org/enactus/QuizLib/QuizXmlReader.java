package org.enactus.QuizLib;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This class is to be used to pull a Quiz object from an XML file
 * 
 * @author Steven Law
 * @version 0.1
 */
public class QuizXmlReader {
	private File f;
	
	/**
	 * Creates the reader with the file to be read
	 * 
	 * @param f the file to be read
	 */
	public QuizXmlReader(File f) {
		super();
		this.f = f;
	}

	/**
	 * Reads an xml file and returns the quiz inside as a Quiz object
	 * 
	 * @return the quiz that is represented in the file
	 * @throws Exception if the XML file is malformed or unreadable
	 */
	public Quiz getQuiz() throws Exception{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(f);
		
		// Normalize the document for best results
		doc.getDocumentElement().normalize();
		
		String name = doc.getDocumentElement().getAttribute("name");
		String difficulty = doc.getDocumentElement().getAttribute("difficulty");
		
		Quiz q = new Quiz(name, difficulty);
		
		// Retrieve the list of question nodes
		NodeList qList = doc.getElementsByTagName("Question");
	 
		for (int temp = 0; temp < qList.getLength(); temp++) {
	 
			// Get the current item
			Node qNode = qList.item(temp);
	 
			// Ensure that the current item is an element node
			if (qNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				// Cast the current item as an element
				Element qElement = (Element) qNode;
				
				int id = Integer.parseInt(qElement.getAttribute("id"));
				int maxPoints = Integer.parseInt(qElement.getAttribute("maxPoints"));
				String text = qElement.getElementsByTagName("Text").item(0).getTextContent();

				// Retrieve the list of answer nodes
				NodeList aList = qElement.getElementsByTagName("Answer");
	 
				ArrayList<Answer> answers = new ArrayList<Answer>();
				
				for (int i = 0; i < aList.getLength(); i++) {
					Node aNode = aList.item(i);
					
					if (aNode.getNodeType() == Node.ELEMENT_NODE) {
						Element aElement = (Element) aNode;
						
						int aId = Integer.parseInt(aElement.getAttribute("id"));
						int points = Integer.parseInt(aElement.getAttribute("points"));
						String aText = aElement.getElementsByTagName("Text").item(0).getTextContent();
						String aExplanation = aElement.getElementsByTagName("Explanation").item(0).getTextContent();

						Answer a = new Answer(aId, points, aText, aExplanation);
						answers.add(a);
					}
				}
				Question question = new Question(id, maxPoints, text, answers);
				q.add(question);
			}
		}
		
		return q;
	}
	
	/**
	 * This static method will return an ArrayList of Catalog items that contain the names and difficulties of
	 * the quix files in the directory.
	 * 
	 * @param directory the directory to look for quizes in
	 * @return the list of quizes
	 */
	public static ArrayList<QuizCatalogItem> getQuizCatalog(String directory) throws Exception {
		// TODO Test the Catalog building code
		ArrayList<QuizCatalogItem> catalog = new ArrayList<QuizCatalogItem>();
		
		File folder = new File(directory);
		File[] files = folder.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			String name = files[i].getName();
			if(name.toLowerCase().endsWith(".xml")) {
				QuizXmlReader reader = new QuizXmlReader(new File(directory + "/" + name));
				Quiz q = reader.getQuiz();
				
				catalog.add(new QuizCatalogItem(q.getName(), q.getDifficulty()));
			}
		}
		
		return catalog;
	}
}
