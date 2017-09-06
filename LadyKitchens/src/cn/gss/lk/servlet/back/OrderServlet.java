package cn.gss.lk.servlet.back;

import cn.gss.lk.pojo.OrderDetails;
import cn.gss.lk.service.back.OrderInfoService;
import cn.gss.lk.service.back.impl.OrderInfoServiceImpl;
import cn.gss.lk.util.DispatcherServlet;
import cn.gss.lk.vo.OrderInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@WebServlet(name = "OrderServlet", urlPatterns = "/pages/back/order/OrderServlet/*")
public class OrderServlet extends DispatcherServlet {
	private OrderInfoService orderInfoService = new OrderInfoServiceImpl();

	public String delete() {
		String referer = request.getHeader("referer");
		String url = "/pages/back/order/OrderServlet" + referer.substring(referer.lastIndexOf("/"));
		if (orderInfoService.delete(getIds())) {
			request.setAttribute("msg",getMsg("vo.delete.success"));
		} else {
			request.setAttribute("msg",getMsg("vo.delete.failure"));
		}
		request.setAttribute("url",url);
		return "forward.page";
	}

	public void show() {
		int orderid = Integer.parseInt(request.getParameter("id"));
		OrderInfo orderInfo = orderInfoService.show(orderid);
		JSONObject orderInfoObj = new JSONObject();
		orderInfoObj.put("id", orderInfo.getId());
		orderInfoObj.put("username", orderInfo.getUsername());
		orderInfoObj.put("total", orderInfo.getTotal());
		orderInfoObj.put("times", orderInfo.getTimes());
		orderInfoObj.put("delivery", orderInfo.getDelivery());
		JSONArray orderDetailsListObj = new JSONArray();
		for (OrderDetails o : orderInfo.getOrderDetailsList()) {
			JSONObject orderDetailsObj = new JSONObject();
			orderDetailsObj.put("orderid", o.getOrderid());
			orderDetailsObj.put("menuid", o.getMenuid());
			orderDetailsObj.put("menuname", o.getMenuname());
			orderDetailsObj.put("count", o.getCount());
			orderDetailsObj.put("price", o.getPrice());
			orderDetailsListObj.add(orderDetailsObj);
		}
		orderInfoObj.put("orderDetailsList", orderDetailsListObj);
//		System.out.println("返回数据：" + orderInfoObj);
		print(orderInfoObj);
	}

	public String list() {
		handleSplit();
		request.setAttribute("allOrderInfo", orderInfoService.findAllSplit(getCurrentPage(), getLineSize(), getColumn(), getKeyword()));
		request.setAttribute("allRecorders", orderInfoService.getAllCountByUser(getKeyword()));
		request.setAttribute("url", getPath("order.listByUser.servlet"));
		return "order.list.page";
	}

	public String listByUser() {
		handleSplit();
//		String username = request.getParameter("username");
		request.setAttribute("allOrderInfo", orderInfoService.findAllSplitByUser(getCurrentPage(), getLineSize(), getKeyword()));
		request.setAttribute("allRecorders", orderInfoService.getAllCountByUser(getKeyword()));
		request.setAttribute("url", getPath("order.listByUser.servlet"));
		return "order.list.page";
	}

	public String listByDate() {
		handleSplit();
		Date begin, end;
		try {
			begin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("begin"));
			end = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end"));
			request.setAttribute("allOrder", orderInfoService.findAllSplitByDate(begin, end, getCurrentPage(), getLineSize(), getColumn(), getKeyword()));
			request.setAttribute("allRecorders", orderInfoService.getAllCount(getColumn(), getKeyword()));
			request.setAttribute("url", getPath("order.listByDate.servlet"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "order.list.page";
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
		return "username";
	}

	@Override
	public String getColumnData() {
		return "用户名:username";
	}
}
