package com.java.jsf;

import java.util.*;

public class CdServiceImpl implements CdService {

	private final Map<String, Cd> cds;
	private final List<Cd> popularCds;

	public CdServiceImpl() {
		Map<String, Cd> map = new HashMap<>();
		map.put("A32581", new Cd("A32581", "The winner takes it all", "12.95"));
		map.put("A33278", new Cd("A33278", "Yellow submarine", "11.35"));

		cds = Collections.unmodifiableMap(map);
		popularCds = Collections.unmodifiableList(new ArrayList<>(cds.values()));
	}

	@Override
	public List<Cd> getPopularCds() {
		return popularCds;
	}

	@Override
	public Cd getCd(String code) {
		return cds.get(code);
	}
}
