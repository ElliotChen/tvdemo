package tw.com.tradevan.dao.impl;


import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tw.com.tradevan.dao.UserDao;
import tw.com.tradevan.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml", "classpath:/spring/applicationContext-dao.xml" })
@Transactional
public class UserDaoImplTest {
	@Autowired
	private UserDao userDao;
	@Ignore
	@Test
	public void test() {
		Assert.assertNotNull(userDao);
		User user = new User();
		user.setName("OKOK");
		user.setBirthday(new Date());
		userDao.create(user);
	}
	@Test
	public void testLoadByOid() {
		String oid = "8127eac63dd2d0f6013dd2d0f7b90000";
		User user = userDao.findByOid(oid);
		Assert.assertNotNull(user);
	}
}
