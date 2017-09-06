package cn.gss.lk.service.back.impl;

import cn.gss.lk.dao.MenuDao;
import cn.gss.lk.dao.OrderDao;
import cn.gss.lk.dao.OrderDetailsDao;
import cn.gss.lk.dao.UserDao;
import cn.gss.lk.dao.impl.MenuDaoImpl;
import cn.gss.lk.dao.impl.OrderDaoImpl;
import cn.gss.lk.dao.impl.OrderDetailsDaoImpl;
import cn.gss.lk.dao.impl.UserDaoImpl;
import cn.gss.lk.pojo.Order;
import cn.gss.lk.pojo.OrderDetails;
import cn.gss.lk.service.back.OrderInfoService;
import cn.gss.lk.vo.OrderInfo;

import java.sql.Timestamp;
import java.util.*;

public class OrderInfoServiceImpl implements OrderInfoService {
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private MenuDao menuDao = new MenuDaoImpl();

	@Override
	public OrderInfo show(int orderid) {
		Order order = orderDao.get(orderid);
		List<OrderDetails> detailsList = orderDetailsDao.findByOrder(orderid);
		for (Iterator<OrderDetails> iterator = detailsList.iterator(); iterator.hasNext(); ) {
			OrderDetails details = iterator.next();
			details.setMenuname(menuDao.get(details.getMenuid()).getName());
		}
		OrderInfo orderInfo = new OrderInfo(order, detailsList);
		orderInfo.setUsername(userDao.get(order.getUserid()).getName());
		return orderInfo;
	}

	@Override
	public boolean delete(Set<Integer> ids) {
		return orderDao.delete(ids);
	}

	@Override
	public List<OrderInfo> findAllSplit(int currPage, int lineSize, String column, String keyword) {
		return findAllSplitByUser(currPage, lineSize, "");
	}

	@Override
	public List<OrderInfo> findAllSplitByUser(int currPage, int lineSize, String keyword) {
		List<Order> orderList = orderDao.findAllSplitByUser(currPage, lineSize, keyword);
		List<OrderInfo> orderInfoList = new ArrayList<>(orderList.size());
		for (Order order : orderList) {
			OrderInfo orderInfo = new OrderInfo(order);
			orderInfo.setUsername(userDao.get(order.getUserid()).getName());
			orderInfoList.add(orderInfo);
		}
		return orderInfoList;
	}

	@Override
	public List<OrderInfo> findAllSplitByDate(Date begin, Date end, int currPage, int lineSize, String column, String keyword) {
		List<Order> orderList = orderDao.findAllSplitByDate(new Timestamp(begin.getTime()), new Timestamp(end.getTime()), currPage, lineSize, column, keyword);
		List<OrderInfo> orderInfoList = new ArrayList<>(orderList.size());
		for (Order order : orderList) {
			OrderInfo orderInfo = new OrderInfo(order);
			orderInfo.setUsername(userDao.get(order.getUserid()).getName());
			orderInfoList.add(orderInfo);
		}
		return orderInfoList;
	}

	@Override
	public int getAllCount(String column, String keyword) {
		return orderDao.getAllCount(column, keyword);
	}

	@Override
	public int getAllCountByUser(String keyword) {
		return orderDao.getAllCountByUser(keyword);
	}
}
