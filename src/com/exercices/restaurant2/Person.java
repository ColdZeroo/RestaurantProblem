package com.exercices.restaurant2;

public class Person {

	private final String name;
	
	public Person(String name){
		this.name=name;
	}
	
	public boolean equals(Person person){
		if(this.name.equalsIgnoreCase(person.name))
			return true;
		else return false;
	}
}
