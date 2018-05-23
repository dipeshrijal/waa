package com.java.jsf;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cd implements Serializable {

	private static final long serialVersionUID = -4647933729239896020L;

	private final String code;
	private final String name;
	private final BigDecimal price;

	public Cd(String code, String name, String price) {
		this.code = code;
		this.name = name;
		this.price = new BigDecimal(price);
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
