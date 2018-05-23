package com.java.jsf;

import java.util.List;

public interface CdService {

	List<Cd> getPopularCds();

	Cd getCd(String code);

}
