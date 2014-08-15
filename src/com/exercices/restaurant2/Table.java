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
		if(command.isSameCommand()){
			commands.get(commands.size()-1).copyCommand(command);
		}
		this.commands.add(command);
	}
	
	protected int getTableId(){
		return this.tableId;
	}
	public String constructOrder(){
		StringBuffer order = new StringBuffer();
		for(Command command: this.commands){
				order.append(command.addCommandToOrder());
		}
		order = order.deleteCharAt(order.lastIndexOf(","));
		return order.substring(1);
	}
	
}
