package cn.gss.lk.service.back.impl;

import cn.gss.lk.dao.TypeDao;
import cn.gss.lk.dao.impl.TypeDaoImpl;
import cn.gss.lk.pojo.Type;
import cn.gss.lk.service.back.TypeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class TypeServiceImpl implements TypeService {
	private TypeDao typeDao = new TypeDaoImpl();

	@Override
	public Type get(int typeid) {
		return typeDao.get(typeid);
	}

	@Override
	public boolean insert(Type type) {
		return typeDao.insert(type);
	}

	@Override
	public boolean update(Type type) {
		return typeDao.update(type);
	}

	@Override
	public boolean delete(Set<Integer> ids) {
		return typeDao.delete(ids);
	}

	@Override
	public List<Type> findAll() {
		return typeDao.findAll();
	}
}
