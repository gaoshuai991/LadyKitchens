package cn.gss.lk.dao.impl;

import cn.gss.lk.dao.OrderDetailsDao;
import cn.gss.lk.pojo.OrderDetails;
import cn.gss.lk.util.DBUtil;

import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
	@Override
	public boolean insert(OrderDetails vo) {
		String sql = "INSERT INTO orders_details(orderid,menuid,count,price) VALUES(?,?,?,?)";
		return DBUtil.execute(sql,vo.getOrderid(), vo.getMenuid(), vo.getCount(), vo.getPrice()) > 0;
	}

	@Override
	public List<OrderDetails> findByOrder(int orderid) {
		String sql = "SELECT orderid,menuid,count,price FROM orders_details WHERE orderid=?";
		return DBUtil.getQueryList(OrderDetails.class,sql,orderid);
	}
}
