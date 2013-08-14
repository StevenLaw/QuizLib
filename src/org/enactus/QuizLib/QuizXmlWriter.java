package org.enactus.QuizLib;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class is used to convert a quiz object into an xml file
 * 
 * @author Steven Law
 * @version 0.1
 */
public class QuizXmlWriter {
	private File f;

	/**
	 * Creates the reader with the file to write to
	 * 
	 * @param f the file to write to 
	 */
	public QuizXmlWriter(File f) {
		super();
		this.f = f;
	}
	
	/**
	 * Converts a quiz object into xml and writes that to a file.
	 * 
	 * @param q the quiz object to write to file
	 * @throws Exception if the transformer or the parser fails
	 */
	public void writeQuiz(Quiz q) throws Exception{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		// Root elements
		Document doc = docBuilder.newDocument();
		Element quiz = doc.createElement("Quiz");
		
		// Add attributes to the quiz
		quiz.setAttribute("name", q.getName());
		quiz.setAttribute("difficulty", q.getDifficulty());
		
		doc.appendChild(quiz);
		
		for(Question qItem : q){
			// Create Question
			Element qElement = doc.createElement("Question");
			
			// Set the id attribute
			qElement.setAttribute("id", String.valueOf(qItem.getId()));
			
			// Set the maxPoints attribute
			qElement.setAttribute("maxPoints", String.valueOf(qItem.getMaxPoints()));
			
			// Create text element
			Element qText = doc.createElement("Text");
			qText.setTextContent(qItem.getText());
			qElement.appendChild(qText);
			
			ArrayList<Answer> answers = qItem.getAnswers();
			
			for(Answer aItem : answers){
				// Create Answer
				Element aElement = doc.createElement("Answer");
				
				// Set the id attribute
				aElement.setAttribute("id", String.valueOf(aItem.getId()));

				// Set the points attribute
				aElement.setAttribute("points", String.valueOf(aItem.getPoints()));
				
				// Create the text element
				Element aText = doc.createElement("Text");
				aText.setTextContent(aItem.getText());
				aElement.appendChild(aText);
				
				//Create the explanation element
				Element aExplanation = doc.createElement("Explanation");
				aExplanation.setTextContent(aItem.getExplanation());
				aElement.appendChild(aExplanation);
				
				// Add the answer to the question
				qElement.appendChild(aElement);
			}
			
			// Add the question to the quiz
			quiz.appendChild(qElement);
		}
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(f);
		
		// Output to console for testing
//		StreamResult result = new StreamResult(System.out);
		
		transformer.transform(source, result);
	}
}
