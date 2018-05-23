package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ManagedBean
@SessionScoped
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 5704537400579896146L;

	private List<ShoppingCartLine> lines = new ArrayList<>();
	private BigDecimal totalAmount = new BigDecimal(0);

	public List<ShoppingCartLine> getLines() {
		return lines;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public String addCd(Cd cd) {
		// Find the line for this cd, increment quantity and amount if found
		for (ShoppingCartLine line : lines) {
			if (line.getCd().getCode().equals(cd.getCode())) {
				line.incrementQuantityAndAmount();
				totalAmount = totalAmount.add(cd.getPrice());
				return "/shoppingcart.xhtml";
			}
		}

		// No line for this cd yet, add a new line
		lines.add(new ShoppingCartLine(cd));
		totalAmount = totalAmount.add(cd.getPrice());

		return "shoppingcart.xhtml";
	}

	public void removeCd(Cd cd) {
		Iterator<ShoppingCartLine> it = lines.iterator();
		while (it.hasNext()) {
			ShoppingCartLine line = it.next();

			// If this is the line for this cd, decrement quantity and amount;
			// remove the line if the quantity has become 0
			if (line.getCd().getCode().equals(cd.getCode())) {
				if (line.decrementQuantityAndAmount()) {
					it.remove();
				}
				totalAmount = totalAmount.subtract(cd.getPrice());
			}
		}
	}
}
