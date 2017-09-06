package cn.gss.lk.pojo;

import java.util.Date;

public class Order {
	private int id;
	private int userid;
	private double total;
	private Date times;
	private String delivery;
	public Order(){

	}

	public Order(int id, int userid, double total, Date times, String delivery) {
		this.id = id;
		this.userid = userid;
		this.total = total;
		this.times = times;
		this.delivery = delivery;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
}
