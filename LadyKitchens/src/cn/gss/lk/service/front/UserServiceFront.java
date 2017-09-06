package cn.gss.lk.service.front;

import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.User;

import java.util.List;

public interface UserServiceFront {
	User login(User user);
	boolean register(User user);
	boolean update(User user);

	boolean updatePwd(int userid, String newpwd);
	User get(int userid);
	boolean checkOut(int userid, List<Menu> cartList);
}
