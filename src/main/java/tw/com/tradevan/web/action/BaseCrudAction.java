package tw.com.tradevan.web.action;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.tradevan.core.dao.BaseDao;
import tw.com.tradevan.core.domain.Identifiable;
import tw.com.tradevan.core.domain.support.Page;
import tw.com.tradevan.core.service.EntityManager;
import tw.com.tradevan.web.kendo.DataSourceResult;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseCrudAction<Entity extends Identifiable<Oid>, Oid extends Serializable, Dao extends BaseDao<Entity, Oid>, Manager extends EntityManager<Entity, Oid, Dao>>
		extends JsonSupportAction implements Preparable, ModelDriven<Entity> {
	private static final long serialVersionUID = 4943140763463664219L;
	private static final Logger logger = LoggerFactory.getLogger(BaseCrudAction.class);
	protected Manager manager;
	protected Oid oid;
	protected Entity example;
	protected Entity entity;
	
	/*KendoUI Grid Parameter*/
	protected String orderby;
	protected String filter;
	protected Integer top;
	protected Integer skip;
	protected Integer page;
	protected Integer pageSize;
	
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
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	/*******************************************************************/
	/**                Struts Override Method                         **/
	/*******************************************************************/
	@Override
	public void prepare() throws Exception {
		this.getLogger().debug("prepare : oid[{}], entity[{}]",oid, entity);
		if (oid != null) {
			entity = manager.findByOid(oid);
		} else {
			oid = manager.newOidInstance();
			entity = manager.newEntityInstance();
			Oid entityOid = manager.newOidInstance();
			entity.setOid(entityOid);
		}
		//Init example for QBE
		example = manager.newEntityInstance();
		Oid exampleOid = manager.newOidInstance();
		example.setOid(exampleOid);
		this.getLogger().debug("after prepare : oid[{}], entity[{}], example[{}]",new Object[]{oid, entity, example});

		postPrepare();
	}
	
	@Override
	public Entity getModel() {
		return entity;
	}
	
	protected void postPrepare() {
		//dose nothing.
	}
	
	/*******************************************************************/
	/**                         Action Method                         **/
	/*******************************************************************/
	
	public String index() {
		return INDEX;
	}

	public String ajaxPageSearch() {
		/*
		List<User> list = new ArrayList<User>();
		list.add(new User("A", new Date()));
		list.add(new User("B", new Date()));
		DataSourceResult dsr = new DataSourceResult();
		dsr.setTotal(1000);
		dsr.setData(list);
		
		*/
		Page<Entity> sp = initPage();
		sp = this.manager.listByPage(sp);
		DataSourceResult dsr = new DataSourceResult();
		dsr.setData(sp.getResult());
		dsr.setTotal(sp.getTotalCount());
		this.setJsonObject(dsr);
		return JSON;
	}
	
	
	public String loadCreateForm() {
		return "create";
	}
	
	public String loadEditForm() {
		return "edit";
	}
	
	public String create() {
		logger.debug("CREATE Entity[{}]", entity);
		this.manager.create(entity);
		
		this.addActionMessage("Create Success!");
		this.setJsonObject(this.getActionMessages());
		return JSON;
	}

	public String update() {
		logger.debug("UPDATE Entity[{}]", entity);
		this.manager.saveOrUpdate(entity);
		
		this.addActionMessage("Update Success!");
		this.setJsonObject(this.getActionMessages());
		return JSON;
	}
	
	public String delete() {
		logger.debug("Delete Entity[{}]", entity);
		this.manager.delete(entity);
		
		this.addActionMessage("Delete Success!");
		this.setJsonObject(this.getActionMessages());
		return JSON;
	}
	
	protected Page<Entity> initPage() {
		this.getLogger().debug("Kendo Params : page {}, pageSize {}, orderby {}, filter{}", new Object[] {page, pageSize, orderby, filter});
		this.getLogger().debug("Example : [{}]", example);
		Page<Entity> sp = new Page<Entity>();
		sp.setExample(example);
		
		if (pageSize != null) {
			sp.setPageSize(pageSize);
		}
		
		if (page != null) {
			sp.setPageNo(page);
		} else {
			sp.setPageNo(1);
		}
		
		return sp;
	}
}
