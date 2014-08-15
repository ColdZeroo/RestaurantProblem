package com.exercices.restaurant2;

import com.exercices.restaurant2.Table;

public class Restaurant {
	
	private Tables tables = new Tables();
	static Translator translator;
	static{
		 translator = new Translator() {
			@Override
			public Command translate(String commandName) {
				String[] personCommand = commandName.split(":");
				return new Command(new Person(personCommand[0]),personCommand[1]);
				
			}
		};
	}
	
	
	public int initTable(int i) {
		return tables.addTable(new Table(i));
	}
	
	public void customerSays(int tableId, String customerCommand) {
		tables.addCommandToTable(translator.translate(customerCommand), tableId);
	}
	
	public String createOrder(int tableId) {
		String order = tables.creatOrder(tableId);
		return order;
	}
}
