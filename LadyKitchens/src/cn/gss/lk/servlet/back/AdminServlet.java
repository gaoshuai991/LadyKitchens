package cn.gss.lk.servlet.back;

import cn.gss.lk.pojo.Admin;
import cn.gss.lk.service.back.AdminService;
import cn.gss.lk.service.back.impl.AdminServiceImpl;
import cn.gss.lk.util.DispatcherServlet;
import cn.gss.lk.util.MD5Code;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AdminServlet", urlPatterns = "/pages/back/admin/AdminServlet/*")
public class AdminServlet extends DispatcherServlet {
	private final String updatePwdValidate = "admin.pwd";
	private AdminService adminService = new AdminServiceImpl();

	private Admin admin = new Admin();

	public Admin getAdmin() {
		return admin;
	}

	public void updatePwd() {
		admin.setId(((Admin) request.getSession().getAttribute("admin")).getId());
		admin.setPwd(new MD5Code().getMD5ofStr(admin.getPwd()));
		if (adminService.updatePwd(admin)) {
			print("true");
			request.getSession().removeAttribute("admin");
		} else
			print("false");
	}

	public void checkOldPwd() {
		String oldpwd = request.getParameter("oldPwd");
		print(((Admin) request.getSession().getAttribute("admin")).getPwd().equals(new MD5Code().getMD5ofStr(oldpwd)));
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
		return null;
	}

	@Override
	public String getColumnData() {
		return null;
	}
}
