package tw.com.tradevan.service;

import tw.com.tradevan.core.service.EntityManager;
import tw.com.tradevan.dao.BookDao;
import tw.com.tradevan.domain.Book;
import tw.com.tradevan.domain.BookPK;

public interface BookManager extends EntityManager<Book, BookPK, BookDao> {

}
