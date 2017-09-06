package cn.gss.lk.dao.impl;

import cn.gss.lk.dao.TypeDao;
import cn.gss.lk.pojo.Type;
import cn.gss.lk.util.DBUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TypeDaoImpl extends AbstractDao implements TypeDao {
	@Override
	public Type get(int typeid) {
		String sql = "SELECT id,name FROM types WHERE id=?";
		return DBUtil.getObject(Type.class,sql,typeid);
	}

	@Override
	public boolean insert(Type type) {
		String sql = "INSERT INTO types(name) VALUES(?)";
		return DBUtil.execute(sql,type.getName()) > 0;
	}

	@Override
	public boolean update(Type type) {
		String sql = "UPDATE types SET name=? WHERE id=?";
		return DBUtil.execute(sql,type.getName(),type.getId()) > 0;
	}

	@Override
	public boolean delete(Set<Integer> ids) {
		return deleteHandler("types","id",ids);
	}

	@Override
	public List<Type> findAll() {
		String sql = "SELECT id,name FROM types";
		return DBUtil.getQueryList(Type.class, sql);
	}
}
