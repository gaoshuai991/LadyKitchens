package cn.gss.lk.service.front.impl;

import cn.gss.lk.dao.MenuDao;
import cn.gss.lk.dao.OrderDao;
import cn.gss.lk.dao.OrderDetailsDao;
import cn.gss.lk.dao.UserDao;
import cn.gss.lk.dao.impl.MenuDaoImpl;
import cn.gss.lk.dao.impl.OrderDaoImpl;
import cn.gss.lk.dao.impl.OrderDetailsDaoImpl;
import cn.gss.lk.dao.impl.UserDaoImpl;
import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.Order;
import cn.gss.lk.pojo.OrderDetails;
import cn.gss.lk.pojo.User;
import cn.gss.lk.service.front.UserServiceFront;
import cn.gss.lk.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class UserServiceFrontImpl implements UserServiceFront {
	private UserDao userDao = new UserDaoImpl();
	private MenuDao menuDao = new MenuDaoImpl();
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public boolean register(User user) {
		return userDao.register(user);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public boolean updatePwd(int userid, String newpwd) {
		return userDao.updatePwd(userid, newpwd);
	}

	@Override
	public User get(int userid) {
		return userDao.get(userid);
	}

	@Override
	public boolean checkOut(int userid, List<Menu> cartList) {
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			DBUtil.beginTransaction(connection);
			double total = 0;
			for (Menu menu : cartList) {
				total += menu.getPrice() * menu.getCount();
			}
			Order order = new Order();
			order.setUserid(userid);
			order.setTotal(total);
			order.setDelivery("1");
			int pk = -1;
			if ((pk = orderDao.insert(order)) != -1) {
				for (Menu menu : cartList) {
					OrderDetails vo = new OrderDetails();
					vo.setOrderid(pk);
					vo.setMenuid(menu.getId());
					vo.setCount(menu.getCount());
					vo.setPrice(menu.getPrice());
					if (!menuDao.updateSum(menu.getId(),-menu.getCount()) || !orderDetailsDao.insert(vo)) {
						DBUtil.rollbackTransaction(connection);
						break;
					}
				}
				DBUtil.commitTransaction(connection);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null)
				DBUtil.rollbackTransaction(connection);
		}
		return false;
	}
}
