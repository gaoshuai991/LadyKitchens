package cn.gss.lk.service.front.impl;

import cn.gss.lk.dao.MenuDao;
import cn.gss.lk.dao.NoticeDao;
import cn.gss.lk.dao.TypeDao;
import cn.gss.lk.dao.impl.MenuDaoImpl;
import cn.gss.lk.dao.impl.NoticeDaoImpl;
import cn.gss.lk.dao.impl.TypeDaoImpl;
import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.Type;
import cn.gss.lk.service.front.MenuServiceFront;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuServiceFrontImpl implements MenuServiceFront {
	private MenuDao menuDao = new MenuDaoImpl();
	private TypeDao typeDao = new TypeDaoImpl();
	private NoticeDao noticeDao = new NoticeDaoImpl();
	@Override
	public Map<String, Object> findAll() {
		Map<String, Object> map = new HashMap<>();
		map.put("allMenu", menuDao.findAll());
		return map;
	}

	@Override
	public Map<String, Object> findAlByType(int typeid) {
		Map<String, Object> map = new HashMap<>();
		map.put("allMenu", menuDao.findAllByType(typeid));
		return map;
	}

	@Override
	public List<Menu> findHotMenus() {
		return menuDao.findHotMenus();
	}

	@Override
	public Map<String, Object> prepareIndex() {
		Map<String, Object> map = new HashMap<>();
		map.put("allHotMenus", findHotMenus());
		List<Menu> allHotTypedMenus = new ArrayList<>();
		List<Type> allType = typeDao.findAll();
		map.put("allType", typeDao.findAll());
		for(Type type : allType){
			List<Menu> listMenu = menuDao.findHotTypedMenus(type.getId());
			allHotTypedMenus.addAll(listMenu);
		}
		map.put("allHotTypedMenus", allHotTypedMenus);
		map.put("allNewNotice", noticeDao.findNew());
		return map;
	}

	@Override
	public Menu get(int menuid) {
		return menuDao.get(menuid);
	}

	@Override
	public Type getType(int typeid) {
		return typeDao.get(typeid);
	}

	@Override
	public List<Type> findAllType() {
		return typeDao.findAll();
	}
}
