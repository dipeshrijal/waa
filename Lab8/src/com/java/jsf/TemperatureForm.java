package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@RequestScoped
public class TemperatureForm implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date date;
    private Temperature temperature;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String submit() {
        return "temperature";
    }
}
