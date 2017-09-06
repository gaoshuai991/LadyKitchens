package cn.gss.lk.service.back;

import cn.gss.lk.pojo.Type;

import java.util.List;
import java.util.Set;

public interface TypeService {
	Type get(int typeid);

	boolean insert(Type type);

	boolean update(Type type);

	boolean delete(Set<Integer> ids);

	List<Type> findAll();
}
