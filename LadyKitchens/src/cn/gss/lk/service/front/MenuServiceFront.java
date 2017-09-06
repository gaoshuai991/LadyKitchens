package cn.gss.lk.service.front;

import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.Type;

import java.util.List;
import java.util.Map;

public interface MenuServiceFront {
	Map<String, Object> findAll();

	Map<String, Object> findAlByType(int typeid);

	List<Menu> findHotMenus();

	Map<String, Object> prepareIndex();

	Menu get(int menuid);

	Type getType(int typeid);

	List<Type> findAllType();
}
