package cn.gss.lk.servlet.back;

import cn.gss.lk.pojo.Type;
import cn.gss.lk.service.back.TypeService;
import cn.gss.lk.service.back.impl.TypeServiceImpl;
import cn.gss.lk.util.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.util.Set;

@WebServlet(name = "TypeServlet", urlPatterns = "/pages/back/type/TypeServlet/*")
public class TypeServlet extends DispatcherServlet {
	private final String insertValidate = "type.name";
	private TypeService typeService = new TypeServiceImpl();
	private Type type = new Type();

	public Type getType() {
		return type;
	}

	public String insert() {
		if (typeService.insert(type)) {
			setMsgAndUrl("vo.insert.success", "type.list.servlet");
		} else {
			setMsgAndUrl("vo.insert.failure", "type.insert.page");
		}
		return "forward.page";
	}

	public String updatePre() {
		request.setAttribute("type", typeService.get(type.getId()));
		return "type.update.page";
	}

	public String update() {
		if (typeService.update(type)) {
			setMsgAndUrl("vo.update.success", "type.list.servlet");
		} else {
			setMsgAndUrl("vo.update.failure", "type.update.page");
		}
		return "forward.page";
	}

	public String delete() {
		Set<Integer> ids = getIds();
		if (typeService.delete(ids)) {
			setMsgAndUrl("vo.delete.success", "type.list.servlet");
		} else {
			setMsgAndUrl("vo.delete.failure", "type.list.servlet");
		}
		return "forward.page";
	}

	public String list() {
		request.setAttribute("allType", typeService.findAll());
		return "type.list.page";
	}

	@Override
	public String getSubTitle() {
		return "菜品类型";
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
