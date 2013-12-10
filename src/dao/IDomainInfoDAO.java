package dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import entity.DomainInfoEntity;

@Transactional
public interface IDomainInfoDAO {
	public void save(DomainInfoEntity entity);
	public List<DomainInfoEntity> queryByName(String userName);
}
