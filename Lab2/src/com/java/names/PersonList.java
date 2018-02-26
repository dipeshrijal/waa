package com.java.names;

import java.util.ArrayList;
import java.util.List;

public class PersonList {

	private List<Person> personList;

	public PersonList() {
		personList = new ArrayList<>();
	}

	public void addPerson(Person person) {

		boolean exists = false;

		for (Person p : personList) {
			if (p.getKey().equals(person.getKey())) {
				exists = true;
				break;
			}
		}

		if (!exists) {
			personList.add(person);
		}

	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void removePerson(String key) {
		for (Person person : personList) {
			if (key.equals(person.getKey())) {
				personList.remove(person);
				break;
			}
		}
	}

}
