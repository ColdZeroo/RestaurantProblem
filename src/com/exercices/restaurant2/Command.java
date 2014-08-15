package com.exercices.restaurant2;

public class Command {
	
	private String commandMeal;
	private final Person commander;
	
	public Command(Person commander,String command){
		this.commander = commander;
		this.commandMeal = command;
	}
	
	public boolean isSameCommand(){
		if(this.commandMeal.contains(CommandTypes.SAME))
			return true;
		else return false;
	}
	
	public boolean isForCommand(){
		if(this.commandMeal.contains(CommandTypes.FOR))
			return true;
		else return false;
	}
	
	public int numberOfPersonsForCommand(){
		if(this.isForCommand()){
			String[] commandParts = this.commandMeal.split("for");
			int number = Integer.parseInt(commandParts[1].trim());
			return number;
		}
		return -1;
	}
	
	public String mealOfPersonsForCommand(){
		if(this.isForCommand()){
			String[] commandParts = this.commandMeal.split("for");
			String meal = commandParts[0];
			return meal;
		}
		return null;
	}
	public String addCommandToOrder(){
		StringBuffer order = new StringBuffer();
		order.append(this.commandMeal);
		order.append(",");
		return order.toString();
	}

	public void copyCommand(Command sameCommand){
			sameCommand.commandMeal = this.commandMeal;
	}
	
	public int compareCommandTo(Command command){
		if(this.commander.equals(command.commander)){
			return 1;
		}
		else return -1;
	}
	public int orderTheSameMeal(Command command){
		if(this.commandMeal.equalsIgnoreCase(command.commandMeal)){
			return 1;
		}
		else return -1;
	}
}
