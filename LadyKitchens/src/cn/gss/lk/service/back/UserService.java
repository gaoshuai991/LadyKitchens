package cn.gss.lk.service.back;

import cn.gss.lk.pojo.User;

import java.util.List;

public interface UserService {
	User get(int userid);

	User login(User user);

	boolean updatePwd(int userid, String newpwd);

	List<User> findAllSplit(int currPage, int lineSize, String column, String keyword);

	int getAllCount(String column, String keyword);
}
