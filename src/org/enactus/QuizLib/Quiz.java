package org.enactus.QuizLib;

import java.util.ArrayList;;

/**
 * This is the main class in the quiz system.  It represents the entire quiz
 * including all of the questions that are to be a part of the quiz.
 * 
 * @author Steven Law
 * @version 0.1
 */
public class Quiz extends ArrayList<Question>{
	/**
	 * This is a generated serialVersionUID for use as Serializable
	 */
	private static final long serialVersionUID = -307757235943110336L;
	private String name;
	private String difficulty;
	private int current;
	
	/**
	 * Starts the current index as zero.
	 */
	public Quiz(){
		current = 0;
	}
	
	/**
	 * Sets the name, difficulty based on user input and sets the current
	 * index to zero.
	 * 
	 * @param name the name of the quiz
	 * @param difficulty the difficulty of the quiz
	 */
	public Quiz(String name, String difficulty) {
		super();
		this.name = name;
		this.difficulty = difficulty;
		current = 0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public int getCurrent() {
		return current;
	}
	
	/**
	 * This returns the question that the pointer is pointing at then increments the count.
	 * 
	 * @return the current question
	 */
	public Question nextQuestion(){
		Question tmp = this.get(current);
		current++;
		return tmp;
	}
}
