package cn.gss.lk.dao;

import cn.gss.lk.pojo.Menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface MenuDao {
	boolean insert(Menu menu);

	boolean update(Menu menu);

	boolean updateSum(int menuid, int change);

	boolean delete(Set<Integer> ids);

	Menu get(int menuid);

	List<Menu> findAllSplit(int currPage, int lineSize, String column, String keyword);

	List<Menu> findAll();

	List<Menu> findAllByType(int typeid);

	int getAllCount(String column, String keyword);

	List<Menu> findHotMenus();

	List<Menu> findHotTypedMenus(int typeid);
}
