package com.java.jsf;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingCartLine implements Serializable {

	private static final long serialVersionUID = 3557855188483310081L;
	private Cd cd;
	private int quantity;
	private BigDecimal amount;

	public ShoppingCartLine(Cd cd) {
		this.cd = cd;
		this.quantity = 1;
		this.amount = cd.getPrice();
	}

	public Cd getCd() {
		return cd;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void incrementQuantityAndAmount() {
		quantity++;
		amount = amount.add(cd.getPrice());
	}

	public boolean decrementQuantityAndAmount() {
		quantity--;
		amount = amount.subtract(cd.getPrice());
		return quantity == 0;
	}
}
