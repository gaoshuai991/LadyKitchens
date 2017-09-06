package cn.gss.lk.service.back.impl;

import cn.gss.lk.dao.AdminDao;
import cn.gss.lk.dao.impl.AdminDaoImpl;
import cn.gss.lk.pojo.Admin;
import cn.gss.lk.service.back.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao = new AdminDaoImpl();

	@Override
	public Admin login(Admin admin) {
		return dao.login(admin);
	}

	@Override
	public boolean updatePwd(Admin admin) {
		return dao.updatePwd(admin.getId(),admin.getPwd());
	}
}
