package com.exercices.restaurant2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderFactory {

	public static String buildOrder(Map<String,List<Command>> commands,int numberOfPersons){
		StringBuffer order = new StringBuffer();
		String previousPerson = "";
		int countTimes = 0;
		Map <String,String> mealOrderedForNumberOfPersons = new HashMap<String,String>();
		for(String person: commands.keySet()){
			if(getLast(commands.get(person)).commandMeal.contains(CommandTypes.SAME)){
				order.append(getLast(commands.get(previousPerson)).commandMeal);
				order.append(',');
			}
			else if(getLast(commands.get(person)).commandMeal.contains(CommandTypes.FOR)){
				String [] mealOrders = getLast(commands.get(person)).commandMeal.split(CommandTypes.FOR);
				String numberOfTimes = mealOrders[1];
				String meal = mealOrders[0];
				mealOrderedForNumberOfPersons.put(meal, numberOfTimes+","+(++countTimes));
				order.append(getLast(commands.get(person)).commandMeal);
				order.append(',');
			}
			else {
				order.append(getLast(commands.get(person)).commandMeal);
				order.append(',');
			}
			previousPerson = person;
		}
		order = order.deleteCharAt(order.length()-1);
		order = order.deleteCharAt(0);
		if(commands.size()<numberOfPersons) {
			order = new StringBuffer();	
			order.append("MISSING ");
			order.append(numberOfPersons-commands.size());
		}
		else {
			for(String meal: mealOrderedForNumberOfPersons.keySet()){
			String [] numbers = mealOrderedForNumberOfPersons.get(meal).split(",");
			int numberOfTimes = Integer.parseInt(numbers[0].trim());
			int actualTimes = Integer.parseInt(numbers[1].trim());
			if(numberOfTimes!=actualTimes){
				order = new StringBuffer();	
				order.append("MISSING ");
				order.append(numberOfTimes-actualTimes);
				order.append(" for");
				order.append(meal);
				order.append("for ");
				order.append(numberOfTimes);
			}
		}
		}
		return order.toString();
		}
	
	public static Command getLast(List<Command> commands){
		
		return commands.get(commands.size()-1);
		
	}
	}
