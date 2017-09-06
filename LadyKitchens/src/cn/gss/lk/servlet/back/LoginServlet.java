package cn.gss.lk.servlet.back;

import cn.gss.lk.pojo.Admin;
import cn.gss.lk.service.back.AdminService;
import cn.gss.lk.service.back.impl.AdminServiceImpl;
import cn.gss.lk.util.DispatcherServlet;
import cn.gss.lk.util.MD5Code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServletBack",urlPatterns = "/pages/LoginServlet/*")
public class LoginServlet extends DispatcherServlet {
	private final String loginValidate = "admin.name|admin.pwd";
	private AdminService adminService = new AdminServiceImpl();

	private Admin admin = new Admin();

	public Admin getAdmin() {
		return admin;
	}

	public String login(){
		admin.setPwd(new MD5Code().getMD5ofStr(admin.getPwd()));
		Admin res = adminService.login(admin);
		if (res == null) {
			setMsgAndUrl("vo.login.failure","back.login.page");
		}else{
			request.getSession().setAttribute("admin",res);
			setMsgAndUrl("vo.login.success","back.index.page");
		}
		return "forward.page";
	}

	public String logout(){
		request.getSession().invalidate();
		setMsgAndUrl("vo.logout.success","back.login.page");
		return "forward.page";
	}

	@Override
	public String getSubTitle() {
		return "管理员";
	}

	@Override
	public String getSubUploadDir() {
		return null;
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
