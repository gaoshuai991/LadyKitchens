package cn.gss.lk.service.back.impl;

import cn.gss.lk.dao.NoticeDao;
import cn.gss.lk.dao.impl.NoticeDaoImpl;
import cn.gss.lk.pojo.Notice;
import cn.gss.lk.service.back.NoticeServiceBack;
import cn.gss.lk.service.front.NoticeServiceFront;

import java.util.List;
import java.util.Set;

public class NoticeServiceBackImpl implements NoticeServiceBack {
	private NoticeDao noticeDao = new NoticeDaoImpl();
	@Override
	public boolean insert(Notice vo) {
		return noticeDao.insert(vo);
	}

	@Override
	public boolean update(Notice vo) {
		return noticeDao.update(vo);
	}

	@Override
	public boolean delete(Set<Integer> ids) {
		return noticeDao.delete(ids);
	}

	@Override
	public List<Notice> findAll() {
		return noticeDao.findAll();
	}
}
