package org.enactus.QuizLib;

import java.util.ArrayList;

/**
 * This class represents the individual questions.
 * 
 * It includes an ArrayList of answers to keep track of the answers
 * that the question will display.
 * 
 * @author Steven Law
 * @version 0.1
 */
public class Question {
	private int id;
	private int maxPoints;
	private String text;
	private ArrayList<Answer> answers;
	
	/**
	 * Sets the id and text based on the parameters.
	 * 
	 * @param id the question's id
	 * @param text the text of the question
	 */
	public Question(int id, int maxPoints, String text) {
		super();
		this.id = id;
		this.maxPoints = maxPoints;
		this.text = text;
	}
	
	/**
	 * Sets all of the classes properties at once.
	 * 
	 * @param id
	 * @param text
	 * @param answers
	 */
	public Question(int id, int maxPoints, String text, ArrayList<Answer> answers) {
		super();
		this.id = id;
		this.maxPoints = maxPoints;
		this.text = text;
		this.answers = answers;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
}
