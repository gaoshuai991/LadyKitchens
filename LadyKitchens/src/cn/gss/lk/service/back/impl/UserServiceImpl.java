package cn.gss.lk.service.back.impl;

import cn.gss.lk.dao.UserDao;
import cn.gss.lk.dao.impl.UserDaoImpl;
import cn.gss.lk.pojo.User;
import cn.gss.lk.service.back.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User get(int userid) {
		return userDao.get(userid);
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public boolean updatePwd(int userid, String newpwd) {
		return userDao.updatePwd(userid, newpwd);
	}

	@Override
	public List<User> findAllSplit(int currPage, int lineSize, String column, String keyword) {
		return userDao.findAllSplit(currPage, lineSize, column, keyword);
	}

	@Override
	public int getAllCount(String column, String keyword) {
		return userDao.getAllCount(column, keyword);
	}
}
