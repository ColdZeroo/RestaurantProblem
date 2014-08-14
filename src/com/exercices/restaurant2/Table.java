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

	public void addCommandToTable(Command command){
		this.commands.add(command);
	}
	
	protected int getTableId(){
		return this.tableId;
	}
	public String test(){
		StringBuffer order = new StringBuffer();
		for(Command command: this.commands){
			if(command.isSameCommand()){
				
			}
			else if(command.isForCommand()){
				
			}
			else{
				order.append(command.addCommandToOrder());
				order.substring(order.lastIndexOf(","));
			}
			
		}
		return order.toString();
	}
}
