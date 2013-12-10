/**
 * 
 */
package accelet.commons.database;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wang.donghui
 * 
 */
public class AcResult {
	private List<Object[]> values = new ArrayList<Object[]>();
	private String[] fieldNames = null;
	private int[] fieldTypes = null;

	public AcResult() {
	}

	public List<Object[]> getValues() {
		return values;
	}

	public void setValues(List<Object[]> values) {
		this.values = values;
	}

	public int getRecordCount() {
		return values.size();
	}

	public int getFieldCount() {
		return (fieldNames == null) ? 0 : fieldNames.length;
	}

	public String[] getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}

	public int[] getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(int[] fieldTypes) {
		this.fieldTypes = fieldTypes;
	}

	public int getFieldIndex(String fieldName) {
		if (fieldNames == null)
			return -1;
		for (int i = 0; i < fieldNames.length; i++) {
			if (fieldName.equalsIgnoreCase(fieldNames[i])) {
				return i;
			}
		}
		return -1;
	}

	// index base 0
	public Object getObject(int rowIndex, int fieldIndex) {
		if (values.size() <= rowIndex)
			return null;
		if (fieldIndex < 0)
			return null;
		if (fieldNames == null) {
			if (values.get(0).length <= fieldIndex)
				return null;
		} else {
			if (fieldNames.length <= fieldIndex)
				return null;
		}
		return values.get(rowIndex)[fieldIndex];
	}

	public Object getObject(int rowIndex, String fieldName) {
		return getObject(rowIndex, getFieldIndex(fieldName));
	}

	public String getString(int rowIndex, int fieldIndex) {
		Object o = getObject(rowIndex, fieldIndex);
		return (o == null) ? null : o.toString();
	}

	public String getString(int rowIndex, String fieldName) {
		return getString(rowIndex, getFieldIndex(fieldName));
	}
	public void setString(int rowIndex, String fieldName, String fieldValue) {
		values.get(rowIndex)[getFieldIndex(fieldName)] = fieldValue;
	}
	public int getInt(int rowIndex, int fieldIndex) {
		int n = Integer.MIN_VALUE;
		Object o = getObject(rowIndex, fieldIndex);
		if (o != null) {
			if (o instanceof Integer) {
				n = ((Integer) o).intValue();
			} else {
				try {
					n = Integer.parseInt(o.toString());
				} catch (Exception e) {
				}
			}
		}
		return n;
	}

	public int getInt(int rowIndex, String fieldName) {
		return getInt(rowIndex, getFieldIndex(fieldName));
	}

	public void add(Object[] row) {
		values.add(row);
	}

	public void remove(int rowIndex) {
		values.remove(rowIndex);
	}
	
	public AcResult clone() {
		AcResult newResult = new AcResult();
		newResult.setFieldNames(this.fieldNames);
		newResult.setFieldTypes(this.fieldTypes);
		for (int i = 0; i < this.getRecordCount(); i ++) {
			newResult.add(this.values.get(i));
		}
		return newResult;
	}
}
