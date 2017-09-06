package cn.gss.lk.dao.impl;

import cn.gss.lk.dao.OrderDao;
import cn.gss.lk.pojo.Order;
import cn.gss.lk.util.DBUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class OrderDaoImpl extends AbstractDao implements OrderDao {

	@Override
	public boolean delete(Set<Integer> ids) {
		return deleteHandler("orders", "id", ids);
	}

	@Override
	public Order get(int orderid) {
		String sql = "SELECT id,userid,total,times,delivery FROM orders WHERE id=?";
		return DBUtil.getObject(Order.class, sql, orderid);
	}

	@Override
	public List<Order> findAllSplitByUser(int currPage, int lineSize, String keyword) {
		String sql = "SELECT id,userid,total,times,delivery FROM orders WHERE userid IN (SELECT id FROM users WHERE name LIKE ?) ORDER BY times DESC LIMIT ?,?";
		return DBUtil.getQueryList(Order.class, sql, "%" + keyword + "%", (currPage - 1) * lineSize, lineSize);
	}

	@Override
	public List<Order> findAllSplitByDate(Timestamp begin, Timestamp end, int currPage, int lineSize, String column, String keyword) {
		String sql = "SELECT id,userid,total,times,delivery FROM orders WHERE times BETWEEN ? AND ? AND " + column + " LIKE ? LIMIT ?,?";
		return DBUtil.getQueryList(Order.class, sql, begin, end, "%" + keyword + "%", (currPage - 1) * lineSize, lineSize);
	}

	@Override
	public int getAllCount(String column, String keyword) {
		String sql = "SELECT COUNT(*) FROM orders WHERE " + column + " LIKE ?";
		return DBUtil.<Long>getSingleValue(sql, "%" + keyword + "%").intValue();
	}

	@Override
	public int getAllCountByUser(String keyword) {
		String sql = "SELECT COUNT(*) FROM orders WHERE userid IN(SELECT id FROM users WHERE name LIKE ?)";
		return DBUtil.<Long>getSingleValue(sql, "%" + keyword + "%").intValue();
	}

	@Override
	public int insert(Order order) {
		String sql = "INSERT INTO orders(userid,total,times,delivery) VALUES(?,?,?,?)";
		Object res = DBUtil.getPrimaryKey(sql, order.getUserid(), order.getTotal(), new Timestamp(System.currentTimeMillis()), order.getDelivery());
		return res == null ? -1 : ((Long) res).intValue();
	}
}
