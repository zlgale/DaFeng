package com.zl.dafeng.bo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeByte(this.isLogin ? (byte) 1 : (byte) 0);
		dest.writeString(this.username);
		dest.writeString(this.password);
	}

	public User() {
	}

	protected User(Parcel in) {
		this.isLogin = in.readByte() != 0;
		this.username = in.readString();
		this.password = in.readString();
	}

	public static final Creator<User> CREATOR = new Creator<User>() {
		@Override
		public User createFromParcel(Parcel source) {
			return new User(source);
		}

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
	};
}
