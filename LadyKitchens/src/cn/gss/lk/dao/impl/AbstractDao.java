package cn.gss.lk.dao.impl;

import cn.gss.lk.util.DBUtil;
import cn.gss.lk.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;


public abstract class AbstractDao {
	protected PreparedStatement ps;
	protected Connection conn;

	/**
	 * 负责统计出数据量
	 * @param table 要统计数据的表名称
	 * @param column 要统计的数据列
	 * @param keyWord 模糊查询关键字
	 * @return 返回表的数据量，如果没有数据返回0
	 * @throws Exception
	 */
	public Integer countHandler(String table, String column, String keyWord) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) FROM ").append(table).append(" WHERE ").append(column).append(" LIKE ?");
		return DBUtil.getSingleValue(sql.toString(),"%" + keyWord + "%");
	}

	public boolean deleteHandler(String table, String column, Set<Integer> ids) {
		StringBuilder sql = new StringBuilder("DELETE FROM "+table+" WHERE "+column+" IN (");
		for (int id : ids) {
			sql.append(id).append(",");
		}
		sql.deleteCharAt(sql.length() - 1).append(")");
		return DBUtil.execute(sql.toString()) > 0;
	}







	public void setPrepareStatementParams(Object... obj) throws SQLException {
		for (int i = 0; i < obj.length; i++)
			ps.setObject(i + 1, obj[i]);
	}

	public ResultSet executeQuery(String sql, Object... obj) throws SQLException {
		ps = getConnection().prepareStatement(sql);
		setPrepareStatementParams(obj);
		return ps.executeQuery();
	}

	public int executeUpdate(String sql, Object... obj) throws SQLException {
		ps = getConnection().prepareStatement(sql);
		setPrepareStatementParams(obj);
		return ps.executeUpdate();
	}

	public Connection getConnection() throws SQLException {
		if (conn == null)
			conn = JdbcUtils.getConnection();
		return conn;
	}

	public PreparedStatement getPreparedStatement() {
		return ps;
	}
}
