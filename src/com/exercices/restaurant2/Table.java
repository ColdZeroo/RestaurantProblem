package com.exercices.restaurant2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Table {

	private final int tableId;
	private final int numberOfPersons;
	private List<Command> commands = new ArrayList<Command>();

	
	public Table(int numberOfPersons) {
		this.tableId = new Random().nextInt(20);
		this.numberOfPersons = numberOfPersons;
	}

	public void addCommand(Command command){
		List<Command> previousCommands = new ArrayList<Command>();
		if(command.isSameCommand()){
			commands.get(commands.size()-1).copyCommand(command);
		}
		for(Command com: commands){
			if(command.compareCommandTo(com)==1){
				previousCommands.add(com);
			}
		}
		commands.removeAll(previousCommands);
		commands.add(command);
	}
	
	protected int getTableId(){
		return this.tableId;
	}
	
	public String constructOrder(){
		StringBuffer order = new StringBuffer();
		int forCommands = 0;
		int numberOfPersonsForCommand  = 0;
		String mealForCommand = null;
		if(this.isEveryOneOrdered()==0){
		for(Command command: this.commands){
			if(command.isForCommand()){
				forCommands ++;
				numberOfPersonsForCommand = command.numberOfPersonsForCommand();
				mealForCommand = command.mealOfPersonsForCommand();
				order.append(command.addCommandToOrder());
			}
			else order.append(command.addCommandToOrder());
		}
		if(forCommands != numberOfPersonsForCommand){
			order = new StringBuffer();
			order.append("MISSING ").append(numberOfPersonsForCommand - forCommands).append(" for").append(mealForCommand);
			order.append("for ").append(numberOfPersonsForCommand);
			return order.toString();
		}
		else {
			order = order.deleteCharAt(order.lastIndexOf(","));
			return order.substring(1);
		}
		
		}
		else {
			order.append("MISSING "+this.isEveryOneOrdered());
			return order.toString();
		}
	}
	public int isEveryOneOrdered(){

		return this.numberOfPersons-commands.size();

	}
	public int numberOfPersonsWhoOrderedTheSameMeal(){
		int i = 0;
		int timesTheSameMealIsOrdered = 0;
		for(Command command: this.commands){
			if(command.compareCommandTo(commands.get(i))==-1){
				if(command.orderTheSameMeal(command)==1){
					timesTheSameMealIsOrdered++;
				}
			}
			i++;
		}
		return timesTheSameMealIsOrdered;
	}
	public int notEnoughPeopleForADishFor2(Command command){
		int numberFor = command.numberOfPersonsForCommand();
		return this.numberOfPersonsWhoOrderedTheSameMeal() - numberFor;
	}
	
}
