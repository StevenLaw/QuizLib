package org.enactus.QuizLib;

public class QuizCatalogItem {
	private String name;
	private String difficulty;
	
	public QuizCatalogItem(String name, String difficulty) {
		super();
		this.name = name;
		this.difficulty = difficulty;
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
}
