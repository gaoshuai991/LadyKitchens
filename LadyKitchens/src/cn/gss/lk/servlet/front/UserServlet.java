package cn.gss.lk.servlet.front;

import cn.gss.lk.pojo.User;
import cn.gss.lk.service.front.UserServiceFront;
import cn.gss.lk.service.front.impl.UserServiceFrontImpl;
import cn.gss.lk.util.DispatcherServlet;
import cn.gss.lk.util.MD5Code;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "UserServletFront",urlPatterns = "/pages/front/UserServlet/*")
public class UserServlet extends DispatcherServlet {
	private final String registerValidate = "user.name|user.pwd|user.realname|user.phone|user.address";
	private final String updateValidate = "user.realname|user.sex|user.age|user.card|user.phone|user.email|user.address";
	private UserServiceFront userServiceFront = new UserServiceFrontImpl();
	private User user = new User();

	public User getUser() {
		return user;
	}

	public String updatePwd(){
		user.setPwd(new MD5Code().getMD5ofStr(user.getPwd()));
		if(userServiceFront.login(user) == null){
			setMsgAndUrl("oldpwd.error.msg","front.index.servlet");
		}else {
			String newpwd = request.getParameter("newpwd");
			if (userServiceFront.updatePwd(user.getId(), new MD5Code().getMD5ofStr(newpwd))) {
				request.getSession().removeAttribute("user");
				setMsgAndUrl("pwd.update.msg","front.index.servlet");
			}else{
				setMsgAndUrl("error.msg","front.index.servlet");
			}
		}
		return "forward.page";

	}

	public String updatePre(){
		request.setAttribute("user", userServiceFront.get(((User) request.getSession().getAttribute("user")).getId()));
		return "user.update.page";
	}

	public String update(){
		if(userServiceFront.update(user)){
			setMsgAndUrl("vo.update.success","front.index.servlet");
		}else{
			setMsgAndUrl("vo.update.failure","user.update.servlet");
		}
		return "forward.page";
	}

	public String register(){
		user.setPwd(new MD5Code().getMD5ofStr(user.getPwd()));
		if(userServiceFront.register(user)){
			setMsgAndUrl("user.register.success","front.login.page");
		}else{
			setMsgAndUrl("user.register.failure","front.register.page");
		}
		return "forward.page";
	}

	public String login(){
		user.setPwd(new MD5Code().getMD5ofStr(user.getPwd()));
		User res = userServiceFront.login(user);
		if(res == null){
			setMsgAndUrl("vo.login.failure","front.login.page");
		}else{
			request.getSession().setAttribute("user",res);
			setMsgAndUrl("vo.login.success","front.index.servlet");
		}
		return "forward.page";
	}

	public String logout(){
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("cartRecord");
		request.getSession().removeAttribute("cartRecordJson");
		setMsgAndUrl("vo.logout.success","front.index.servlet");
		return "forward.page";
	}




	@Override
	public String getSubTitle() {
		return "用户";
	}

	@Override
	public String getSubUploadDir() {
		return "";
	}

	@Override
	public String getDefaultColumn() {
		return null;
	}

	@Override
	public String getColumnData() {
		return null;
	}
}
