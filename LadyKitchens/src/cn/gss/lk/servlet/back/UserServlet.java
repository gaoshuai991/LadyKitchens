package cn.gss.lk.servlet.back;

import cn.gss.lk.pojo.User;
import cn.gss.lk.service.back.UserService;
import cn.gss.lk.service.back.impl.UserServiceImpl;
import cn.gss.lk.util.DispatcherServlet;
import cn.gss.lk.util.MD5Code;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UserServlet",urlPatterns = "/pages/back/user/UserServlet/*")
public class UserServlet extends DispatcherServlet {
	private UserService userService = new UserServiceImpl();

	private User user = new User();

	public User getUser() {
		return user;
	}

	public String list(){
		handleSplit();
		request.setAttribute("allUser",userService.findAllSplit(getCurrentPage(),getLineSize(),getColumn(),getKeyword()));
		request.setAttribute("allRecorders",userService.getAllCount(getColumn(),getKeyword()));
		request.setAttribute("url",getPath("user.list.servlet"));
		return "user.list.page";
	}

	public void updatePwd(){
//		System.out.println("******** pwd = " + user.getPwd());
		print(userService.updatePwd(user.getId(),new MD5Code().getMD5ofStr(user.getPwd())));
	}



	@Override
	public String getSubTitle() {
		return null;
	}

	@Override
	public String getSubUploadDir() {
		return null;
	}

	@Override
	public String getDefaultColumn() {
		return "name";
	}

	@Override
	public String getColumnData() {
		return "用户名:name|真实姓名:realname|性别:sex|电话:phone|地址:address|邮箱:email";
	}
}
