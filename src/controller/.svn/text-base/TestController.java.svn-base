package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import dao.IDomainInfoDAO;
import entity.DomainInfoEntity;

public class TestController extends AbstractController {
	private DataSource 	dataSource1;
	private String 		loginView;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Connection  conn  = null;
		String 		x	  = "";
		String sql = "select * from card_info where card_id=? limit 0,1";
		try {
			conn = dataSource1.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "CC0000027");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				x = rs.getString("order_id");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("queryForInt sql=" + sql);
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		
		return new ModelAndView(loginView).addObject("x", x);
	}
	/**
	 * @return the loginView
	 */
	public String getLoginView() {
		return loginView;
	}
	/**
	 * @param loginView the loginView to set
	 */
	public void setLoginView(String loginView) {
		this.loginView = loginView;
	}
	public DataSource getDataSource1() {
		return dataSource1;
	}
	public void setDataSource1(DataSource dataSource1) {
		this.dataSource1 = dataSource1;
	}

}
