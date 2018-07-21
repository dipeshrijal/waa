package com.java.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@RequestScoped
public class Airline {
	private String selectedAirline = "All";
	private List<Flight> flightListcomplete = new ArrayList<>();
	private List<Flight> flightListshow = new ArrayList<>();

	public Airline() {
		Flight f1 = new Flight("Amsterdam", "New York", "12/11/06", "KLM", "790.80");
		flightListcomplete.add(f1);
		Flight f2 = new Flight("Amsterdam", "New York", "12/11/06", "NorthWest", "795.55");
		flightListcomplete.add(f2);
		Flight f3 = new Flight("Amsterdam", "New York", "12/11/06", "KLM", "820.00");
		flightListcomplete.add(f3);
		Flight f4 = new Flight("Amsterdam", "New York", "12/11/06", "United Airlines", "825.50");
		flightListcomplete.add(f4);
		Flight f5 = new Flight("Amsterdam", "New York", "12/11/06", "NorthWest", "875.00");
		flightListcomplete.add(f5);
		Flight f6 = new Flight("Amsterdam", "New York", "12/11/06", "KLM", "989.00");
		flightListcomplete.add(f6);
		Flight f7 = new Flight("Amsterdam", "New York", "12/11/06", "United Airlines", "1050.00");
		flightListcomplete.add(f7);

		// copy flights
		Iterator<Flight> iterator = flightListcomplete.iterator();
		while (iterator.hasNext()) {
			Flight flight = (Flight) iterator.next();
			flightListshow.add(flight);
		}
	}

	public void setSelectedAirline(String selectedCity) {
		this.selectedAirline = selectedCity;
	}

	public String getSelectedAirline() {
		return selectedAirline;
	}

	public void setFlightListcomplete(List<Flight> flightList) {
		this.flightListcomplete = flightList;
	}

	public List<Flight> getFlightListcomplete() {
		return flightListcomplete;
	}

	public void changeAirline(ValueChangeEvent valueChangeEvent) {
		String newAirline = (String) valueChangeEvent.getNewValue();
		flightListshow.clear();
		Iterator<Flight> iterator = flightListcomplete.iterator();
		while (iterator.hasNext()) {
			Flight flight = (Flight) iterator.next();
			if (newAirline.equals("All")) {
				flightListshow.add(flight);
			} else {
				if (flight.getAirline().equals(newAirline)) {
					flightListshow.add(flight);
				}
			}
		}
	}

	public void setFlightListshow(List<Flight> flightListshow) {
		this.flightListshow = flightListshow;
	}

	public List<Flight> getFlightListshow() {
		return flightListshow;
	}

}
