package controller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import accelet.commons.database.AcResult;
import accelet.commons.database.IDataAccess;

public class TestGoController extends AbstractController {
	private IDataAccess dataAccess195;
	private IDataAccess dataAccess52;
	private String testView;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String sql = "SELECT * FROM admin_user WHERE admin_id=? ";
		AcResult dt = dataAccess195.queryForAcResult(sql, new Object[]{"sysadmin"});
		
		return new ModelAndView(this.getTestView()).addObject("a","a").addObject("dt", dt);
	}
	public IDataAccess getDataAccess195() {
		return dataAccess195;
	}
	public void setDataAccess195(IDataAccess dataAccess195) {
		this.dataAccess195 = dataAccess195;
	}
	public IDataAccess getDataAccess52() {
		return dataAccess52;
	}
	public void setDataAccess52(IDataAccess dataAccess52) {
		this.dataAccess52 = dataAccess52;
	}
	public String getTestView() {
		return testView;
	}
	public void setTestView(String testView) {
		this.testView = testView;
	}

}
