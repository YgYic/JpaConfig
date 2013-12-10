package accelet.commons.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IDataAccess {
	// query
	public int queryForInt(String sql, Object[] values);

	public String queryForString(String sql, Object[] values);

	public AcResult queryForAcResult(String sql, Object[] values);
	public AcResult queryForAcResult(String sql, Object[] values, int dateFormat);

	//
	public ResultSet queryForResultSet(String sql, Object[] values);

	public void closeResultSet(ResultSet rs);

	// execute(insert, update, delete)
	public int execute(String sql, Object[] values);

	// bat execute
	public PreparedStatement openPrepare(String sql);

	public int executePrepare(PreparedStatement ps, Object[] values);

	public void closePrepare(PreparedStatement ps);
}
