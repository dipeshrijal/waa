package com.java.jsf;

import java.io.Serializable;

public class Airline implements Serializable {

	private static final long serialVersionUID = 1L;
	private String from;
    private String to;
    private String date;
    private String name;
    private String price;

    public Airline() {
    }

    public Airline(String from, String to, String date, String name, String price) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.name = name;
        this.price = price;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
