package cn.gss.lk.vo;

import cn.gss.lk.pojo.Order;
import cn.gss.lk.pojo.OrderDetails;

import java.util.Date;
import java.util.List;

public class OrderInfo {
	private int id;
	private List<OrderDetails> orderDetailsList;
	private String username;
	private double total;
	private Date times;
	private String delivery;
	public OrderInfo(){

	}
	public OrderInfo(Order order){
		this.id = order.getId();
		this.total = order.getTotal();
		this.times = order.getTimes();
		this.delivery = order.getDelivery();
	}
	public OrderInfo(Order order,List<OrderDetails> orderDetailsList){
		this.id = order.getId();
		this.orderDetailsList = orderDetailsList;
		this.total = order.getTotal();
		this.times = order.getTimes();
		this.delivery = order.getDelivery();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderDetails> getOrderDetailsList() {
		return orderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
