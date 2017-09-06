package cn.gss.lk.servlet.front;

import cn.gss.lk.pojo.Menu;
import cn.gss.lk.pojo.User;
import cn.gss.lk.service.front.UserServiceFront;
import cn.gss.lk.service.front.impl.UserServiceFrontImpl;
import cn.gss.lk.util.DispatcherServlet;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CheckOutServlet", urlPatterns = "/pages/front/CheckOutServlet/*")
public class CheckOutServlet extends DispatcherServlet {
	private UserServiceFront userServiceFront = new UserServiceFrontImpl();

	public void changeCartRecord() {
		try {
			String menuid = request.getParameter("menuid");
			int change = Integer.parseInt(request.getParameter("change"));
			Object obj = request.getSession().getAttribute("cartRecord");
			Map<String, Integer> map = null;
			if (obj == null) {
				map = new HashMap<>();
				map.put(menuid, 1);
				request.getSession().setAttribute("cartRecord", map);
			} else if (change == 0) {
				map = (Map<String, Integer>) obj;
				map.remove(menuid);
			} else {
				map = (Map<String, Integer>) obj;
				if (map.get(menuid) == null) {
					map.put(menuid, 1);
				} else {
					map.put(menuid, map.get(menuid) + change);
				}
			}
			JSONObject cartRecordJson = new JSONObject();
			if (map != null) {
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					cartRecordJson.put(entry.getKey(), entry.getValue());
				}
				request.getSession().setAttribute("cartRecordJson", cartRecordJson);
				print("true");
			}
//			System.out.println("JSON:" + cartRecordJson);
		} catch (Exception e) {
			e.printStackTrace();
			print("false");
		}
	}

	public String checkOut() {
		int userid = ((User) request.getSession().getAttribute("user")).getId();
		Object obj = request.getSession().getAttribute("cartList");
		if (obj != null) {
			List<Menu> cartList = ((List<Menu>) obj);
			if (userServiceFront.checkOut(userid, cartList)) {
				request.getSession().removeAttribute("cartList");
				setMsgAndUrl("user.checkout.success", "front.index.servlet");
			} else {
				setMsgAndUrl("user.checkout.failure", "front.index.servlet");
			}
		} else {
			setMsgAndUrl("error.msg", "front.index.servlet");
		}
		return "forward.page";
	}

	public void calcTotal() {
		Object obj = request.getSession().getAttribute("cartList");
		double total = 0.0;
		if (obj != null) {
			List<Menu> cartList = (List<Menu>) obj;
			for (Menu m : cartList) {
//				System.out.println(m.getName() + "：" + m.getPrice() + "，" + m.getCount());
				total += m.getPrice() * m.getCount();
			}
		}
		print(total);
	}

	public void calcLength() {
		Object obj = request.getSession().getAttribute("cartList");
		int len = 0;
		if (obj != null) {
			len = ((List<Menu>) obj).size();
		}
		print(len);
	}

	public void addCart() {
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		List<Menu> cartList = (List<Menu>) request.getSession().getAttribute("cartList");
		boolean isFound = false;
		for (Iterator<Menu> iter = cartList.iterator(); iter.hasNext(); ) {
			Menu temp = iter.next();
			if (temp.getCount() == temp.getSum())
				break;
			if (temp.getId() == menuid) {
				temp.setCount(temp.getCount() + 1);
				isFound = true;
				break;
			}
		}
		print(isFound);
	}

	public void subCart() {
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		List<Menu> cartList = (List<Menu>) request.getSession().getAttribute("cartList");
		boolean isFound = false;
		for (Iterator<Menu> iter = cartList.iterator(); iter.hasNext(); ) {
			Menu temp = iter.next();
			if (temp.getId() == menuid) {
//				System.out.println("*********************************************************");
				temp.setCount(temp.getCount() - 1);
				isFound = true;
				break;
			}
		}
//		System.out.println("当前List --：");
		for (Iterator<Menu> iterator = cartList.iterator(); iterator.hasNext(); ) {
			Menu menu = iterator.next();
//			System.out.println(menu.getId() + "::" + menu.getName() + "::" + menu.getPrice() + "::" + menu.getCount());
		}
		print(isFound);
	}

	public void removeCart() {
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		List<Menu> cartList = (List<Menu>) request.getSession().getAttribute("cartList");
		boolean isFound = false;
		for (Iterator<Menu> iter = cartList.iterator(); iter.hasNext(); ) {
			Menu temp = iter.next();
			if (temp.getId() == menuid) {
				iter.remove();
				isFound = true;
				break;
			}
		}
		print(isFound);
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
