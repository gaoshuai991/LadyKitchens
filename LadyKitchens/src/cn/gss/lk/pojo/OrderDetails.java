package cn.gss.lk.pojo;

public class OrderDetails {
	private int orderid;
	private int menuid;
	private String menuname;
	private int count;
	private double price;

	public OrderDetails() {
	}

	public OrderDetails(int orderid, int menuid, int count, double price) {
		this.orderid = orderid;
		this.menuid = menuid;
		this.count = count;
		this.price = price;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
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
}
