package cn.gss.lk.dao;

import cn.gss.lk.pojo.Admin;

import java.sql.SQLException;

public interface AdminDao {
	Admin login(Admin admin);

	boolean updatePwd(int adminid,String newpwd);
}
