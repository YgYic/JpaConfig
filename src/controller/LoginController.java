package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import dao.IDomainInfoDAO;
import entity.DomainInfoEntity;

public class LoginController extends AbstractController {
	private IDomainInfoDAO 	domainInfoDAO;
	/**
	 * @return the domainInfoDAO
	 */
	public IDomainInfoDAO getDomainInfoDAO() {
		return domainInfoDAO;
	}
	/**
	 * @param domainInfoDAO the domainInfoDAO to set
	 */
	public void setDomainInfoDAO(IDomainInfoDAO domainInfoDAO) {
		this.domainInfoDAO = domainInfoDAO;
	}
	private String 		loginView;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		List<DomainInfoEntity> list = domainInfoDAO.queryByName("localDomain");
		String 			 x	  = "";
		for (DomainInfoEntity entity : list) {
			x = entity.getDomain_desc();
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

}
