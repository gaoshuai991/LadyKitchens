package cn.gss.lk.dao;

import cn.gss.lk.pojo.Type;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TypeDao {
	Type get(int typeid);

	boolean insert(Type type);

	boolean update(Type type);

	boolean delete(Set<Integer> ids);

	List<Type> findAll();
}
