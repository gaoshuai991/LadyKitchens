package cn.gss.lk.dao;

import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.Order;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface OrderDao {
	boolean delete(Set<Integer> ids);

	Order get(int orderid);

	List<Order> findAllSplitByUser(int currPage, int lineSize, String keyword);
	List<Order> findAllSplitByDate(Timestamp begin,Timestamp end,int currPage, int lineSize, String column, String keyword);

	int getAllCount(String column, String keyword);

	int getAllCountByUser(String keyword);

	int insert(Order order);
}
