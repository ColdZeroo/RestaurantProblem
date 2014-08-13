package com.exercices.restaurant2;

import java.util.ArrayList;
import java.util.List;

public class Tables {

	private List<Table> tables = new ArrayList<>();

	public int addTable(Table table) {

		return table.getTableId();
	}

	public void addCommandToTable(Command command, int tableId) {
		Table table = getTableAyantId(tableId);
		table.addCommandToTable(command);
		tables.add(table);
            
	}

	private Table getTableAyantId(int tableId) {
		for (Table table : tables) {
			if (table.getTableId() == tableId)
				return table;
		}
		return null;
	}
}
