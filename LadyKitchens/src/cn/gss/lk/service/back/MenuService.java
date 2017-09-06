package cn.gss.lk.service.back;

import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.Type;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MenuService {
	Menu get(int menuid);

	Map<String,Object> list(int currPage,int lineSize,String column,String keyword);

	Map<String,Object> insertPre();

	boolean insert(Menu menu);

	Map<String,Object> updatePre(int menuid);

	boolean update(Menu menu);

	boolean delete(Set<Integer> ids);
}

