package cn.gss.lk.pojo;

import java.io.Serializable;

public class Menu implements Serializable {
	private int id;
	private String name;
	private int typeid;
	private String burden;
	private String brief;
	private int sum;
	private int count; // 记录购物车购买数量
	private double price;
	private String imgpath;

	public Menu() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getBurden() {
		return burden;
	}

	public void setBurden(String burden) {
		this.burden = burden;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public Menu(int id, String name, int typeid, String burden, String brief, int sum, double price, String imgpath) {

		this.id = id;
		this.name = name;
		this.typeid = typeid;
		this.burden = burden;
		this.brief = brief;
		this.sum = sum;
		this.price = price;
		this.imgpath = imgpath;
	}

	public Menu(String name, int typeid, String burden, String brief, int sum, double price, String imgpath) {

		this.name = name;
		this.typeid = typeid;
		this.burden = burden;
		this.brief = brief;
		this.sum = sum;
		this.price = price;
		this.imgpath = imgpath;
	}
}
