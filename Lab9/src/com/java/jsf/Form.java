package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "form")
@SessionScoped
public class Form implements Serializable {

	private static final long serialVersionUID = 1L;
	private String selectedAirline;
	private List<Airline> airlines;

	public Form() {
		selectedAirline = "";
		airlines = new ArrayList<Airline>() {
			
			private static final long serialVersionUID = 1L;

			{
				add(new Airline("Amsterdam", "New York", "12/11/06", "KLM", "790.80"));
				add(new Airline("Amsterdam", "New York", "12/11/06", "NorthWest", "795.55"));
				add(new Airline("Amsterdam", "New York", "12/11/06", "KLM", "820.00"));
				add(new Airline("Amsterdam", "New York", "12/11/06", "United Airlines", "825.50"));
				add(new Airline("Amsterdam", "New York", "12/11/06", "NorthWest", "875.00"));
				add(new Airline("Amsterdam", "New York", "12/11/06", "KLM", "989.00"));
				add(new Airline("Amsterdam", "New York", "12/11/06", "United Airlines", "1050.00"));
			}
		};
	}

	public String getSelectedAirline() {
		return selectedAirline;
	}

	public void airlineChanged(ValueChangeEvent event) {
		selectedAirline = event.getNewValue() == null ? "" : String.valueOf(event.getNewValue());
	}

	public List<Airline> getFilteredAirlines() {
		if (selectedAirline.equals("")) {
			return airlines;
		}
		List<Airline> filteredAirlines = new ArrayList<>();
		airlines.forEach(airline -> {
			if (airline.getName().toLowerCase().equals(selectedAirline)) {
				filteredAirlines.add(airline);
			}
		});
		return filteredAirlines;
	}
}
