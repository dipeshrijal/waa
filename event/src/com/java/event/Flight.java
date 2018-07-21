package com.java.event;

public class Flight {
    private String fromCity;
    private String toCity;
    private String date;
    private String airline;
    private String price;
    
    public Flight(String fromCity, String toCity, String date, String airline, String price) {
       this.fromCity=fromCity;
       this.toCity=toCity;
       this.date=date;
       this.airline=airline;
       this.price=price;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}

