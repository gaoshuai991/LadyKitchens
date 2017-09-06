package cn.gss.lk.servlet.back;

import cn.gss.lk.pojo.Menu;
import cn.gss.lk.service.back.MenuService;
import cn.gss.lk.service.back.impl.MenuServiceImpl;
import cn.gss.lk.util.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "MenuServlet", urlPatterns = "/pages/back/menu/MenuServlet/*")
public class MenuServlet extends DispatcherServlet {
	private final String insertValidate = "menu.name|menu.typeid|menu.sum|menu.price";
	private final String updateValidate = "menu.name|menu.typeid|menu.sum|menu.price";
	private final String updatePreValidate = "menu.id";
	private MenuService menuService = new MenuServiceImpl();

	private Menu menu = new Menu();

	public Menu getMenu() {
		return menu;
	}

	public String list() {
		handleSplit();
		Map<String, Object> map = menuService.list(getCurrentPage(), getLineSize(), getColumn(), getKeyword());
		request.setAttribute("allMenu", map.get("allMenu"));
		request.setAttribute("allRecorders", map.get("allRecorders"));
		request.setAttribute("typeMap",map.get("typeMap"));
		request.setAttribute("url", getPath("menu.list.servlet"));
		return "menu.list.page";
	}

	public String insertPre() {
		Map<String, Object> map = menuService.insertPre();
		request.setAttribute("allType", map.get("allType"));
		return "menu.insert.page";
	}

	public String insert() {
		try {
			if (isUpload()) {
				String fileName = createSingleFileName();
				menu.setImgpath(fileName);
			}
			if (menuService.insert(menu)) {
				if (isUpload()) {
					saveFile(menu.getImgpath());
				}
				setMsgAndUrl("vo.insert.success", "menu.list.servlet");
			} else {
				setMsgAndUrl("vo.insert.failure", "menu.insertPre.servlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward.page";
	}

	public String updatePre() {
		Map<String, Object> map = menuService.updatePre(menu.getId());
//		System.out.println("*****menuId=" + menu.getId() + "*********** :" + map.get("menu"));
		request.setAttribute("allType", map.get("allType"));
		request.setAttribute("menu", map.get("menu"));
		return "menu.update.page";
	}

	public String update() {
		try {
			String oldFileName = menu.getImgpath();
			if (isUpload()) {
				String newFileName = createSingleFileName();
				menu.setImgpath(newFileName);
			}
			if (menuService.update(menu)) {
				if (isUpload()) {
					deleteFile(oldFileName);
					saveFile(menu.getImgpath());
				}
				setMsgAndUrl("vo.update.success", "menu.list.servlet");
			} else {
				setMsgAndUrl("vo.update.failure", "menu.updatePre.servlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward.page";
	}

	public String delete() {
		Set<Integer> ids = getIds();
		for (int id : ids) {
			try {
				deleteFile(menuService.get(id).getImgpath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (menuService.delete(ids)) {
			setMsgAndUrl("vo.delete.success", "menu.list.servlet");
		} else {
			setMsgAndUrl("vo.delete.failure", "menu.list.servlet");
		}
		return "forward.page";
	}

	@Override
	public String getSubTitle() {
		return "菜品信息";
	}

	@Override
	public String getSubUploadDir() {
		return "/upload/menu/";
	}

	@Override
	public String getDefaultColumn() {
		return "name";
	}

	@Override
	public String getColumnData() {
		return "菜品名称:name|原材料:burden|简介:burden";
	}
}
