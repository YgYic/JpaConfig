/**
 * 
 */
package accelet.commons.database;

/**
 * @author wang.donghui
 * 
 */
public class AcCacheResult {
	IDataAccess dataAccess;
	String sql;
	Object[] values;
	int recordCount;
	int pageSize; // 每页项数,默认为20
	int pageNo; // 当前页号（基于1）
	int pageCount; // 页数
	String pageURLHead;
	int pageStringViewMode = 1;
	int dateFormat = 0;// 时间显示格式(0:完整形式，1:缩略形式)
	AcResult result;

	public int getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(int dateFormat) {
		this.dateFormat = dateFormat;
	}

	public AcCacheResult(IDataAccess dataAccess, String sql, Object[] values) {
		this(dataAccess, sql, values, 20);
	}

	public AcCacheResult(IDataAccess dataAccess, String sql, Object[] values,
			int pageSize) {
		this.dataAccess = dataAccess;
		this.sql = sql;
		this.values = values;
		recordCount = dataAccess.queryForInt(getSelectCountSql(sql), values);
		if (recordCount < 0)
			recordCount = 0;
		this.pageSize = pageSize;
		pageCount = (recordCount == 0) ? 0
				: ((int) ((recordCount - 1) / pageSize)) + 1;
		this.pageNo = 0;
	}

	public AcCacheResult(IDataAccess dataAccess, String sql, Object[] values,
			int pageSize, int nRecordCount) {
		this.dataAccess = dataAccess;
		this.sql = sql;
		this.values = values;
		recordCount = nRecordCount;
		if (recordCount < 0)
			recordCount = 0;
		this.pageSize = pageSize;
		pageCount = (recordCount == 0) ? 0
				: ((int) ((recordCount - 1) / pageSize)) + 1;
		this.pageNo = 0;
	}

	private String getSelectCountSql(String sql) {
		String upperCaseSql = sql.toUpperCase();
	
//		return "SELECT count(*)"
//				+ sql.substring(upperCaseSql.indexOf(" FROM "));

//		if (upperCaseSql.indexOf(" ORDER BY ") > 0) {
//			return "SELECT COUNT(*)" + sql.substring(upperCaseSql.indexOf(" FROM "), upperCaseSql.indexOf(" ORDER BY "));
//		} else {
//			return "SELECT COUNT(*)" + sql.substring(upperCaseSql.indexOf(" FROM "));
//		}
		if (upperCaseSql.indexOf(" ORDER BY ") > 0) {
			return "SELECT COUNT(*) FROM (" + sql.substring(0, upperCaseSql.indexOf(" ORDER BY ")) + ") AS temp_table";
		} else {
			return "SELECT COUNT(*) FROM (" + sql  + ") AS temp_table";
		}
	}

	public int getRecordCount() {
		return recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (this.pageNo != pageNo) {
			this.pageNo = pageNo;
			setInternalPageResult();
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	private void setInternalPageResult() {
		if (pageNo <= 1) {
			result = dataAccess.queryForAcResult(sql + " limit " + pageSize,
					values, dateFormat);
		} else {
			result = dataAccess.queryForAcResult(sql + " limit "
					+ ((pageNo - 1) * pageSize) + "," + pageSize, values,
					dateFormat);
		}
	}
	
	// page_no base 1
	public AcResult getPageResult() {
		return result;
	}

	public void setPageStringViewMode(int viewMode) {
		pageStringViewMode = viewMode;
	}

	// get array of page_no and url
	private String[][] getPageNoAndURL() {
		if (pageCount <= 1)
			return null;

		String pageNoAndURL[][];
		int[] pageNoList = new int[] { pageNo - 1, 1, 2, pageNo - 2,
				pageNo - 1, pageNo, pageNo + 1, pageNo + 2, pageCount - 1,
				pageCount, pageNo + 1 };
		int length = 0;
		for (int i = 0; i < pageNoList.length; i++) {
			if (pageNoList[i] < 1 || pageNoList[i] > pageCount || i > 2
					&& i < 10 && pageNoList[i] <= 2 || i > 3 && i < 8
					&& pageNoList[i] >= pageCount - 1) {
				pageNoList[i] = 0;
			} else {
				length++;
			}
		}
		pageNoAndURL = new String[length][2];
		for (int i = 0, j = 0; i < pageNoList.length; i++) {
			if (pageNoList[i] > 0) {
				pageNoAndURL[j][0] = (i == 0) ? "&laquo;上一页"
						: ((i == pageNoList.length - 1) ? "下一页&raquo;" : String
								.valueOf(pageNoList[i]));
				pageNoAndURL[j][1] = (pageNoList[i] == pageNo) ? "" : String
						.valueOf(pageNoList[i]);
				j++;
			}
		}

		return pageNoAndURL;
	}

	public void setPageURLHead(String head) {
		pageURLHead = head;
	}

	public String getPageURLString() {
		String[][] pageNoAndURL = getPageNoAndURL();
		if (pageNoAndURL == null)
			return "";

		String pageURLString;

		if (pageStringViewMode == 2) {
			pageURLString = "<div class='Pagination'>";
			for (int i = 0; i < pageNoAndURL.length; i++) {
				if (pageNoAndURL[i][1].length() == 0) {
					pageURLString += "<a href='#' class='current'>"
							+ pageNoAndURL[i][0] + "</a>";
				} else {
					pageURLString += "<a href='" + pageURLHead
							+ pageNoAndURL[i][1] + "'>" + pageNoAndURL[i][0]
							+ "</a>";
				}
			}
			pageURLString += "</div>";
		} else if (pageStringViewMode == 3) {
			// pageStringViewMode == 3,前台商品筛选结果显示
			// 没有总页数、GO项
			pageURLString = "<div class='Pagination'>";
			for (int i = 0; i < pageNoAndURL.length; i++) {
				if (pageNoAndURL[i][1].length() == 0) {
					pageURLString += "<a href='#' class='current'>"
							+ pageNoAndURL[i][0] + "</a>";
				} else {
					// 修改属性串的最后一位为页号
					pageURLString += "<a href='"
							+ pageURLHead.substring(0, pageURLHead
									.lastIndexOf('-') + 1) + pageNoAndURL[i][1]
							+ ".html'>" + pageNoAndURL[i][0] + "</a>";
				}
			}
			pageURLString += "</div>";
		} else {
			pageURLString = "<div class='Pagination'>共" + recordCount
					+ "条&nbsp;&nbsp;";
			for (int i = 0; i < pageNoAndURL.length; i++) {
				if (pageNoAndURL[i][1].length() == 0) {
					pageURLString += "<a href='#' class='current'>"
							+ pageNoAndURL[i][0] + "</a>";
				} else {
					pageURLString += "<a href='" + pageURLHead
							+ pageNoAndURL[i][1] + "'>" + pageNoAndURL[i][0]
							+ "</a>";
				}
			}
			pageURLString += "<input type='text' id='page_no' name='page_no' size='3' /><input type='button' value='Go' onClick=\"javascript:if(document.getElementById('page_no').value<="
					+ pageCount
					+ "&&document.getElementById('page_no').value>0) location.href='"
					+ pageURLHead
					+ "'+document.getElementById('page_no').value"
					+ ";\" /></div>";
		}
		return pageURLString;
	}
}
