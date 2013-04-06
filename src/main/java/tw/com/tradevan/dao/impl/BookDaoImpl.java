package tw.com.tradevan.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.tradevan.core.dao.impl.AbstractBaseDao;
import tw.com.tradevan.dao.BookDao;
import tw.com.tradevan.domain.Book;
import tw.com.tradevan.domain.BookPK;

public class BookDaoImpl extends AbstractBaseDao<Book, BookPK> implements BookDao{
	private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
	@Override
	public Logger getLogger() {
		return logger;
	}
	@Override
	protected void postCreateCriteria(Criteria criteria, Book example,
			MatchMode matchMode) {
		BookPK oid = example.getOid();
		
		if (oid == null) {
			return;
		}
		
		if (StringUtils.isNotEmpty(oid.getName())) {
			criteria.add(Restrictions.eq("oid.name", oid.getName()));
		}
		
		if (oid.getYear() != null && oid.getYear() > 0) {
			criteria.add(Restrictions.eq("oid.year", oid.getYear()));
		}
	}

	
}
