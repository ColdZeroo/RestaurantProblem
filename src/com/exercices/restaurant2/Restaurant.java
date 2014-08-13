package com.exercices.restaurant2;

import java.util.ArrayList;
import java.util.List;

import com.exercices.restaurant2.Table;

public class Restaurant {
	private List<Table> tables = new ArrayList<>();

	public int initTable(int i) {
		Table table = new Table(i);
		tables.add(table);
		return table.tableId;
	}
	
	public void customerSays(int tableId, String customerCommand) {
		List<Command> customerCommands = new ArrayList<Command>();
		String[] personCommand = customerCommand.split(":");
		Command command = new Command(personCommand[1]);
		customerCommands.add(command);
		if(tables.get(0).commands.containsKey(personCommand[0])){
			tables.get(0).commands.get(personCommand[0]).add(command);
		}
		else tables.get(0).commands.put(personCommand[0],customerCommands);
	}
	
	public String createOrder(int tableId) {
		String order = OrderFactory.buildOrder(tables.get(0).commands,tables.get(0).numberOfPersons);
		return order;
	}
}
