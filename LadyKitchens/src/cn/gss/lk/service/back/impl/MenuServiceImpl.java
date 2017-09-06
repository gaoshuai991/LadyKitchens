package cn.gss.lk.service.back.impl;

import cn.gss.lk.dao.MenuDao;
import cn.gss.lk.dao.TypeDao;
import cn.gss.lk.dao.impl.MenuDaoImpl;
import cn.gss.lk.dao.impl.TypeDaoImpl;
import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.Type;
import cn.gss.lk.service.back.MenuService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MenuServiceImpl implements MenuService {
	private MenuDao menuDao = new MenuDaoImpl();
	private TypeDao typeDao = new TypeDaoImpl();

	@Override
	public Menu get(int menuid) {
		return menuDao.get(menuid);
	}

	@Override
	public Map<String, Object> list(int currPage, int lineSize, String column, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("allMenu", menuDao.findAllSplit(currPage, lineSize, column, keyword));
		map.put("allRecorders", menuDao.getAllCount(column, keyword));
		Map<Long, String> typeMap = new HashMap<>();
		for(Type type : typeDao.findAll()){
			typeMap.put(Long.valueOf(type.getId()), type.getName());
		}
		map.put("typeMap", typeMap);
		return map;
	}

	@Override
	public Map<String, Object> insertPre() {
		Map<String, Object> map = new HashMap<>();
		map.put("allType", typeDao.findAll());
		return map;
	}

	@Override
	public boolean insert(Menu menu) {
		return menuDao.insert(menu);
	}

	@Override
	public Map<String, Object> updatePre(int menuid) {
		Map<String, Object> map = new HashMap<>();
		map.put("allType", typeDao.findAll());
		map.put("menu", menuDao.get(menuid));
		return map;
	}

	@Override
	public boolean update(Menu menu) {
		return menuDao.update(menu);
	}

	@Override
	public boolean delete(Set<Integer> ids) {
		return menuDao.delete(ids);
	}
}
