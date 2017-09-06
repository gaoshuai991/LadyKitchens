package cn.gss.lk.service.front;

import cn.gss.lk.pojo.Notice;

import java.util.List;

public interface NoticeServiceFront {
	boolean insert(Notice vo);

	List<Notice> findAll();
	List<Notice> findNew();
}
