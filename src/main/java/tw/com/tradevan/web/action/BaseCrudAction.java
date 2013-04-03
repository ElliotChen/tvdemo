package tw.com.tradevan.web.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.tradevan.core.dao.BaseDao;
import tw.com.tradevan.core.service.EntityManager;
import tw.com.tradevan.domain.User;
import tw.com.tradevan.web.kendo.DataSourceResult;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BaseCrudAction<Entity, Oid extends Serializable, Dao extends BaseDao<Entity, Oid>, Manager extends EntityManager<Entity, Oid, Dao>>
		extends BaseAction implements Preparable, ModelDriven<Entity> {
	private static final Logger logger = LoggerFactory.getLogger(BaseCrudAction.class);
	protected Manager manager;
	protected Oid oid;
	protected Entity example;
	protected Entity entity;
	
	private String orderby;
	private Integer top;
	private Integer skip;
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Oid getOid() {
		return oid;
	}

	public void setOid(Oid oid) {
		this.oid = oid;
	}

	public Entity getExample() {
		return example;
	}

	public void setExample(Entity example) {
		this.example = example;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	
	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getSkip() {
		return skip;
	}

	public void setSkip(Integer skip) {
		this.skip = skip;
	}

	@Override
	public void prepare() throws Exception {
		example = manager.newEntityInstance();
		entity = manager.newEntityInstance();
		logger.error("Info : top {}, orderby {}", top, orderby);
	}
	
	@Override
	public Entity getModel() {
		return entity;
	}
	/*******************************************************************/
	/**                         Action Method                         **/
	/*******************************************************************/
	
	public String index() {
		return INDEX;
	}

	public String ajaxPageSearch() {
		List<User> list = new ArrayList<User>();
		list.add(new User("A", new Date()));
		list.add(new User("B", new Date()));
		DataSourceResult dsr = new DataSourceResult();
		dsr.setTotal(1000);
		dsr.setData(list);
		this.setJsonObject(dsr);
		return JSON;
	}
	
}
