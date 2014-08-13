package com.exercices.restaurant2;

public class Command {
	
	private final String commandMeal;
	private final Person commander;
	
	public Command(Person commander,String command){
		this.commander = commander;
		this.commandMeal = command;
	}
}
