package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SessionScoped
@ManagedBean(name = "countryList")
public class CountryList {

	List<Locale> locales;
	String countryStartingWith;

	public CountryList() {
		locales = new ArrayList<>();
		for (String countryCode : Locale.getISOCountries()) {
			Locale locale = new Locale("", countryCode);
			locales.add(locale);
		}
		countryStartingWith = "";
	}

	public List<String> getFilteredCountries() {
		List<String> filteredCountries = new ArrayList<>();
		for (Locale locale : locales) {
			if (locale.getDisplayCountry().toLowerCase().startsWith(countryStartingWith.toLowerCase())) {
				filteredCountries.add(locale.getDisplayCountry());
			}
		}
		return filteredCountries;
	}

	public String getCountryStartingWith() {
		return countryStartingWith;
	}

	public void setCountryStartingWith(String countryStartingWith) {
		this.countryStartingWith = countryStartingWith;
	}
}
