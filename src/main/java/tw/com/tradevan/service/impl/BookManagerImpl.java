package tw.com.tradevan.service.impl;

import tw.com.tradevan.core.service.impl.AbstractEntityManager;
import tw.com.tradevan.dao.BookDao;
import tw.com.tradevan.domain.Book;
import tw.com.tradevan.domain.BookPK;
import tw.com.tradevan.service.BookManager;

public class BookManagerImpl extends
		AbstractEntityManager<Book, BookPK, BookDao> implements BookManager {

}
