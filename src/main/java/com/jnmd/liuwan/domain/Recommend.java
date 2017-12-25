package com.jnmd.liuwan.domain;

public class Recommend {
	private int rid;
	private String title;
	private String description;
	private String introduce;
	private double price;
	private int likes;
	private int comment;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int like) {
		this.likes = like;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public Recommend() {
		super();
	}
	public Recommend(int rid, String title, String description, String introduce, double price, int likes, int comment) {
		super();
		this.rid = rid;
		this.title = title;
		this.description = description;
		this.introduce = introduce;
		this.price = price;
		this.likes = likes;
		this.comment = comment;
	}
}
