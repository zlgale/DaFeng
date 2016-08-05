package com.zl.dafeng.model.bean;

import java.io.Serializable;

public class User implements Serializable {

	public boolean isLogin = true;
	public String username = "";
	public String password = "";

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean login) {
		isLogin = login;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
