package cn.gss.lk.dao.impl;

import cn.gss.lk.dao.MenuDao;
import cn.gss.lk.pojo.Menu;
import cn.gss.lk.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MenuDaoImpl extends AbstractDao implements MenuDao {
	@Override
	public boolean insert(Menu menu) {
		String sql = "INSERT INTO menus(name,typeid,burden,brief,sum,price,imgpath) VALUES(?,?,?,?,?,?,?)";
		return DBUtil.execute(sql, menu.getName(), menu.getTypeid(), menu.getBurden(), menu.getBrief(), menu.getSum(), menu.getPrice(), menu.getImgpath()) > 0;
	}

	@Override
	public boolean update(Menu menu) {
		String sql = "UPDATE menus SET name=?,typeid=?,burden=?,brief=?,sum=?,price=?,imgpath=? WHERE id=?";
		return DBUtil.execute(sql, menu.getName(), menu.getTypeid(), menu.getBurden(), menu.getBrief(), menu.getSum(), menu.getPrice(), menu.getImgpath(), menu.getId()) > 0;
	}

	@Override
	public boolean updateSum(int menuid,int change) {
		String sql = "UPDATE menus SET sum=sum+? WHERE id=?";
		return DBUtil.execute(sql,change,menuid) > 0;
	}

	@Override
	public boolean delete(Set<Integer> ids) {
		return deleteHandler("menus", "id", ids);
	}

	@Override
	public Menu get(int menuid) {
		String sql = "SELECT id,name,typeid,burden,brief,sum,price,imgpath FROM menus WHERE id=?";
		return DBUtil.getObject(Menu.class, sql, menuid);
	}

	@Override
	public List<Menu> findAllSplit(int currPage, int lineSize, String column, String keyword) {
		String sql = "SELECT id,name,typeid,burden,brief,sum,price,imgpath FROM menus WHERE " + column + " LIKE ? LIMIT ?,?";
		return DBUtil.getQueryList(Menu.class, sql, "%" + keyword + "%", (currPage - 1) * lineSize, lineSize);
	}

	@Override
	public List<Menu> findAll() {
		String sql = "SELECT id,name,typeid,burden,brief,sum,price,imgpath FROM menus";
		return DBUtil.getQueryList(Menu.class, sql);
	}

	@Override
	public List<Menu> findAllByType(int typeid) {
		String sql = "SELECT id,name,typeid,burden,brief,sum,price,imgpath FROM menus WHERE typeid=?";
		return DBUtil.getQueryList(Menu.class, sql, typeid);
	}

	@Override
	public int getAllCount(String column, String keyword) {
		String sql = "SELECT COUNT(*) FROM menus WHERE " + column + " LIKE ?";
		return DBUtil.<Long>getSingleValue(sql, "%" + keyword + "%").intValue();
	}

	@Override
	public List<Menu> findHotMenus() {
		String sql = "SELECT * FROM menus WHERE id IN ( " +
				"SELECT a.menuid " +
				"FROM ( " +
				"  SELECT menuid " +
				"  FROM orders_details " +
				"  GROUP BY menuid " +
				"  ORDER BY sum(count) DESC LIMIT 0,4) a) ORDER BY sum DESC";
		return DBUtil.getQueryList(Menu.class, sql);
	}

	@Override
	public List<Menu> findHotTypedMenus(int typeid) {
		String sql = "SELECT * FROM menus WHERE id IN ( " +
				"  SELECT a.menuid " +
				"  FROM ( " +
				"    SELECT menuid " +
				"    FROM orders_details " +
				"    GROUP BY menuid " +
				"    ORDER BY sum(count) DESC LIMIT 0,4) a " +
				") AND typeid=? " +
				"UNION SELECT * FROM menus WHERE typeid=? LIMIT 0,4";
		return DBUtil.getQueryList(Menu.class, sql, typeid, typeid);
	}
}
