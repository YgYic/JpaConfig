package dao.impl;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import dao.IDomainInfoDAO;
import entity.DomainInfoEntity;

public class DomainInfoDAO extends JpaDaoSupport implements IDomainInfoDAO {

	public void save(DomainInfoEntity entity) {
		getJpaTemplate().persist(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<DomainInfoEntity> queryByName(String userName) {
		return getJpaTemplate().find("select u from DomainInfoEntity u where u.domain_name=?1", userName);
	}
	
}
