package com.zl.dafeng.bo.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;

public class User extends BmobObject{

	private String id;
	private String nickname;
	private String passwprd;
	private Integer age;
	private Integer sex;
	private BmobFile icon;
	private Integer phone;
	private Integer isvip;
	private String wechat;
	private Integer qq;
	private Integer praise_num;
	private String star;
	private String adress;
	private String residence;
	private BmobDate regist_time;
	private String signatrue;
	private boolean isloing;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswprd() {
		return passwprd;
	}

	public void setPasswprd(String passwprd) {
		this.passwprd = passwprd;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public BmobFile getIcon() {
		return icon;
	}

	public void setIcon(BmobFile icon) {
		this.icon = icon;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getIsvip() {
		return isvip;
	}

	public void setIsvip(Integer isvip) {
		this.isvip = isvip;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getQq() {
		return qq;
	}

	public void setQq(Integer qq) {
		this.qq = qq;
	}

	public Integer getPraise_num() {
		return praise_num;
	}

	public void setPraise_num(Integer praise_num) {
		this.praise_num = praise_num;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public BmobDate getRegist_time() {
		return regist_time;
	}

	public void setRegist_time(BmobDate regist_time) {
		this.regist_time = regist_time;
	}

	public String getSignatrue() {
		return signatrue;
	}

	public void setSignatrue(String signatrue) {
		this.signatrue = signatrue;
	}

	public boolean isloing() {
		return isloing;
	}

	public void setIsloing(boolean isloing) {
		this.isloing = isloing;
	}
}
