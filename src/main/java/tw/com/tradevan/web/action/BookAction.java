package tw.com.tradevan.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.tradevan.dao.BookDao;
import tw.com.tradevan.domain.Book;
import tw.com.tradevan.domain.BookPK;
import tw.com.tradevan.service.BookManager;

public class BookAction extends BaseCrudAction<Book, BookPK, BookDao, BookManager> {
	private static final long serialVersionUID = 2584487234841038536L;
	private static final Logger logger = LoggerFactory.getLogger(BookAction.class);
	@Override
	public Logger getLogger() {
		return logger;
	}

}
