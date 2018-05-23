package com.java.jsf;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class PopularCds {

	private List<Cd> cds;

	public PopularCds() {
		cds = new CdServiceImpl().getPopularCds();
	}

	public List<Cd> getCds() {
		return cds;
	}

}
