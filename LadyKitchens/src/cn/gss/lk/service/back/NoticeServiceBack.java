package cn.gss.lk.service.back;

import cn.gss.lk.pojo.Notice;

import java.util.List;
import java.util.Set;

public interface NoticeServiceBack {
	boolean insert(Notice vo);

	boolean update(Notice vo);

	boolean delete(Set<Integer> ids);

	List<Notice> findAll();
}
