package cn.gss.lk.dao;

import cn.gss.lk.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	User get(int userid);

	User login(User user);

	boolean register(User user);

	boolean update(User user);

	boolean updatePwd(int userid,String newpwd);

	List<User> findAllSplit(int currPage, int lineSize,String column, String keyword);

	int getAllCount(String column, String keyword);
}
