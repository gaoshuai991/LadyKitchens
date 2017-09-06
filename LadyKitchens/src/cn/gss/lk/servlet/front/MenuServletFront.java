package cn.gss.lk.servlet.front;

import cn.gss.lk.pojo.Menu;
import cn.gss.lk.service.front.MenuServiceFront;
import cn.gss.lk.service.front.impl.MenuServiceFrontImpl;
import cn.gss.lk.util.DispatcherServlet;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.util.*;

@WebServlet(name = "MenuServletFront", urlPatterns = "/pages/front/MenuServletFront/*")
public class MenuServletFront extends DispatcherServlet {
	private MenuServiceFront menuServiceFront = new MenuServiceFrontImpl();

	public String index() {
		Map<String, Object> map = menuServiceFront.prepareIndex();
		request.setAttribute("allHotMenus", map.get("allHotMenus"));
		request.setAttribute("allType", map.get("allType"));
		request.setAttribute("allHotTypedMenus", map.get("allHotTypedMenus"));
		request.setAttribute("allNewNotice",map.get("allNewNotice"));
		return "front.index.page";
	}

	public void show(){
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		Menu menu = menuServiceFront.get(menuid);
		JSONObject res = new JSONObject();
		res.put("id",menu.getId());
		res.put("name",menu.getName());
		res.put("typename",menuServiceFront.getType(menu.getTypeid()).getName());
		res.put("burden",menu.getBurden());
		res.put("brief",menu.getBrief());
		res.put("sum",menu.getSum());
		res.put("price",menu.getPrice());
		res.put("imgpath",menu.getImgpath());
		print(res);
	}

	public String list() {
		Map<String, Object> map = menuServiceFront.findAll();
		request.setAttribute("allType", menuServiceFront.findAllType());
		request.setAttribute("allMenu", map.get("allMenu"));
		return "front.menu.list.page";
	}

	public void addCart() {
		try {
			int menuid = Integer.parseInt(request.getParameter("menuid"));
			Object cartObj = request.getSession().getAttribute("cartList");
			if (cartObj == null) {
				List<Menu> cartList = new ArrayList<>();
				Menu menu = menuServiceFront.get(menuid);
				menu.setCount(1);
				cartList.add(menu);
				request.getSession().setAttribute("cartList",cartList);
			} else {
				List<Menu> cartList = (List<Menu>) cartObj;
				boolean isFound = false;
				for (Iterator<Menu> iter = cartList.iterator(); iter.hasNext(); ) {
					Menu temp = iter.next();
					if (temp.getId() == menuid) {
						if(temp.getCount() == temp.getSum()){
							print("false");
							return;
						}
						temp.setCount(temp.getCount() + 1);
						isFound = true;
					}
				}
				if (!isFound) {
					Menu menu = menuServiceFront.get(menuid);
					menu.setCount(1);
					cartList.add(menu);
				}
			}
			print("true");
		}catch (Exception e){
			e.printStackTrace();
			print("false");
		}
	}


	@Override
	public String getSubTitle() {
		return null;
	}

	@Override
	public String getSubUploadDir() {
		return null;
	}

	@Override
	public String getDefaultColumn() {
		return null;
	}

	@Override
	public String getColumnData() {
		return null;
	}
}
