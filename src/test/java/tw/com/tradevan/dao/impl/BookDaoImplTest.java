package tw.com.tradevan.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tw.com.tradevan.core.util.ApplicationContextHolder;
import tw.com.tradevan.dao.BookDao;
import tw.com.tradevan.domain.Book;
import tw.com.tradevan.domain.BookPK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml", "classpath:/spring/applicationContext-dao.xml" })
@Transactional
public class BookDaoImplTest {
	@Autowired
	private BookDao bookDao;
	
	@Test
	@Rollback(false)
	public void test() {
		Assert.assertNotNull(ApplicationContextHolder.getApplicationContext());
		BookPK pk = new BookPK("Book1",2012);
		/*
		Book book = new Book();
		book.setOid(pk);
		book.setNote("1111");
		
		bookDao.create(book);
		*/
		Book result = bookDao.findByOid(pk);
		Assert.assertNotNull(result);
	}

}
