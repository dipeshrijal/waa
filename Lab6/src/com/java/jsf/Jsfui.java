package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class Jsfui implements Serializable {

	private static final long serialVersionUID = 1L;
	private SelectItem[] toItems = { new SelectItem("New York"), new SelectItem("Boston"), new SelectItem("Chicago") };
	private String from;
	private String to;
	private String departureDate;
	private String returnDate;
	private String tripType;
	private String options[];

	public Jsfui() {
		tripType = "Round Trip";
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public SelectItem[] getToItems() {
		return toItems;
	}

	public void setToItems(SelectItem[] toItems) {
		this.toItems = toItems;
	}

	public void printToConsole() {
		System.out.println("From: " + from);
		System.out.println("To: " + to);
		System.out.println("Departure Date: " + departureDate);
		System.out.println("Return Date: " + returnDate);
		System.out.println("Trip Type: " + tripType);
		System.out.println("Options: " + Arrays.toString(options));
	}

}
