package cn.gss.lk.service.back;

import cn.gss.lk.vo.OrderInfo;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OrderInfoService {
	OrderInfo show(int orderid);

	boolean delete(Set<Integer> ids);

	List<OrderInfo> findAllSplit(int currPage, int lineSize, String column, String keyword);

	List<OrderInfo> findAllSplitByUser(int currPage, int lineSize, String keyword);

	List<OrderInfo> findAllSplitByDate(Date begin, Date end, int currPage, int lineSize, String column, String keyword);

	int getAllCount(String column, String keyword);

	int getAllCountByUser(String keyword);
}
