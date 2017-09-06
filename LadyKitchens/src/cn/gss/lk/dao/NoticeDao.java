package cn.gss.lk.dao;

import cn.gss.lk.pojo.Notice;

import java.util.List;
import java.util.Set;

public interface NoticeDao {
	boolean insert(Notice vo);

	boolean update(Notice vo);

	boolean delete(Set<Integer> ids);

	List<Notice> findAll();

	List<Notice> findNew();
}
