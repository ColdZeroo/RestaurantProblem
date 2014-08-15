package com.exercices.restaurant2;

import java.util.ArrayList;
import java.util.List;

public class Tables {

	private List<Table> tables = new ArrayList<>();

	public int addTable(Table table) {
		tables.add(table);
		return table.getTableId();
	}

	public void addCommandToTable(Command command, int tableId) {
		Table table = getTableAyantId(tableId);
		table.addCommand(command);
	}

	private Table getTableAyantId(int tableId) {
		for (Table table : tables) {
			if (table.getTableId() == tableId)
				return table;
		}
		return null;
	}

	public String creatOrder(int tableId) {
		Table table = this.getTableAyantId(tableId);
		return table.constructOrder();
	}
}
