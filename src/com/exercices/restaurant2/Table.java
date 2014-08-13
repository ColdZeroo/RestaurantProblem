package com.exercices.restaurant2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Table {

	final int tableId;
	final int numberOfPersons;
	private final Map<String,List<Command>> commands = new LinkedHashMap<String,List<Command>>();

	
	public Table(int numberOfPersons) {
		this.tableId = new Random().nextInt(20);
		this.numberOfPersons = numberOfPersons;
	}

	
	
}
