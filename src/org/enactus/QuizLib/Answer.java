package org.enactus.QuizLib;

/**
 * This class represents the answers that a Question can have.
 * 
 * @author Steven Law
 * @version 0.1
 */
public class Answer {
	private int id;
	private int points;
	private String text;
	private String explanation;
	
	public Answer(int id, int points, String text, String explanation) {
		super();
		this.id = id;
		this.points = points;
		this.text = text;
		this.explanation = explanation;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
}
