package cn.gss.lk.dao;

import cn.gss.lk.pojo.OrderDetails;

import java.util.List;

public interface OrderDetailsDao {
	boolean insert(OrderDetails vo);
	List<OrderDetails> findByOrder(int orderid);
}
