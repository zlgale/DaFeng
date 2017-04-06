package com.zl.dafeng.bo.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Posts extends BmobObject{

	private String posts_id;
	private String source_id;
	private String object_id;
	private Integer posts_content;
	private Integer posts_time;
	private BmobFile posts_praisenum;
	private Integer posts_tier;

	public String getPosts_id() {
		return posts_id;
	}

	public void setPosts_id(String posts_id) {
		this.posts_id = posts_id;
	}

	public String getSource_id() {
		return source_id;
	}

	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}

	public String getObject_id() {
		return object_id;
	}

	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}

	public Integer getPosts_content() {
		return posts_content;
	}

	public void setPosts_content(Integer posts_content) {
		this.posts_content = posts_content;
	}

	public Integer getPosts_time() {
		return posts_time;
	}

	public void setPosts_time(Integer posts_time) {
		this.posts_time = posts_time;
	}

	public BmobFile getPosts_praisenum() {
		return posts_praisenum;
	}

	public void setPosts_praisenum(BmobFile posts_praisenum) {
		this.posts_praisenum = posts_praisenum;
	}

	public Integer getPosts_tier() {
		return posts_tier;
	}

	public void setPosts_tier(Integer posts_tier) {
		this.posts_tier = posts_tier;
	}
}
