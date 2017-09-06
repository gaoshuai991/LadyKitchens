package cn.gss.lk.dao.impl;

import cn.gss.lk.dao.UserDao;
import cn.gss.lk.pojo.User;
import cn.gss.lk.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public User get(int userid) {
		String sql = "SELECT id,name,pwd,realname,sex,age,card,phone,address,email,code,type FROM users WHERE id=?";
		return DBUtil.getObject(User.class,sql,userid);
	}

	@Override
	public User login(User user) {
		String sql = "SELECT id,name,realname FROM users WHERE name=? AND pwd=?";
//		ResultSet rs = executeQuery(sql, user.getName(), user.getPwd());
//		User res = null;
//		if (rs.next()) {
//			res = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
//		}
		return DBUtil.getObject(User.class, sql, user.getName(), user.getPwd());
	}

	@Override
	public boolean register(User user) {
		String sql = "INSERT INTO users(name,pwd,realname,phone,address) values(?,?,?,?,?)";
		return DBUtil.execute(sql, user.getName(), user.getPwd(), user.getRealname(), user.getPhone(), user.getAddress()) > 0;
	}

	@Override
	public boolean update(User user) {
		String sql = "UPDATE users SET pwd=?,realname=?,sex=?,age=?,card=?,address=?,email=?,code=? WHERE id=?";
		return DBUtil.execute(sql, user.getPwd(), user.getRealname(), user.getSex(), user.getAge(), user.getCard(), user.getAddress(), user.getEmail(), user.getCode(), user.getId()) > 0;
	}

	@Override
	public boolean updatePwd(int userid, String newpwd) {
		String sql = "UPDATE users SET pwd=? WHERE id=?";
		return DBUtil.execute(sql,newpwd,userid) > 0;
	}

	@Override
	public List<User> findAllSplit(int currPage, int lineSize, String column, String keyword) {
		String sql = "SELECT id,name,pwd,realname,sex,age,card,phone,address,email,code,type FROM users WHERE " + column + " LIKE ? LIMIT ?,?";
//		List<User> list = null;
//		ResultSet rs = executeQuery(sql, "%" + keyword + "%", (currPage - 1) * lineSize, lineSize);
//		while (rs.next()) {
//			if (list == null) {
//				list = new ArrayList<>();
//			}
//			User vo = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
//					rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),
//					rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
//			list.add(vo);
//		}
		return DBUtil.getQueryList(User.class, sql, "%" + keyword + "%", (currPage - 1) * lineSize, lineSize);
	}

	@Override
	public int getAllCount(String column, String keyword) {
		String sql = "SELECT COUNT(*) FROM users WHERE "+column+" LIKE ?";
		return DBUtil.<Long>getSingleValue(sql,"%" + keyword + "%").intValue();
	}
}
