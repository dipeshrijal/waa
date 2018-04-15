package com.java.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	private String name;

	public User() {
		name = "Frank Brown";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String authenticate() {
		if (this.userId.equals("kl01") && this.password.equals("yoyo")) {
			return "success";
		} else {
			return "error";
		}
	}
}
