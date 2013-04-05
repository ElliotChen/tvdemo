package tw.com.tradevan.dao.impl;

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

}
