package cn.gss.lk.dao.impl;

import cn.gss.lk.dao.AdminDao;
import cn.gss.lk.pojo.Admin;
import cn.gss.lk.util.DBUtil;

import java.sql.SQLException;

public class AdminDaoImpl extends AbstractDao implements AdminDao {
	@Override
	public Admin login(Admin admin) {
		String sql = "SELECT id,name,pwd,authority FROM admin WHERE name=? AND pwd=?";
		return DBUtil.getObject(Admin.class, sql, admin.getName(), admin.getPwd());
	}

	@Override
	public boolean updatePwd(int adminid, String newpwd) {
		String sql = "UPDATE admin SET pwd=? WHERE id=?";
		return DBUtil.execute(sql,newpwd,adminid) > 0;
	}
}
