package tw.com.tradevan.core.service;

import java.io.Serializable;

import tw.com.tradevan.core.dao.BaseDao;


public interface EntityManager<Entity, Oid extends Serializable, Dao extends BaseDao<Entity, Oid>> extends BaseDao<Entity, Oid>{

}
