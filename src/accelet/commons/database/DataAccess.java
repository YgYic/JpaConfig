package accelet.commons.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.DataSource;

public class DataAccess implements IDataAccess {
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	// query
	public int queryForInt(String sql, Object[] values) {
		int ret_value = Integer.MIN_VALUE;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof Integer) {
						ps.setInt(i + 1, ((Integer) values[i]).intValue());
					} else if (values[i] instanceof String) {
						ps.setString(i + 1, ((String) values[i]));
					} else if (values[i] instanceof Double) {
						ps.setDouble(i + 1, ((Double) values[i]));
					} else {
						ps.setString(i + 1, ""); // 如果为null 暂时用""处理
						// throw new Exception("用户输入类型错误");
					}
				}
			}
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ret_value = rs.getInt(1);
			}
			rs.close();
			return ret_value;
		} catch (Exception e) {
			System.out.println("queryForInt sql=" + sql);
			e.printStackTrace();
			return Integer.MIN_VALUE;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public String queryForString(String sql, Object[] values) {
		String ret_value = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof Integer) {
						ps.setInt(i + 1, ((Integer) values[i]).intValue());
					} else if (values[i] instanceof String) {
						ps.setString(i + 1, ((String) values[i]));
					} else if (values[i] instanceof Double) {
						ps.setDouble(i + 1, ((Double) values[i]));
					} else {
						ps.setString(i + 1, "");// 如果为null 暂时用""处理
						// throw new Exception("用户输入类型错误");
					}
				}
			}
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ret_value = rs.getString(1);
			}
			rs.close();
			return ret_value;
		} catch (Exception e) {
			System.out.println("queryForString sql=" + sql);
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	public AcResult queryForAcResult(String sql, Object[] values) {
		return queryForAcResult(sql, values, 0);
	}

	public AcResult queryForAcResult(String sql, Object[] values, int dateFormat) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof Integer) {
						ps.setInt(i + 1, ((Integer) values[i]).intValue());
					} else if (values[i] instanceof String) {
						ps.setString(i + 1, ((String) values[i]));
					} else if (values[i] instanceof Double) {
						ps.setDouble(i + 1, ((Double) values[i]));
					} else {
						ps.setString(i + 1, "");// 如果为null 暂时用""处理
						// throw new Exception("用户输入类型错误");
					}
				}
			}
			AcResult result = new AcResult();
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int fieldCount = metaData.getColumnCount();
			String[] fieldNames = new String[fieldCount];
			int[] fieldTypes = new int[fieldCount];
			for (int i = 0; i < fieldCount; i++) {
				fieldNames[i] = metaData.getColumnLabel(i + 1);
				fieldTypes[i] = metaData.getColumnType(i + 1);
			}
			result.setFieldNames(fieldNames);
			result.setFieldTypes(fieldTypes);

			while (rs.next()) {
				Object[] row = new Object[fieldCount];
				for (int i = 0; i < fieldNames.length; i++) {
					try {
						row[i] = rs.getObject(i + 1); 
						if (row[i] instanceof java.sql.Timestamp) {
							String dateString = row[i].toString();
							if (dateString.endsWith(".0")) {
								dateString = dateString.substring(0, dateString.length() - 2);
							}
							if (dateFormat == 1) {
								dateString = dateString.substring(2, dateString.length() - 3);
								dateString = dateString.replace('-', '/');
							}
							row[i] = dateString;
						}
					} catch(Exception ee) {
						row[i] = ""; 
					}
				}
				result.add(row);
			}
			rs.close();
			return result;
		} catch (Exception e) {
			System.out.println("queryForAcResult sql=" + sql);
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	// for ResultSet
	public ResultSet queryForResultSet(String sql, Object[] values) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof Integer) {
						ps.setInt(i + 1, ((Integer) values[i]).intValue());
					} else if (values[i] instanceof String) {
						ps.setString(i + 1, ((String) values[i]));
					} else if (values[i] instanceof Double) {
						ps.setDouble(i + 1, ((Double) values[i]));
					} else {
						ps.setString(i + 1, "");// 如果为null 暂时用""处理
						// throw new Exception("用户输入类型错误");
					}
				}
			}
			return ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (Exception ex) {
			}
			return null;
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			rs.getStatement().getConnection().close();
		} catch (Exception e) {
		}
	}

	// update
	public int execute(String sql, Object[] values) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof Integer) {
						ps.setInt(i + 1, ((Integer) values[i]).intValue());
					} else if (values[i] instanceof String) {
						ps.setString(i + 1, ((String) values[i]));
					} else if (values[i] instanceof Double) {
						ps.setDouble(i + 1, ((Double) values[i]));
					} else {
						ps.setString(i + 1, "");// 如果为null 暂时用""处理
						// throw new Exception("用户输入类型错误");
					}
				}
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("execute sql=" + sql);
			e.printStackTrace();
			return Integer.MIN_VALUE;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	// bat execute
	public PreparedStatement openPrepare(String sql) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			return conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int executePrepare(PreparedStatement ps, Object[] values) {
		try {
			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] instanceof Integer) {
						ps.setInt(i + 1, ((Integer) values[i]).intValue());
					} else if (values[i] instanceof String) {
						ps.setString(i + 1, ((String) values[i]));
					} else if (values[i] instanceof Double) {
						ps.setDouble(i + 1, ((Double) values[i]));
					} else {
						ps.setString(i + 1, "");// 如果为null 暂时用""处理
						// throw new Exception("用户输入类型错误");
					}
				}
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return Integer.MIN_VALUE;
		}
	}

	public void closePrepare(PreparedStatement ps) {
		try {
			ps.getConnection().close();
		} catch (Exception e) {
		}
	}
}
