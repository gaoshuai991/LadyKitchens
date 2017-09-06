package cn.gss.lk.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库操作工具类
 *
 * @author Administrator
 */
public class DBUtil {

	// 数据源
	private static DataSource dataSource = null;

	static {
		// 从连接池中设置数据源，数据库连接池只被初始化一次
		dataSource = new ComboPooledDataSource();
	}

	/**
	 * 获取连接
	 *
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 * 执行insert、update、delete
	 *
	 * @param sql  SQL语句
	 * @param args 填充占位符的可变参数
	 * @return 返回受影响的行数
	 */
	public static int execute(String sql, Object... args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			// 获取连接
			connection = getConnection();
			// 向数据库发送要执行的SQL语句
			preparedStatement = connection.prepareStatement(sql);
//			System.out.println("执行sql: " + sql);

			// 给带有占位符的SQL语句进行赋值操作
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			// 执行SQL语句，返回受影响的行数
			int count = preparedStatement.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseDB(null, preparedStatement, connection);
		}
		return 0;
	}

	/**
	 * 释放资源
	 *
	 * @param resultSet  结果集
	 * @param statement  命令
	 * @param connection 连接
	 */
	public static void releaseDB(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				// 数据库连接池的Connection对象进行Close时，不是关闭而是将数据库连接归还到连接池中
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询一条数据
	 *
	 * @param clazz 对象的类型
	 * @param sql   执行的SQL语句
	 * @param args  可变参数
	 * @return 返回对象
	 */
	public static <T> T getObject(Class<T> clazz, String sql, Object... args) {

		T entity = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取连接
			connection = getConnection();
			//向数据库发送要执行的SQL语句
			preparedStatement = connection.prepareStatement(sql);
//			System.out.println("执行sql: " + sql);
			//给带有占位符的SQL语句赋值
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}

			//将查询的结果放到结果集中
			resultSet = preparedStatement.executeQuery();

			//得到ResultSet中的元数据，即可以得到结果集中列的数量及列的名称。
			ResultSetMetaData rsmd = resultSet.getMetaData();

			//结果集中的列数
			int columnCount = rsmd.getColumnCount();

			//创建一个Map 键:存放列名  值:存放列的值
			Map<String, Object> values = new HashMap<>();

			//判断结果集中是否有数据
			if (resultSet.next()) {
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(columnLabel);
					//将列名和列值添加到Map中。
					values.put(columnLabel, columnValue);
				}
			}

			//判断Map中是否有数据
			if (values.size() > 0) {
				//利用反射创建Class参数的实例
				entity = clazz.newInstance();

				//遍历Map的结果，将列名和列值赋值给Class参数的实例
				for (Map.Entry<String, Object> entry : values.entrySet()) {
					String propertyName = entry.getKey();
					Object propertyValue = entry.getValue();

					//利用反射给Class的属性进行赋值。
					//ReflectionUtils.setFieldValue(entity, propertyName, propertyValue);
					BeanUtils.setProperty(entity, propertyName, propertyValue);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseDB(resultSet, preparedStatement, connection);
		}

		//返回Class类型的实例
		return entity;
	}

	/**
	 * 查询多条记录
	 *
	 * @param clazz 对象的类型
	 * @param sql   SQL语句
	 * @param args  可变参数
	 * @return 返回List<T>
	 */
	public static <T> List<T> getQueryList(Class<T> clazz, String sql, Object... args) {
		List<T> list = null;
		//准备一个List<Map<String,Object>>其中一个Map对应一条记录
		List<Map<String, Object>> values = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
//			System.out.println("执行sql: " + sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			//创建一个Map用来存放列的名称和列的值
			Map<String, Object> map = null;
			while (resultSet.next()) {
				map = new HashMap<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(columnLabel);
					//将列名和列值添加到Map中
					map.put(columnLabel, columnValue);
				}
				values.add(map);//将一条记录Map对象添加到List中。
			}

			//创建一个参数对应的Object对象
			T entity = null;
			//判断List是否为空集合，若不为空则遍历List，得到一个个Map对象，再将Map对象转化为Class参数对应的Object对象。
			if (values.size() > 0) {
				list = new ArrayList<>();
				for (Map<String, Object> m : values) {
					//利用反射创建Object参数的实例
					entity = clazz.newInstance();
					for (Map.Entry<String, Object> entry : m.entrySet()) {
						String propertyName = entry.getKey();
						Object propertyValue = entry.getValue();
						//通过BeanUntils设置Object对象的属性值。
						BeanUtils.setProperty(entity, propertyName, propertyValue);
					}

					//将entity对象添加到List中
					list.add(entity);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseDB(resultSet, preparedStatement, connection);
		}

		return list;
	}

	/**
	 * 查询单个结果(一行一列)
	 *
	 * @param sql
	 * @param args
	 * @return
	 */
	public static <T> T getSingleValue(String sql, Object... args) {
		T t1 = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
//			System.out.println("执行sql: " + sql);
			for (int i = 0; i < args.length; i++) {
//				System.out.println("参数index："+ (i+1) +",value:qian"+args[i]+"hou");
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				t1 = (T) resultSet.getObject(1);

//				System.out.println("************ count:"+t1);
				return t1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseDB(resultSet, preparedStatement, connection);
		}
		return t1;
	}

	/**
	 * 获得新增数据的主键值
	 *
	 * @param sql
	 * @param args
	 * @return 返回生成的主键
	 */
	public static Object getPrimaryKey(String sql, Object... args) {
		Object result = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			//使用重载的preparedStatement(sql,flag) 生成PreparedStatement对象。
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();

			//通过.getGeneratedKeys()获取包含了新生成的主键ResultSet对象。
			//在ResultSet中只有一列GENERATED_KEYS,用于存放生成的主键值。
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				result = resultSet.getObject(1);
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseDB(resultSet, preparedStatement, connection);
		}

		return result;
	}


	/**
	 * 处理事务
	 *
	 * @param connection
	 * @param sql
	 * @param args
	 */
	public static void executeTransaction(Connection connection, String sql, Object... args) throws Exception {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			releaseDB(null, preparedStatement, null);
		}
	}

	/**
	 * 开启事务
	 *
	 * @param connection
	 */
	public static void beginTransaction(Connection connection) {
		if (connection != null) {
			try {
				connection.setAutoCommit(false);//关闭自动提交模式
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 提交事务
	 *
	 * @param connection
	 */
	public static void commitTransaction(Connection connection) {
		if (connection != null) {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 回滚事务
	 *
	 * @param connection
	 */
	public static void rollbackTransaction(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
