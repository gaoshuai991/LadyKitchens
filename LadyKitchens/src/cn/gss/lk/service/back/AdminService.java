package cn.gss.lk.service.back;

import cn.gss.lk.pojo.Admin;

public interface AdminService {
	Admin login(Admin admin);
	boolean updatePwd(Admin admin);
}
