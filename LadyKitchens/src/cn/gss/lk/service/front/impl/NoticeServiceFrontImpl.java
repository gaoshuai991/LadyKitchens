package cn.gss.lk.service.front.impl;

import cn.gss.lk.dao.NoticeDao;
import cn.gss.lk.dao.impl.NoticeDaoImpl;
import cn.gss.lk.pojo.Notice;
import cn.gss.lk.service.front.NoticeServiceFront;

import java.util.List;

public class NoticeServiceFrontImpl implements NoticeServiceFront {
	private NoticeDao noticeDao = new NoticeDaoImpl();
	@Override
	public boolean insert(Notice vo) {
		return noticeDao.insert(vo);
	}

	@Override
	public List<Notice> findAll() {
		return noticeDao.findAll();
	}

	@Override
	public List<Notice> findNew() {
		return noticeDao.findNew();
	}
}
