package cn.gss.lk.dao.impl;

import cn.gss.lk.dao.NoticeDao;
import cn.gss.lk.pojo.Notice;
import cn.gss.lk.util.DBUtil;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class NoticeDaoImpl extends AbstractDao implements NoticeDao {
	@Override
	public boolean insert(Notice vo) {
		String sql = "INSERT INTO notice(name,content,times) VALUES(?,?,?)";
		return DBUtil.execute(sql, vo.getName(), vo.getContent(), new Timestamp(System.currentTimeMillis())) > 0;
	}

	@Override
	public boolean update(Notice vo) {
		String sql = "UPDATE notice SET name=?,content=?,times=? WHERE id=?";
		return DBUtil.execute(sql,vo.getName(),vo.getContent(),new Timestamp(System.currentTimeMillis()),vo.getId()) > 0;
	}

	@Override
	public boolean delete(Set<Integer> ids) {
		return deleteHandler("notice", "id", ids);
	}

	@Override
	public List<Notice> findAll() {
		String sql = "SELECT id,name,content,times FROM notice";
		return DBUtil.getQueryList(Notice.class, sql);
	}

	@Override
	public List<Notice> findNew() {
		String sql = "SELECT id,name,content,times FROM notice ORDER BY times DESC LIMIT 0,3";
		return DBUtil.getQueryList(Notice.class, sql);
	}
}
