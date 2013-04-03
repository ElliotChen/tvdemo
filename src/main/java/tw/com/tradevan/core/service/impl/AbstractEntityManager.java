package tw.com.tradevan.core.service.impl;

import java.io.Serializable;
import java.util.List;

import tw.com.tradevan.core.dao.BaseDao;
import tw.com.tradevan.core.domain.support.Condition;
import tw.com.tradevan.core.domain.support.LikeMode;
import tw.com.tradevan.core.domain.support.Page;
import tw.com.tradevan.core.service.EntityManager;

public abstract class AbstractEntityManager<Entity, Oid extends Serializable, Dao extends BaseDao<Entity, Oid>>
		implements EntityManager<Entity, Oid, Dao> {
	protected Dao dao;

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public Entity findByOid(Oid oid) {
		// Business Logic
		return dao.findByOid(oid);
	}

	@Override
	public void create(Entity entity) {
		dao.create(entity);
	}

	@Override
	public void delete(Entity entity) {
		dao.delete(entity);
	}

	@Override
	public void update(Entity entity) {
		dao.update(entity);
	}

	@Override
	public void saveOrUpdate(Entity entity) {
		dao.saveOrUpdate(entity);
	}

	@Override
	public void merge(Entity entity) {
		dao.merge(entity);
	}

	@Override
	public List<Entity> listAll() {
		return dao.listAll();
	}

	@Override
	public Entity newEntityInstance() {
		return dao.newEntityInstance();
	}
	
	@Override
	public Oid newOidInstance() {
		return dao.newOidInstance();
	}
	
	@Override
	public List<Entity> listByExample(Entity example) {
		return dao.listByExample(example);
	}

	@Override
	public List<Entity> listByExample(Entity example,
			List<Condition> conditions, LikeMode mode, String[] ascOrders,
			String[] descOrders) {
		return dao.listByExample(example, conditions, mode, ascOrders,
				descOrders);
	}

	@Override
	public Page<Entity> listByPage(Page<Entity> page) {
		return dao.listByPage(page);
	}
}
